package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class WindowHandlingExamples extends BaseClass
{
    static WebDriver driver;
    public  WindowHandlingExamples()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException
    {
        new WindowHandlingExamples();
        driver.manage().window().maximize();
        //navigate to website
        driver.navigate().to("https://online.actitime.com/nk18/login.do");

        //get the ID of current window
        String parentWindowId = driver.getWindowHandle();

        //open new window
       // driver.switchTo().newWindow(WindowType.WINDOW);

        //open new Tab
        driver.switchTo().newWindow(WindowType.TAB);

        //navigate to "makemyTrip.com" in new window
        driver.get("https://makemytrip.com");

        //print the title of the current page
        System.out.println(driver.getTitle());

        //print the URL of the curernt page
        System.out.println(driver.getCurrentUrl());

        //close newly opened Tab
        driver.close();

        //switch control to main/parent window
        driver.switchTo().window(parentWindowId);

        //print the parent page title
        System.out.println(driver.getTitle());

        Thread.sleep(2000);

        driver.close();
    }
}
