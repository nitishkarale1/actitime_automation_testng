package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExamples extends BaseClass
{
    static WebDriver driver;

    public  JavaScriptExamples()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }

    public static void main(String[] args)
    {
        new JavaScriptExamples();
        driver.get("https://online.actitime.com/nitishkarale/login.do");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='nitish18';", driver.findElement(By.id("username")));
        js.executeScript("arguments[0].value='nkhonor8pro';", driver.findElement(By.name("pwd")));
        js.executeScript("arguments[0].click();", driver.findElement(By.id("loginButton")));
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);
        driver.close();
    }
}
