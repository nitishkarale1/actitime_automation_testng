package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class FlipkartProductWithNameAndPrice extends BaseClass
{
    static WebDriver driver;
    public  FlipkartProductWithNameAndPrice()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args) throws InterruptedException
    {
        new FlipkartProductWithNameAndPrice();

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//input[starts-with(@title,'Search for')]")).sendKeys("Java Books"); //Java Books  Denim Jeans   sony camera
        driver.findElement(By.xpath("//button[@class='_2iLD__']")).submit();

        List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='slAVV4']/descendant::a[@class='wjcEIp']"));
        List<WebElement> allProductPrices=driver.findElements(By.xpath("//div[@class='slAVV4']/descendant::div[@class='Nx9bqj']"));
        List<WebElement> allProductRating=driver.findElements(By.xpath("//div[@class='slAVV4']/descendant::span/div"));
        List<WebElement> allProductRreviw=driver.findElements(By.xpath("//div[@class='slAVV4']/descendant::span[@class='Wphh3N']"));
        List<WebElement> allProductOriginalPrice=driver.findElements(By.xpath("//div[@class='slAVV4']/descendant::div[@class='yRaY8j']"));

        System.out.println("all Products size: "+ allProducts.size());
        System.out.println("all ProductsPrices size: "+ allProductPrices.size());
        System.out.println("all Products Rating size: "+ allProductRating.size());
        System.out.println("all Products Review size: "+ allProductRreviw.size());
        System.out.println("all Products Original Price elements size: "+ allProductOriginalPrice.size());

        if(allProducts.size()==allProductPrices.size())
        {
            for (int i = 0; i <= allProducts.size() - 1; i++)
            {
                String productName = allProducts.get(i).getText();
                String productPrice = allProductPrices.get(i).getText();
//              String productRating=allProductRating.get(i).getText();
//              String productReview=allProductRreviw.get(i).getText();
//              String productOriginalPrice=allProductOriginalPrice.get(i).getText();

                System.out.println(productName + " || " + productPrice);

                //System.out.println(productName+" || "+productPrice+" || "+productOriginalPrice+" || "+productRating+" || "+productReview);

            }
        }
    }
}