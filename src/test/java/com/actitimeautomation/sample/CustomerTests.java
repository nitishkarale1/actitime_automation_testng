package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CustomerTests extends BaseClass
{
    static  WebDriver driver;
    public CustomerTests()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException
    {
        new CustomerTests();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Launch website
        driver.get("https://online.actitime.com/nk18/login.do");

        //Create object of LoginPage class
        LoginPage loginPage=new LoginPage(driver);
        //Perform login operation
        loginPage.login("nitish1810", "nkhonor8pro");

        AddCustomer cust=new AddCustomer(driver);
        AddProject addProject=new AddProject(driver);
        TasksPage taskPage=new TasksPage(driver);
        ProjectPage projectPage=new ProjectPage(driver);
        cust.clickOnTasksModeule();

        String existingCustomerName=taskPage.getActualCustomer("Google");
        if(!existingCustomerName.equals("Google"))
        {
            taskPage.clickOnAddNewButton();
            cust.clickOnNewCustomerButton();
            cust.enterCustomerName("Google");
            cust.enterCustomerDescription("Development of Android Applications");
           // Thread.sleep(2000);
            cust.scrollDown();
            Thread.sleep(2000);
            cust.clickOnCreateCustomerButton();

            //verify created customer is displayed or not
            if(taskPage.getActualCustomerElement().isDisplayed())
            {
                String customerName=taskPage.getActualCustomerElement().getText();
                System.out.println("Customer with name "+"\""+customerName+"\""+" created and displayed successfully.");

                if(customerName.equals("Google"))
                {
                    //System.out.println("Customer with name "+"\""+customerName+"\""+" created successfully.");

                    addProject.clickOnAddNewButton();
                    addProject.clickOnNewProjectButton();
                    addProject.enterProjectName("AllenTech");

                   // addProject.addProjectDescription("This project is of e-learning domain.");
                    addProject.enterFirstTaskName("Development of XYZ Module");
                  //  addProject.addTypeOfWork1();
                    addProject.enterSecondTaskName("Testing of ABC Module");
                   // addProject.addTypeOfWork2();
                    Thread.sleep(2000);
                    addProject.clickOncreateProjectButton();
                    Thread.sleep(3000);

                    //verify project is displayed or not
                    if(projectPage.getProjectElement("AllenTech").isDisplayed())
                    {
                        String projectName=projectPage.getProjectElement("AllenTech").getText();
                        System.out.println("Project with name "+"\""+projectName+"\""+" created and displayed successfully.");

                        //verify project is created or not
                        if(projectPage.getProjectElement("AllenTech").getText().equals("AllenTech"))
                        {
                            //System.out.println("Project with name "+"\""+projectName+"\""+" created successfully.");
                            Thread.sleep(3000);

                            //verify Task1 is displayed or not
                            if(projectPage.getActualTaskElement("Development of XYZ Module").isDisplayed())
                            {
                                //verify Task1 is created or not
                                if(projectPage.getActualTaskElement("Development of XYZ Module").getText().equals("Development of XYZ Module"))
                                {
                                    System.out.println("Task1: Development of XYZ Module - created successfully.");
                                }
                                else
                                {
                                    System.out.println("Task1: Development of XYZ Module - not created.");
                                }
                            }
                            else
                            {
                                System.out.println("Task1: Development of XYZ Module - not displayed.");
                            }

                            //verify Task2 is displayed or not
                            if(projectPage.getActualTaskElement("Testing of ABC Module").isDisplayed())
                            {
                                //verify Task2 is created or not
                                if(projectPage.getActualTaskElement("Testing of ABC Module").getText().equals("Testing of ABC Module"))
                                {
                                    System.out.println("Task2: Testing of ABC Module - created successfully.");
                                }
                                else
                                {
                                    System.out.println("Task2: Testing of ABC Module - not created.");
                                }
                            }
                            else
                            {
                                System.out.println("Task2: Testing of ABC Module - not displayed.");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Project not displayed.");
                    }
                }
                else
                {
                    System.out.println("Customer not created.");
                }
            }
            else
            {
                System.out.println("Customer not displayed.");
            }
        }
        else
        {
            System.out.println(existingCustomerName);
            System.out.println("Customer with name "+"\""+existingCustomerName+"\""+" already exist, Please use different name");
        }
        Thread.sleep(3000);
        driver.close();
    }
}