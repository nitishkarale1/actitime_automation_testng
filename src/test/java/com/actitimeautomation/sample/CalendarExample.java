package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class CalendarExample extends BaseClass
{
    static WebDriver driver;
    public CalendarExample()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException
    {
        new CalendarExample();

        int dayOfMonth= LocalDateTime.now().plusDays(1).getDayOfMonth();

        //get current month
        String currentMonth=LocalDateTime.now().getMonth().toString();

        //convert month to July format
        String month=currentMonth.charAt(0)+currentMonth.substring(1,(currentMonth.length())).toLowerCase();
        System.out.println("current month: "+currentMonth);
        System.out.println(month);
        System.out.println("Taday's day: "+dayOfMonth);

        driver.manage().window().maximize();
        driver.navigate().to(" https://online.actitime.com/nitishkarale");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.id("username")).sendKeys("nitish10");
        driver.findElement(By.name("pwd")).sendKeys("nitish1@23");
        driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")).click();
        //click on tasks module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        //click on first row of calender
        driver.findElement(By.xpath("(//div[text()='Set up deadline'])[1]")).click();

        List<WebElement> monthDays = driver.findElements(By.xpath("//tbody[@class='rc-calendar-tbody']/descendant::td[starts-with(@title,"+month+")]/div"));
        for(WebElement dayElement:monthDays)
        {
            String monthDay = dayElement.getText();

            String currentDay=String.valueOf(dayOfMonth);

            if(currentDay.equals(monthDay))
            {
                dayElement.click();
                break;
            }
        }
    }
}
