package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AddCustomer
{
    WebDriver driver;

    public AddCustomer(WebDriver driver)
    {
        this.driver=driver;
    }

    //Click on Tasks module
    public  void clickOnTasksModeule()
    {
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
    }

    //click on Add New button
    public void clickOnAddNewButton()
    {
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
    }

    //click on New Customer button
    public void clickOnNewCustomerButton()
    {
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
    }

    //Enter customer name
    public void enterCustomerName(String custName) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@class,'inputFieldWithPlaceholder') and @ placeholder='Enter Customer Name']")).sendKeys(custName);
    }

    //Enter customer description
    public void enterCustomerDescription(String description)
    {
        driver.findElement(By.xpath("//textarea[@class='textarea' and @placeholder='Enter Customer Description']")).sendKeys(description);
    }

    //scroll down
    public void scrollDown()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");
    }

    //click on create customer button
    public void clickOnCreateCustomerButton()
    {
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
    }
}
