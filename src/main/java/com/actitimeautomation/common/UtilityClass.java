package com.actitimeautomation.common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public class UtilityClass
{
    public static Cell getExcelData(int rowIndex, int columnIndex) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\testData\\excelData.xlsx");
        Sheet sheet = WorkbookFactory.create(fis).getSheet(getConfigData("sheetName"));
        Cell cellInfo = sheet.getRow(rowIndex).getCell(columnIndex);
        fis.close();
        return cellInfo;
    }
    public static String getConfigData(String key) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\config1.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String value = properties.getProperty(key);
        fis.close();
        return value;
    }
    public static void captureScreenshot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "\\screenshots\\scrnsht.jpg");
        FileHandler.copy(src,dest);
    }
    public static void implicitWait(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void waitForElementVisible(WebDriver driver,WebElement element)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForElementToPresent(WebDriver driver,By locator)
    {
        Wait <WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForAllElementToVisible(WebDriver driver,By locator)
    {
        Wait <WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
    }
    public static void waitForAllElementToVisible(WebDriver driver,WebElement element)
    {
        Wait <WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
    public static void waitForElementClickable(WebDriver driver,By locator)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForElementClickable(WebDriver driver,WebElement element)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForElementLocated(WebDriver driver,By locator)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void fluentWait(WebDriver driver,By locator)
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

    public static void fluentWait(WebElement element) {
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

    public static void maximizeWindow(WebDriver driver)
    {
        driver.manage().window().maximize();
    }
    public static void minimizeWindow(WebDriver driver)
    {
        driver.manage().window().minimize();
    }
}
