package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question02 {
    /*
BeforeClass ile driver ı oluşturun.
Maximize edin, 10 sn bekletin
AfterClass ile kapatın
Google'a gidin
1. olarak zoom 'u aratıp çıkan sonuç sayısını ekrana yazdırın
2. olarak Selenium 'u aratıp çıkan sonu sayısını ekrana yazdırın.
3. olarak Techproeducation'u aratıp çıkan sonuç sayısını ekrana yazdırın.
​
 */
    static WebDriver driver;

        @BeforeClass
        public static void setUp (){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @Before // Before ve After her testten önce ve sonra çalışır.
        public void testtenOnce(){
            driver.get("http://www.google.com");

        }
        @Test
        public void test01(){
            WebElement aramaKutusu = driver.findElement(By.name("q"));
            aramaKutusu.sendKeys("zoom");
            aramaKutusu.submit();

        }
        @Test
        public void test02(){
            WebElement aramaKutusu = driver.findElement(By.name("q"));
            aramaKutusu.sendKeys("Selenium"+ Keys.ENTER);

        }
        @Test
        public void test03(){
            WebElement aramaKutusu = driver.findElement(By.name("q"));
            aramaKutusu.sendKeys("Techproeducation");
            aramaKutusu.submit();
        }
        @After
        public void sonucYazdirma(){
            WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
            System.out.println(sonucSayisi.getText());
        }
        @AfterClass
        public static void tearDown(){
            driver.quit();

        }
}