package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExamples extends BaseClass
{
    static WebDriver driver;
    
    public ActionsExamples()
    {
        launchBrowser("chrome");

        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException {
        new ActionsExamples();

        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nitishkarale/login.do");

        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("username")), "nitish18").perform(); //build()
        actions.sendKeys(driver.findElement(By.name("pwd")), "nkhonor8pro").perform(); //build()
        actions.click(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).perform(); //build()

        Thread.sleep(3000);

        actions.click(driver.findElement(By.xpath("//div[text()='Tasks']"))).perform();
        Thread.sleep(3000);

        actions.scrollToElement(driver.findElement(By.xpath("//div[text()='Our company' and @class='text']")))
                .click(driver.findElement(By.xpath("//div[text()='Our company' and @class='text']")))
                .build()
                .perform();

        Thread.sleep(3000);
        driver.quit();
    }
}
