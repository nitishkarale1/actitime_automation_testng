package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetAllLinks extends BaseClass
{
    static WebDriver driver;

    public GetAllLinks()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException {
        new GetAllLinks();

        driver.navigate().to("https://facebook.com");

        List<WebElement> allLinkElements = driver.findElements(By.tagName("a"));

        System.out.println(allLinkElements.size());

        for(WebElement element:allLinkElements)
        {
            String link = element.getAttribute("href");
            System.out.println(link);
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
