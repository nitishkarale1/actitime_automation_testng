package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends BaseClass
{
    WebDriver driver;
    PropertyHandling propertyHandling;
    CommonUtil commonUtil;
    @BeforeClass
    public void setUp() throws IOException
    {
        launchBrowser("chrome");
        driver = super.driver;
        propertyHandling = new PropertyHandling();
        commonUtil = new CommonUtil(driver);
        driver.manage().window().maximize();
        driver.navigate().to(propertyHandling.getProperty("actitimeUrl"));
    }
    @Test(priority = 1)
    public void verifyLogin() throws Exception
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(propertyHandling.getProperty("username"), propertyHandling.getProperty("password"));
        //loginPage.login("nitish1810", "nkhonor8pro");

        commonUtil.waitForElementToPresent(By.xpath("//span[contains(@class,'WeekPicker-weeks')]"));
        WebElement date = driver.findElement(By.xpath("//span[contains(@class,'WeekPicker-weeks')]"));
        System.out.println(date.getText());
        Assert.assertTrue(date.isDisplayed(),"failed: date is not displayed.");

//        if(date.isDisplayed())
//        {
//            Reporter.log("Actitime Logged in Successfully...!", true);
//        }
//        else
//        {
//            Reporter.log("Actitime not Logged in...!", true);
//        }
        // System.out.println("Actitime Logged in Successful...!");
    }

    @Test(priority = 2)
    public void verifyLogout() throws InterruptedException {
        LogoutPage logout=new LogoutPage(driver);
        logout.logoutPage();

        commonUtil.waitForElementVisible(driver.findElement(By.id("headerContainer")));
        String actText = driver.findElement(By.id("headerContainer")).getText();
        String expText = "Pleasee identify yourself";
        System.out.println(actText);

        SoftAssert sa=new SoftAssert();
        sa.assertEquals(actText,expText,"failed: actual and expected texts are not matching.");
    }

    @AfterClass
    public void closwBrowser() throws InterruptedException
    {
        Thread.sleep(2000);
        Reporter.log("Browser closed Successfully...!", true);
        driver.close();
    }

//        WebDriver driver=new FirefoxDriver();
//        driver.get("https://online.actitime.com/nitishkarale/login.do");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
////        WebElement username =driver.findElement(By.id("username"));
////        username.sendKeys("nitish18");
//        driver.findElement(By.id("username")).sendKeys("nitish18");
//        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
//        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
//
//        Thread.sleep(8000);
//        //Logout application
//        driver.findElement(By.id("logoutLink")).click();
//
//       //Scenario2: verify login feature error message with Invalid username & valid password
//        driver.findElement(By.id("username")).sendKeys("abc123");
//        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
//        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
//
//        Thread.sleep(5000);
//
//        //get error message
//        String errorMsg1=driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
//        System.out.println(errorMsg1);
//
//        //verify error messgae
//        if(errorMsg1.equals("Username or Password is invalid. Please try again."))
//        {
//            System.out.println("Succefully verified error message.");
//        }
//        else
//        {
//            throw new Exception("Actual and Expected error message did not matched");
//        }
//
//        //Scenario3: verify login feature error message with blank username & valid password
//        driver.findElement(By.name("pwd")).sendKeys("nkhonor8pro");
//        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
//
//        //verify error messgae
//        if(driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).isDisplayed())
//        {
//            String errorMsg2=driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
//            //verify error message
//            if(errorMsg2.equals("Username or Password is invalid. Please try again."))
//            {
//                System.out.println("Successfully verified error message.");
//            }
//            else
//            {
//                throw new Exception("Actual and Expected error message did not matched.");
//            }
//        }
//        else
//        {
//            throw new Exception("Error message did not Displayed on webpage.");
//        }
//
//        Thread.sleep(2000);
//        driver.close();


}
