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

public class Question04Homework {
    /*
www.bestbuy.com'a gidin
 Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
 logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
  mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void tets(){
        driver.get("http://www.bestbuy.com");
       // Sayfa başlığının “Best” içerdiğini(contains) doğrulayın
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Best"));
       // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
        WebElement logoTest=driver.findElement(By.className("logo"));
        Assert.assertTrue(logoTest.isDisplayed());
        //mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
        WebElement mexicoLinkTest= driver.findElement(By.xpath("//img[@src='https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/mexico.svg']"));
Assert.assertTrue(mexicoLinkTest.isDisplayed());

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
