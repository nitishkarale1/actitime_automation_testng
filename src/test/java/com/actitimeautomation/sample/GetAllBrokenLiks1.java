package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class GetAllBrokenLiks1 extends BaseClass
{
    static WebDriver driver;
    GetAllBrokenLiks1()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }

    public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
        new GetAllBrokenLiks1();
        int workingLinkCount=0;
        int brokenLinkCount=0;
        int malformedURLcount=0;
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       List<WebElement> allLinkElement = driver.findElements(By.tagName("a"));
        System.out.println(allLinkElement.size());

       for(WebElement linkElement:allLinkElement)
       {
           String link = linkElement.getAttribute("href");
           //System.out.println(link);
           if(link != null && !link.isEmpty() && !link.isBlank())
           {

               try
               {
                   URL url = new URL(link);

                   URLConnection connection = url.openConnection();

                   HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

                   httpURLConnection.connect();

                   String requstedMethod = httpURLConnection.getRequestMethod();
                   int statusCode = httpURLConnection.getResponseCode();

                   if (statusCode > 299)
                   {
                       System.out.println(requstedMethod + " || " + statusCode + " || " + link);
                       brokenLinkCount++;
                   }
                   else if (statusCode < 300)
                   {
                       System.out.println(requstedMethod + " || " + statusCode + " || " + link);
                       workingLinkCount++;
                   }

                   httpURLConnection.disconnect();
               }
               catch (MalformedURLException e)
               {
                   System.out.println("Malformed URL: " + link);
                   malformedURLcount++;
               }
           }
       }
        System.out.println("Woking link count : "+workingLinkCount);
        System.out.println("broken link count : "+brokenLinkCount);
        System.out.println("Malformed URL count : "+malformedURLcount);

        Thread.sleep(3000);
        driver.quit();
    }
}
