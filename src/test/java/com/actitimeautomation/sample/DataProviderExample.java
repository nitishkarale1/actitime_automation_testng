package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class DataProviderExample extends BaseClass
{
    WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        launchBrowser("chrome");
        driver = super.driver;
    }
    @DataProvider
    public Object [][] getTestData()
    {
        Object [][] data = new Object[][]
                {
                        {"userName1","password1"},
                        {"userName2","password2"},
                        {"userName3","password3"}
                };
        return data;
    }
    @DataProvider
    public Object [][] getTestDataFromExcel() throws Exception
    {
        ExcelHandling3 excelHandling = new ExcelHandling3();
        String filePath = "D:\\CyberSuccess\\test data\\Book1.xlsx";
        Object [][] data = excelHandling.getExcelData(filePath, "Sheet1");
        return data;
    }
    @Test(priority = 2, dataProvider = "getTestDataFromExcel")
    public void verifyLogin(Object userName, Object password) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(userName.toString(),password.toString());
        Thread.sleep(3000);
    }
    @Test(priority = 1, dataProvider = "getTestData")
    public void verifyData(Object userName, Object password)
    {
        System.out.println(userName.toString()+" "+password.toString());
    }
    @Test(priority = 3, dataProvider = "getSampleData", dataProviderClass = TestDataProvider.class)
    public void test(String city1, String city2)
    {
        System.out.println(city1+" "+city2);
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
