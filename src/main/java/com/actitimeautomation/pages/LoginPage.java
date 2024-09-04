package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void login(String userName, String password)
    {
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
    }
}
