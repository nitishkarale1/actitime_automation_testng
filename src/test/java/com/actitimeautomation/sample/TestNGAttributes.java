package com.actitimeautomation.sample;

import org.testng.annotations.*;

public class TestNGAttributes
{
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("This is before suite");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("This is after suite");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("This is before test");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("This is after test");
    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("This is before class");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is after class");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("This is before method");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("This is after method");
    }
    @Test(priority = 2, enabled = false)
    public void verifyLogin()
    {
        System.out.println("This is verify login method");
    }
    @Test(priority = 1, dependsOnMethods = "login")
    public void verifyTask()
    {
        System.out.println("This is verify task method");
    }
    @Test(priority = 1)
    public void login()
    {
        System.out.println("This is login method");
    }
    @Test(priority = 4, dependsOnMethods = {"login"})
    public void logout()
    {
        System.out.println("This is logout method");
    }
}
