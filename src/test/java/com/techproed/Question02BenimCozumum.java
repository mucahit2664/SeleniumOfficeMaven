package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question02BenimCozumum {
    /*
BeforeClass ile driver ı oluşturun.
Maximize edin, 10 sn bekletin
AfterClass ile kapatın
Google'a gidin
1. olarak zoom 'u aratıp çıkan sonuç sayısını ekrana yazdırın
2. olarak Selenium 'u aratıp çıkan sonu sayısını ekrana yazdırın.
3. olarak Techproeducation'u aratıp çıkan sonuç sayısını ekrana yazdırın.
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void zoomTeST(){
        driver.get("http://www.google.com");
        WebElement searcHbOX=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searcHbOX.sendKeys("zoom"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.id("result-stats"));
        System.out.println( sonucYazisi.getText());
    }
    @Test
    public void seleniumTest(){
        driver.get("http://www.google.com");
        WebElement searcHbOX=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searcHbOX.sendKeys("Selenium"+Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.id("result-stats"));
        System.out.println( sonucYazisi.getText());
   }
    @Test
    public void techProedTest(){
        driver.get("http://www.google.com");
        WebElement searcHbOX=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searcHbOX.sendKeys("Techproeducation"+Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.id("result-stats"));
        System.out.println(sonucYazisi.getText());
    }

    @AfterClass
    public static  void tearDown(){
driver.quit();
    }
}
