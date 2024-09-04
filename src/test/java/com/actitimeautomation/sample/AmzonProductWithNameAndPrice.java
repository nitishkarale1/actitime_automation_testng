package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmzonProductWithNameAndPrice extends BaseClass
{
    static WebDriver driver;
    public AmzonProductWithNameAndPrice()
    {
        launchBrowser("chrome");
        driver=super.driver;
    }
    public static void main(String[] args)
    {
        new AmzonProductWithNameAndPrice();

        driver.get("https://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Electronics");
        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> allProducts = driver.findElements(By.xpath("//div[contains(@data-cel-widget,'MAIN-SEARCH')]//h2//span"));
        List<WebElement> allProductPrices = driver.findElements(By.xpath("//div[contains(@data-cel-widget,'MAIN-SEARCH')]//span[@class='a-price-whole']"));
        if(allProducts.size()==allProductPrices.size())
        {
            for (int i = 0; i <= allProducts.size() - 1; i++)
            {
                String productName = allProducts.get(i).getText();
                String productPrice=allProductPrices.get(i).getText();
                System.out.println(productName+" || "+productPrice);
            }
        }
    }
}
