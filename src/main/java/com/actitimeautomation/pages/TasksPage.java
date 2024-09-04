package com.actitimeautomation.pages;

import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class TasksPage {
    WebDriver driver;
    CommonUtil commonUtil;
    public TasksPage(WebDriver driver)
    {
        this.driver = driver;
    }
    //click on Add New button
    public void clickOnAddNewButton()
    {
        driver.findElement(By.xpath("//div[@class='title ellipsis' and text()='Add New']")).click();
    }
    //get actual customer element
    public String getActualCustomer(String expCustomerName) {
        String existingCustomerName = "";
        List<WebElement> customersList = driver.findElements(By.xpath("//div[contains(@class,'node customerNode')]//div[@class='text']")); // one more x path - //div[contains(@class,'allCustomersNode')]/following-sibling::*
        for (WebElement customer : customersList)
        {     // //div[@class='unfilteredContainer']/descendant::div[4]/div/following-sibling::div
            //this.customer=customer;
            String actualCustomerName1 = customer.getText();
            if (actualCustomerName1.equals(expCustomerName)) {
                existingCustomerName = actualCustomerName1;
            }
        }
        return existingCustomerName;
    }

    public void clickOnCustomerCollapseButton() throws InterruptedException
    {
        List<WebElement> allCollapseButtons = driver.findElements(By.xpath("//div[@class='unfilteredContainer']//div[@class='collapseButton']"));
        for(WebElement element:allCollapseButtons)
        {
            element.click();
            Thread.sleep(1000);
        }
    }

    public WebElement getActualCustomerElement()
    {
        return driver.findElement(By.xpath("//div[@class='text' and text()='Google']"));
    }


//    click on customer
//    public void clickOnCustomer()
//    {
//        driver.findElement(By.xpath("//div[text()=\"Google\"]")).click();
//    }

}
