package com.actitimeautomation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass
{
    public WebDriver driver;

    public void launchBrowser(String browserName)
    {
        switch (browserName)
        {
            case "chrome" : driver=new ChromeDriver();
            break;

            case "firefox" : driver=new FirefoxDriver();
            break;

            case "edge" : driver=new EdgeDriver();
        }
    }
}
