package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProject
{
    WebDriver driver;
    public AddProject(WebDriver driver)
    {
        this.driver=driver;
    }

    //click on Add New button
    public void clickOnAddNewButton()
    {
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
    }

    //click on New Project button
    public void clickOnNewProjectButton()
    {
        driver.findElement(By.xpath("//div[@class='item createNewProject']")).click();
    }

    //enter project name
    public void enterProjectName(String projectName)
    {
        driver.findElement(By.xpath("//div[@class='sectionDetails']/input")).sendKeys(projectName);
    }

    //add project description
    public void addProjectDescription(String ProjectDescription)
    {
        driver.findElement(By.xpath("//div[@class='projectDescriptionField']/descendant::div[2]")).sendKeys(ProjectDescription);
    }

    //create first task
    public  void enterFirstTaskName(String taskName1)
    {
        driver.findElement(By.xpath("(//input[@type='text' and @placeholder='Enter task name'])[1]")).sendKeys(taskName1);
    }

    //add type of work for first task
    public void addTypeOfWork1()
    {
        driver.findElement(By.xpath("(//div[@class='typeOfWorkButton editable'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='typeOfWorkList'])[2]/div[5]")).click();
    }


    //create second task
    public  void enterSecondTaskName(String taskName2)
    {
        driver.findElement(By.xpath("(//input[@type='text' and @placeholder='Enter task name'])[2]")).sendKeys(taskName2);
    }

    //add type of work for second task
    public void addTypeOfWork2()
    {

        driver.findElement(By.xpath("(//div[@class='typeOfWorkButton editable'])[2]")).click();
        driver.findElement(By.xpath("((//div[@class='taskTable'])[1]//div[@class='contentWrapper '])[1]//div[contains(@class,'typeOfWorkRow')][5]")).click();
    } //div[@class='components_typeOfWorkSelector'])[2]//div[contains(@class,'typeOfWorkRow')][5]

    //click on create project button
    public  void clickOncreateProjectButton()
    {
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
    }
}