package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question01BenimCozumum {
   /*
@BeforeClass ın içerisinde driver ı kuralım
maximize edip tüm we elementler yüklenene kadar 10 sn bekletelim
Google 'a gidelim ve sayfa başlığının Google içerdiğini doğrulayalım
Amazon'a gidelim ve url in www.amazon.com içerip içermediğini doğrulayalım
@AfterClass ta driver ı kapatalım
 -- From stratch
 */
    static WebDriver driver;
    //instance ve static olarak tanimladik bu sekilde nesne uretmeeye kalmadan her yerden erisilebilirolduk
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }
@Test
public void test(){
    driver.get("https://www.google.com/");
    String googleTitle=driver.getTitle();
    String expectedTitle="Google";
    Assert.assertTrue(googleTitle.contains(expectedTitle));

    driver.get("https://www.amazon.com/");
    String amazonURL=driver.getCurrentUrl();
    String arananURL="www.amazon.com";

    Assert.assertTrue(amazonURL.contains(arananURL));
}





    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
