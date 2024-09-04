package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

public class DataDrivenLoginTest extends BaseClass
{
    static WebDriver driver;

    public  DataDrivenLoginTest()
    {
        launchBrowser("chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        new DataDrivenLoginTest();
        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nitishkarale/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String filePath = "D:\\CyberSuccess\\test data\\Login Test Data.xls";
        Object[][] excelData = new ExcelHandling3().getExcelData(filePath, "Sheet1");

        LoginPage loginPage = new LoginPage(driver);

        for(int i=0; i<= excelData.length-1; i++)
        {
            String userName = excelData[i][0].toString();
            String password = excelData[i][1].toString();
            loginPage.login(userName, password);

          //  driver.navigate().refresh();

            Thread.sleep(2000);

//            System.out.print(excelData[i][0]+"  ");
//            System.out.print(excelData[i][1]+"  ");
//            System.out.println();
        }
    }
}

