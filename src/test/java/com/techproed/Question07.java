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

public class Question07 {
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
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://www.amazon.com");
        String titleAmazon = driver.getTitle();
        System.out.println(titleAmazon);
        Thread.sleep(5000);
        softAssert.assertTrue(titleAmazon.contains("Amazon"));
        softAssert.assertFalse(titleAmazon.contains("Car"));
        softAssert.assertTrue(titleAmazon.contains("Online"));
        softAssert.assertAll();

    }

    @Test
    public void test02() {  
        /*
         http://a.testaddressbook.com/sign_in adresine gidelim
       mail olarak testtechproed@gmail.com girelim
       Başlığın "Deneme" 'ye eşit olup olmadığını kontrol edelim
       Şifre bölümüne Test1234! i gönderelim
       Title'ın Address book e eşit olup olmadığını assert edelim
       Sign in olalaım
       Ve doğru bir şekilde giriş yapıp yapamadığımızı kontrol edelim
         */
        //input[@type='email']
        // session_password

        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@type='email']"));
        emailKutusu.sendKeys("testtechproed@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        // softAssert.assertEquals(driver.getTitle(),"Deneme");
        String baslik = driver.getTitle();
        System.out.println(baslik);
        softAssert.assertFalse(baslik.contains("Deneme"));

        WebElement password = driver.findElement(By.id("session_password"));
        password.sendKeys("Test1234!");
        String baslik2 = driver.getTitle();
        System.out.println(baslik2);
        softAssert.assertTrue(driver.getTitle().contains("Address Book"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        WebElement signIn = driver.findElement(By.name("commit"));
        signIn.click();
        WebElement signOutLink = driver.findElement(By.linkText("Sign out"));
        boolean gorunuyorMu = signOutLink.isDisplayed();
        softAssert.assertTrue(gorunuyorMu);
        softAssert.assertAll();
    }
        @AfterClass
                public void tearDown(){
            driver.quit();


        }
    }

