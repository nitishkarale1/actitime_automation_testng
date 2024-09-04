package com.actitimeautomation.pages1;

import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.pages.TasksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class Customerpage
{
    @FindBy(xpath = "//div[text()='Tasks']")
    WebElement tasksModule;
    @FindBy(xpath = "//div[text()='Add New']")
    WebElement addNewButton;
    @FindBy(xpath = "//div[contains(text(),'New Customer')]")
    WebElement newCustomer;
    @FindBy(xpath = "//input[contains(@class,'inputFieldWithPlaceholder') and @placeholder='Enter Customer Name']")
    WebElement enterCustomerName;
    @FindBy(xpath = "//div[text()='Create Customer']")
    WebElement createCustomerButton;
    @FindBy(xpath = "//div[@class='searchFieldContainer']//input")
    WebElement searchBox;
    @FindBy(xpath = "(//div[@class='title']//div[@class='text'])[1]")
    WebElement matchedCustomer;
    @FindBy(xpath = "//div[@class='node customerNode editable selected']//div[@class='text']")  //div[@class='text']/span[@class='highlightToken']
    WebElement actCustomerElement;

    @FindBy(id = "logoutLink")
    WebElement logOutButton;

    CommonUtil commonUtil;

    public Customerpage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        commonUtil = new CommonUtil(driver);
    }

    public void createCustomer(String customerName)
    {
        commonUtil.waitForElementVisible(tasksModule);
        tasksModule.click();
        commonUtil.fluentWait(addNewButton);
        addNewButton.click();
        newCustomer.click();
        commonUtil.waitForElementVisible(enterCustomerName);
        enterCustomerName.sendKeys(customerName);
        createCustomerButton.click();
    }

    public String getCreatedCustomer(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBox.sendKeys("Atlas labs");
        commonUtil.waitForElementVisible(actCustomerElement);
        String createdCustomer = actCustomerElement.getText();
       return createdCustomer;
    }
    public void logOutApplication()
    {
        logOutButton.click();
    }
}