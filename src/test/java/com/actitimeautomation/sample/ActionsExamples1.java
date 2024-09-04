package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExamples1 extends BaseClass
{
    static WebDriver driver;

    ActionsExamples1()
    {
       launchBrowser("chrome");
       driver=super.driver;
    }

    public static void main(String[] args) throws InterruptedException
    {
        new ActionsExamples1();
        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nitishkarale");

        Actions actions = new Actions(driver);

        actions.sendKeys(driver.findElement(By.id("username")), "nitish18").build().perform();
        actions.sendKeys(driver.findElement(By.name("pwd")), "nkhonor8pro").build().perform();
        actions.click(driver.findElement(By.id("loginButton"))).perform();

        Thread.sleep(3000);
        //driver.findElement(By.xpath("//div[text()='Reports']")).click();
        actions.click(driver.findElement(By.xpath("//div[text()='Reports']"))).build().perform();
        Thread.sleep(3000);
        actions.scrollToElement(driver.findElement(By.xpath("//span[text()='Company: Leave Time']"))).build().perform();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("logoutLink"))).click().build().perform();
        Thread.sleep(300);
        driver.close();
    }
}
