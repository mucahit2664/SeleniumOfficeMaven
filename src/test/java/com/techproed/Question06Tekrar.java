package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question06Tekrar {
    /*
     Google'a gidelim
     LOgosunun görünüp görünmediğini assert edelim
      */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        // driver'ı kullanılabilir hale getirdik.
        WebDriverManager.chromedriver().setup();
        // driver nesnesini oluşturalım
        driver = new ChromeDriver();
        // driver'a ait komutları girelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(10000);
        WebElement logo = driver.findElement(By.id("hplogo"));

        boolean gorunuyorMu = logo.isDisplayed();
        // testin sonucunun true yada false olması drumunua göre değişecek.

        Assert.assertTrue(gorunuyorMu);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


}
