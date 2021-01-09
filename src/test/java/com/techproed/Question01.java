package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question01 {
    /*
        @BeforeClass ın içerisinde driver ı kuralım
        maximize edip tüm we elementler yüklenene kadar 10 sn bekletelim
        Google 'a gidelim ve sayfa başlığının Google içerdiğini doğrulayalım
        Amazon'a gidelim ve url in www.amazon.com içerip içermediğini doğrulayalım
        @AfterClass ta driver ı kapatalım
         -- From stratch
         @Test
         */
    static WebDriver driver;

    // instance ve static olarak tanımladık bu şekilde nesne üretmeye gerek kalmadan her yerden erişilebilir olduk.
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
        // Google'a gidelim ve sayda basligi icin assertion yapalım
        driver.get("http://www.google.com");
        String titleGoogle = driver.getTitle();
        Assert.assertTrue(titleGoogle.contains("Google"));
    }

    @Test
    public void test02() {
        //Amazon'a gidelim ve url in www.amazon.com içerip içermediğini doğrulayalım

        driver.get("http://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();

    }
}
