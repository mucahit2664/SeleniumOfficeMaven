package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Question08 {
    // Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
    // 2. Click CLICK ME of JavaScript Alert
    // 3. Get the pop up text
    // 4. Verify the Message is “I am an alert box!“
    // 5. Accept the pop up

    //Write these code in test case 2 class
    //1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
    // 2. Click CLICK ME of JavaScript Confirm Box
    //3. Get the pop up text
    // 4. Verify the Message is “Press a button“
    // 5. Dismiss the pop up
    //6. Verify the “You pressed Cancel!” is displayed
    //7. Use the dependsOnMethods accorting to alert1

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void allert1() throws InterruptedException {
        // Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
        // 2. Click CLICK ME of JavaScript Alert
        // 3. Get the pop up text
        // 4. Verify the Message is “I am an alert box!“
        // 5. Accept the pop up
        SoftAssert softAssert = new SoftAssert();
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement click1 = driver.findElement(By.id("button1"));
        click1.click();
        String msg =driver.switchTo().alert().getText();
        String expectedMes= "I am an alert box!";
        softAssert.assertTrue(msg.equals(expectedMes));
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        softAssert.assertAll();
    }

    //Write these code in test case 2 class
    //1. Go to “http://webdriveruniversity.com/Popup-Alerts/index.html”
    // 2. Click CLICK ME of JavaScript Confirm Box
    //3. Get the pop up text
    // 4. Verify the Message is “Press a button“
    // 5. Dismiss the pop up
    //6. Verify the “You pressed Cancel!” is displayed
    //7. Use the dependsOnMethods accorting to alert1

    @Test (dependsOnMethods = "allert1")
    public void allert2(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement click2 = driver.findElement(By.id("button4"));
        click2.click();
        SoftAssert softAssert = new SoftAssert();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        System.out.println(actualText);
        String expectedText = "Press a button!";
        softAssert.assertTrue(actualText.equals(expectedText));
        alert.dismiss();
        WebElement messageText = driver.findElement(By.id("confirm-alert-text"));
        softAssert.assertTrue(messageText.isDisplayed());
        softAssert.assertAll();


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
