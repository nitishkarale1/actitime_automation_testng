package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AlertExamples extends BaseClass
{
    static WebDriver driver;

    public AlertExamples()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
        new AlertExamples();

        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.name("cusid")).sendKeys("nitish");
        driver.findElement(By.name("submit")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        alert.accept();
       // alert.dismiss();
        Thread.sleep(2000);
        driver.quit();
    }
}
