package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsOperationsGayatri extends BaseClass
{
    WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        /* launch the browser */
        launchBrowser("chrome");
        driver=super.driver;

    }
    @Test
    public void verifyWindowHandling() throws InterruptedException
    {
        //navigate to website
        driver.navigate().to("https://online.actitime.com/testng/login.do");
//        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
        String parentWindowId=driver.getWindowHandle();

        System.out.println(parentWindowId);
        //get all window ids
        Set<String> allWindowsIds=driver.getWindowHandles();
        System.out.println(allWindowsIds);

        //iterate for all ids
        for(String id :allWindowsIds)
        {//check id is not equals to parent id
            if(!id.equals(parentWindowId))
            {
                System.out.println("second tab id: "+id);

                driver.switchTo().window(id);

                String childWindowTitle = driver.getTitle();
                System.out.println("second tab title: " + childWindowTitle);

                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentWindowId);
        System.out.println("parent tab title:"+driver.getTitle());
    }
    @AfterClass
    public void tearDown() throws InterruptedException, InterruptedException
    {
        Thread.sleep(5000);
        driver.quit();
    }
}

