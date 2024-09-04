package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownExamples extends BaseClass
{
    static WebDriver driver;
    public DropdownExamples()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws Exception
    {
        new DropdownExamples();
        driver.manage().window().maximize();
        driver.get("https://amazon.in");

       // WebElement dropDownElement = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));

        //verify that dropdown is multislectable or not
        System.out.println(select.isMultiple());

//        select.selectByValue("search-alias=stripbooks");
//
//        select.selectByIndex(12);

//        select.deselectByVisibleText("Appliances");
//        select.deselectByValue("search-alias=appliances");
//        select.deselectByIndex(8);

//        select.deselectAll();


        List<WebElement> valueList = select.getOptions();

        System.out.println("total values in Dropdown: "+valueList.size());

        for(WebElement value:valueList)
        {
            System.out.println(value.getText());

            if(value.getText().equals("Books"))
            {
                select.selectByVisibleText("Books");

                List<WebElement> selectedValues = select.getAllSelectedOptions();
                WebElement SelectedValue= selectedValues.get(0);
               String val = SelectedValue.getText();

               if(val.equals("Books"))
               {
                   System.out.println("Successfully selected Books value from dropdown");
               }
               else
               {
                   throw  new Exception("Unable to select Books value from dropdown");
               }
               break;
            }
        }
        //enter value in search field
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
        //click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
