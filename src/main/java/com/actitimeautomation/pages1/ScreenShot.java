package com.actitimeautomation.pages1;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot
{
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String randomString = RandomString.make(2);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+"\\screenShot"+randomString+".png");
        System.out.println(src);
        System.out.println(dest);
        FileHandler.copy(src, dest);
        Thread.sleep(2000);
        driver.quit();
    }
}
