package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Set;

public class WindowsOperations extends BaseClass
{
    WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    @Test
    public void verifyWindowHandling() throws InterruptedException
    {
        //maximize the window
        driver.manage().window().maximize();
        //navigate to website
        //driver.navigate().to("https://online.actitime.com/nitishkarale/login.do");
        driver.navigate().to("https://online.actitime.com/nk18/login.do");

        driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();

        //fetch parent windowID
        String parentWindowId = driver.getWindowHandle();

        //print parent window ID
        System.out.println("parentWindowId: " + parentWindowId);

        //get all window Id's
        Set<String> allWindowIds = driver.getWindowHandles();

        System.out.println(allWindowIds);

        for (String id : allWindowIds) {
            //verify that id is not equals to parent window id
            if (!id.equals(parentWindowId))
            {
                System.out.println("child window ID: " + id);

                //switch selenium focus from main/parent window to child window
                driver.switchTo().window(id);

                String childWindowTitle = driver.getTitle();
                System.out.println("child window title: " + childWindowTitle);

                //close curerently focused window
                driver.close();
                break;
            }
        }
        //switch control back to the parent window
        driver.switchTo().window(parentWindowId);
        //driver.switchTo().defaultContent();  // switching back the control to the parent/main window from any window.

        //get the title of the parent window/tab
        System.out.println("parent window title: " + driver.getTitle());
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("This is before Test method");
    }
    @AfterTest
    public void AfterTest() {
        System.out.println("This is After Test method");
    }
    @AfterClass
    public void tearDown() throws InterruptedException
    {
        Thread.sleep(3000);
        driver.quit();
    }
}