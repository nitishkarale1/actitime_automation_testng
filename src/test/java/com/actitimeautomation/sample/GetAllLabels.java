package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetAllLabels extends BaseClass
{
    static WebDriver driver;
    public  GetAllLabels()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException {
        new GetAllLabels();

        driver.get("https://facebook.com");

        List<WebElement> labelList = driver.findElements(By.tagName("input"));
        System.out.println(labelList.size());
        int count=0;
        for(WebElement element:labelList)
        {
            String label = element.getAttribute("placeholder");

            if(label != null && !label.isBlank())
            {
                System.out.println(label);
            }
            else if (label == null || label.isBlank())
            {
                count++;
            }
        }
        System.out.println("blank labels: "+count);
        Thread.sleep(3000);
        driver.quit();
    }
}
