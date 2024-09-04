package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TaskTests extends BaseClass
{
    WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    @BeforeMethod
    public void loginToApplication()
    {
        //Create object of LoginPage class
        LoginPage loginPage=new LoginPage(driver);
        //Perform login operation
        loginPage.login("nitish1810", "nkhonor8pro");
    }

    @Test
    public void verifyAllCheckBoxesSelectedOrNot() throws InterruptedException
    {
        //wait for 5 seconds
        Thread.sleep(5000);

        //Click on Tasks module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();

        //wait for 5 seconds
        Thread.sleep(5000);

        //Locate and verify select all checkbox is displayed or not
        boolean selectAllCheckbox=driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).isDisplayed();

        if(selectAllCheckbox)
        {
            //Click on select all checkbox
            driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();

            //wait for 5 seconds
            Thread.sleep(5000);

            //Verify select all checkbox is selected or not
            boolean selectedCheckbox=driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).isSelected();
            System.out.println(selectedCheckbox);
            if(selectedCheckbox)
            {
                System.out.println("All checkboxes are selected.");
            }
            else
            {
                System.out.println("Unable to select all checkboxes.");
            }
        }

        else
        {
            System.out.println("Unable to display select all checkbox hence unable to perform further operations.");
        }
    }
    @AfterMethod
    public void logoutFromApplication()
    {
        LogoutPage logout = new LogoutPage(driver);
        logout.logoutPage();
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
