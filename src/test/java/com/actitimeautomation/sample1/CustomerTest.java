package com.actitimeautomation.sample1;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.TasksPage;
import com.actitimeautomation.pages1.Customerpage;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CustomerTest extends BaseClass
{
    WebDriver driver;
    PropertyHandling propertyHandling;

    LoginPage loginPage;
    Customerpage customerpage;
    TasksPage tasksPage;
    CommonUtil commonUtil;

    @BeforeClass
    public void setUp() throws IOException
    {
        propertyHandling = new PropertyHandling();
        launchBrowser("chrome");
        driver = super.driver;
        commonUtil = new CommonUtil(driver);
        driver.get(propertyHandling.getProperty("actitimeUrl"));
        commonUtil.maximizeWindow();
        commonUtil.implicitWait();
        loginPage = new LoginPage(driver);
        loginPage.login(propertyHandling.getProperty("username"),propertyHandling.getProperty("password"));
        customerpage = new Customerpage(driver);
        tasksPage = new TasksPage(driver);

    }
    @BeforeMethod
    public void createNewCustomer() throws InterruptedException
    {
        customerpage.createCustomer("Atlas labs");
    }
    @Test
    public void verifyCreatedCustomer() throws Exception {
        try
        {
            String expCustName = "Atlas labs";
            SoftAssert sa = new SoftAssert();

            String actualCustomer = customerpage.getCreatedCustomer(driver);
            sa.assertEquals(actualCustomer,expCustName, "Failed: Actual and Expected customer name not matched.");
            sa.assertAll();
        }
        catch (Exception e)
        {
            throw new Exception("Customer already exist");
        }
    }
    @AfterClass
    public void tearDown()
    {
        customerpage.logOutApplication();
        driver.quit();
    }
}
