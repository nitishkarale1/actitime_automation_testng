package com.actitimeautomation.pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeTimeTrackPage
{

    @FindBy(xpath = "//td[@class='profileCell preventPanelsHiding']//a[@class='userProfileLink username ']")
    private WebElement username;

    public ActitimeTimeTrackPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public String getActitimeUsername()
    {
        return username.getText();
    }
}
