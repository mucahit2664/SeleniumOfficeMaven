package com.techproed;

import com.google.common.collect.Lists;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Question03Tekrar {
    // 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books seçelim.
// kategorilerin hepsini konsola yazdıralım
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalım.
// 4. Sonuç sayısını ekrana yazdıralım.
// Sonuçların Les Miserables i içerdiğini assert edelim
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        driver.get("http://www.amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> list = select.getOptions();
        for (WebElement w:list) {
            System.out.println(w.getText());
        }
        select.selectByVisibleText("Books");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Les Miserables");
        searchBox.submit();
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());
        Assert.assertTrue(sonucSayisi.getText().contains("Les Miserables"));
        Assert.assertEquals("les Misreables icermez",sonucSayisi.getText().contains("Les Miserables"),true);


    }

    @AfterClass
    public static void tearDown(){
        driver.quit();

    }
}
