package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUpScrollDown extends BaseClass
{
    static WebDriver driver;
    public ScrollUpScrollDown()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws Exception
    {
        new ScrollUpScrollDown();
        driver.get("https://amazon.in");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down using javascript
        js.executeScript("window.scrollBy(0, 2000);");
        Thread.sleep(3000);
        //scroll up using javascript
        js.executeScript("window.scrollBy(0,-1000);");
        //scroll right using javascript
        js.executeScript("window.scrollBy(500,0);");
        //scroll left using javascript
        js.executeScript("window.scrollBy(-300,0);");
    }
}
