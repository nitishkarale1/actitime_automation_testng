package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage
{
    WebDriver driver;
    public LogoutPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void logoutPage()
    {
        driver.findElement(By.id("logoutLink")).click();
    }
}
