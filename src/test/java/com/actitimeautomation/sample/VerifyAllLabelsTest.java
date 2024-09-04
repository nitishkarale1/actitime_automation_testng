package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyAllLabelsTest extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;

    @BeforeClass
    public void setUp() {
        launchBrowser("chrome");
        driver = super.driver;
        driver.navigate().to("https://www.flipkart.com/");
        commonUtil = new CommonUtil(driver);
    }
    @Test
    public void verifyAllLabels()
    {
       // commonUtil.waitForAllElementToVisible(By.tagName("input"));

        List<WebElement> allLabels = driver.findElements(By.tagName("input"));
        System.out.println("Size: "+allLabels.size());

        for(WebElement element:allLabels)
        {
            String label=element.getAttribute("placeholder");
            if(label!=null && !label.isBlank())
            {
                System.out.println(label);
            }
        }
    }
    @AfterClass
    public  void tearDown()
    {
        driver.quit();
    }
}
