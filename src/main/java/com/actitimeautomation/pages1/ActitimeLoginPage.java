package com.actitimeautomation.pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ActitimeLoginPage
{
    @FindBy(id = "username")
    public WebElement userName;
    @FindBy(name = "pwd")
    private WebElement password;
    @FindBy(xpath = "//div[text()='Login ']")
    private WebElement loginButton;

    public ActitimeLoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void actitimeLogin(String un, String pwd)
    {
        userName.sendKeys(un);
        password.sendKeys(pwd);
        loginButton.click();
    }
}
