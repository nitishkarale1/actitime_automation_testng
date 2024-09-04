package com.actitimeautomation.sample;

import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProjectTests
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Launch website
        driver.get("https://online.actitime.com/nk18/login.do");

        //Create object of LoginPage class
        LoginPage loginPage=new LoginPage(driver);

        //Perform login operation
        loginPage.login("nitish1810", "nkhonor8pro");

        //wait for 5 seconds
        Thread.sleep(5000);


    }
}
