package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GetAllBrokenLinks extends BaseClass
{
    static WebDriver driver;
    public  GetAllBrokenLinks()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }

    public static void main(String[] args) throws Exception
    {
        new GetAllBrokenLinks();
        int count=0;
        driver.navigate().to("https://amazon.com");

        List<WebElement> allLinkElement = driver.findElements(By.tagName("a"));

        System.out.println(allLinkElement.size());
        for(WebElement element:allLinkElement)
        {
           String link = element.getAttribute("href");

           if(link != null && !link.startsWith("javascript"))
           {
               //convert string URL into actual URL
               try
               {
                   URL url = new URL(link);

                   URLConnection connection = url.openConnection();

                   //convert urlconnection into httpurlconnection
                   HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

                   httpURLConnection.connect();

                   int statusCode = httpURLConnection.getResponseCode();

                   if(statusCode > 299)
                   {
                       System.out.println(statusCode+" : "+link);
                   }
                   //close the connection
                   httpURLConnection.disconnect();
               }
               catch (MalformedURLException a)
               {
                   System.out.println("Malformed URL : "+link);
                   count++;
               }
           }
        }
        System.out.println(count);
        Thread.sleep(3000);
        driver.quit();
    }
}
