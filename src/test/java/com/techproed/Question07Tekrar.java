package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Question07Tekrar {
      /*  Amazon'a gidelim,
       Başlığın Amazon içeriğini, Car icerdigini, Online içerdiğini kontrol edelim.
       Soft assert kullanalım
       http://a.testaddressbook.com/sign_in adresine gidelim
       mail olarak testtechproed@gmail.com girelim
       Başlığın "Deneme" 'ye eşit olup olmadığını kontrol edelim
       Şifre bölümüne Test1234! i gönderelim
       Title'ın Address book e eşit olup olmadığını assert edelim
       Sign in olalaım


     */
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("  http://amazon.com");
        String baslik=driver.getTitle();
        System.out.println(baslik);
        Thread.sleep(5000);
        softAssert.assertTrue(baslik.contains("Amazon"));
        softAssert.assertFalse(baslik.contains("Car"));
        softAssert.assertTrue(baslik.contains("Online"));

    }
    @Test
    public void test02(){
        // http://a.testaddressbook.com/sign_in adresine gidelim
        //       mail olarak testtechproed@gmail.com girelim
        //       Başlığın "Deneme" 'ye eşit olup olmadığını kontrol edelim
        //       Şifre bölümüne Test1234! i gönderelim
        //       Title'ın Address book e eşit olup olmadığını assert edelim
        //       Sign in olalaım
        driver.get("  http://a.testaddressbook.com/sign_in");
        WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        String bASLK1= driver.getTitle();
        softAssert.assertEquals(bASLK1,"Deneme");
        WebElement passwordbox=driver.findElement(By.id("session_password"));
        passwordbox.sendKeys("Test1234!");
     String baslik2=driver.getTitle();
        System.out.println(baslik2);
        softAssert.assertEquals(driver.getTitle(),"Address book");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        WebElement signIn=driver.findElement(By.name("commit"));
signIn.click();
WebElement signOut=driver.findElement(By.linkText("Sign out"));
boolean gorunuyorMu=signOut.isDisplayed();
        System.out.println(gorunuyorMu);
        softAssert.assertTrue(gorunuyorMu);
        softAssert.assertAll();

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
