package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProjectPage
{
    WebDriver driver;
    public ProjectPage(WebDriver driver)
    {
           this.driver=driver;
    }
    public WebElement getActualTaskElement(String expectedTaskName)
    {
        WebElement taskElement=null;
        List<WebElement> listOfTasks = driver.findElements(By.xpath("//div[@class='tasksTablesWrapper']//div[@class='title']"));
        for(WebElement element:listOfTasks)
        {
            if(element.getText().equals(expectedTaskName))
            {
                taskElement = element;
            }
        }
        return taskElement;
    }
    public WebElement getProjectElement(String expectedProjectName)
    {
        WebElement projectElement=null;
        List<WebElement> allProjectElement = driver.findElements(By.xpath("(//div[@class='unfilteredContainer']//div[@class='text'])"));
        for(WebElement element:allProjectElement)
        {
            if(element.getText().equals(expectedProjectName))
            {
                projectElement=element;
            }
        }
        return projectElement;
    }
}
