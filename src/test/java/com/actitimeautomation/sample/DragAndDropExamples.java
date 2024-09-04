package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExamples extends BaseClass
{
    static WebDriver driver;
    public DragAndDropExamples()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException {
        new DragAndDropExamples();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        String parentWindowId = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        //driver.switchTo().frame("");
        //driver.switchTo().frame(1);

        WebElement srcElement = driver.findElement(By.xpath("(//ul[@id='gallery']//img)[2]"));
        WebElement destElement = driver.findElement(By.id("trash"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(srcElement, destElement).perform();

       // actions.clickAndHold(srcElement).release(destElement).build().perform();

        //switch control back to WebPage
        driver.switchTo().window(parentWindowId);

        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.quit();
    }
}
