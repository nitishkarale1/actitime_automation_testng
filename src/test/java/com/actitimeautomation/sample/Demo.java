package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Demo extends BaseClass
{
   static WebDriver driver;
   public  Demo()
   {
       launchBrowser("chrome");
       driver = super.driver;
   }
    public static void main(String[] args) throws IOException, InterruptedException
    {
        new Demo();

        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nk18");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("nitish1810", "nkhonor8pro");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Tasks']")).click();

        Thread.sleep(3000);

        List<WebElement> allCollapseButtons = driver.findElements(By.xpath("//div[starts-with(@class,'node customerNode')]/div[@class='collapseButton']"));
        for(WebElement collapseButton:allCollapseButtons)
        {
            collapseButton.click();
            Thread.sleep(1000);
        }

          WebElement result = driver.findElement(By.xpath("(//div[@class='text'])[11]"));
        System.out.println("result: "+result.getText());
//        driver.findElement(By.xpath("//div[text()='Galaxy Corporation']")).click();
//
//        Thread.sleep(3000);
//
//        driver.findElement(By.xpath("//tr[@class='taskRow']//div[@class='img']")).click();
    }
}
