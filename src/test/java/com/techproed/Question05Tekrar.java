package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Question05Tekrar {
    // /*
    //    1.  "https://www.twitter.com" hesabına gidin
    //    2. Register butonuna tıklayın
    //    3. Kendi bilgilerinizi girerek hesap oluşturun.
    //    4. Mail seçerek yapın
WebDriver driver;
    @BeforeClass
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void register(){
        driver.get("https://www.twitter.com");
        WebElement register = driver.findElement(By.xpath("//a[@data-testid='signupButton']"));
        register.click();
////span[.='Use email instead']
        //name
        //email
        WebElement emailInstead = driver.findElement(By.xpath("//span[.='Use email instead']"));
        emailInstead.click();
        WebElement isim=driver.findElement(By.xpath("//input[@name='name']"));
        isim.sendKeys("Abdullah");
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {

        }
        WebElement eposta=driver.findElement(By.xpath("//input[@name='email']"));
eposta.sendKeys("mucahit1236gs@gmail.com");

WebElement dropDown1=driver.findElement(By.id("Month"));
WebElement dropDown2=driver.findElement(By.id("Day"));
WebElement dropDown3=driver.findElement(By.id("Year"));
        Select select=new Select(dropDown1);
        select.selectByVisibleText("April");
        Select select1=new Select(dropDown2);
        select1.selectByVisibleText("8");
        Select select2=new Select(dropDown3);
        select2.selectByVisibleText("1992");

        WebElement nextButton = driver.findElement(By.xpath("//*[text()='Next']"));
        nextButton.click();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {

        }
driver.findElement(By.xpath("//*[text()='Next']")).click();
        driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
