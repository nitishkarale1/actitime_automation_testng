package com.actitimeautomation.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public class CommonUtil
{
    WebDriver driver;
    public CommonUtil(WebDriver driver)
    {
        this.driver=driver;
    }

    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void waitForElementVisible(WebElement element)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToPresent(By locator)
    {
        Wait <WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForAllElementToVisible(By locator)
    {
        Wait <WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
    }
    public void waitForAllElementToVisible(WebElement element)
    {
        Wait <WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public void waitForElementClickable(By locator)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementClickable(WebElement element)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementLocated(By locator)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public  void fluentWait(By locator)
    {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(Exception.class);

        Function<WebDriver, WebElement> function = new Function<>()
        {
            @Override
            public WebElement apply(WebDriver driver) {
                System.out.println("wait for 2 sec until the element is available");
                return driver.findElement(locator);
            }
        };
        wait.until(function);
    }

    public void fluentWait(WebElement element) {
        Wait<WebElement> wait = new FluentWait<>(element) // Changed to WebElement
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(Exception.class);

        Function<WebElement, WebElement> function = new Function<>() {
            @Override
            public WebElement apply(WebElement element) {
                System.out.println("Waiting for 2 seconds until the element is visible and clickable.");
                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                } else {
                    return null;
                }
            }
        };

        wait.until(function);
    }

    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }
    public void minimizeWindow()
    {
        driver.manage().window().minimize();
    }
}
