package com.actitimeautomation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass1
{
    public WebDriver driver;

    public void initializeBrowser(String BrowserName) throws IOException
    {
        if(BrowserName.equals("Chrome"))
        {
            driver=new ChromeDriver();
        }

        else if (BrowserName.equals("Edge"))
        {
            driver=new EdgeDriver();
        }

        else if (BrowserName.equals("Firefox"))
        {
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(UtilityClass.getConfigData("actitimeUrl"));
    }
}
