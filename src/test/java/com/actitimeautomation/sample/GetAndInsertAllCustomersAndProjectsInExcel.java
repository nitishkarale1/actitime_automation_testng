package com.actitimeautomation.sample;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class GetAndInsertAllCustomersAndProjectsInExcel extends BaseClass
{
    static WebDriver driver;
    public GetAndInsertAllCustomersAndProjectsInExcel()
    {
        launchBrowser("chrome");
        driver = super.driver;
    }

    public Workbook getWorkbook(String filePath) throws IOException
    {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        return workbook;
    }
    public  void writeExcelData(String filePath, String sheetName, Object[][] data) throws IOException {
        Workbook workbook = getWorkbook(filePath);
        Sheet sheet;
        Row row;
        Cell cell;

        if(workbook.getSheet(sheetName) != null)
        {
           sheet = workbook.getSheet(sheetName);
        }
        else
        {
           sheet = workbook.createSheet();
        }

        int totalrowsInData = data.length;
        int totalColumnsInData = data[0].length;

        for(int i=0; i<=totalrowsInData-1; i++)
        {
            if(sheet.getRow(i) != null)
            {
                row = sheet.getRow(i);
            }
            else
            {
               row = sheet.createRow(i);
            }
            for(int j=0; j<=totalColumnsInData-1; j++)
            {
                Object value = data[i][j];

                if(row.getCell(j) != null)
                {
                    cell = row.getCell(j);
                }
                else
                {
                   cell = row.createCell(j);
                }
                cell.setCellValue(value.toString());
            }
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }

    public static void main(String[] args) throws InterruptedException, IOException
    {
       new GetAndInsertAllCustomersAndProjectsInExcel();

        driver.manage().window().maximize();
        driver.get("https://online.actitime.com/nitishkarale/login.do");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("nitish18", "nkhonor8pro");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[text()='Tasks']")).click();

        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(5000);
       // ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");

        List<WebElement> allCollapseButtons = driver.findElements(By.xpath("//div[starts-with(@class,'node customerNode')]/div[@class='collapseButton']"));
        System.out.println(allCollapseButtons.size());
        for(int i=0; i<=allCollapseButtons.size()-1; i++)
        {
            //allCollapseButtons.get(i).click();
            WebElement element = allCollapseButtons.get(i);
            allCollapseButtons.get(i).click();
          //  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            Thread.sleep(500);
        }

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='All Customers']")).click();

        Thread.sleep(2000);
        // get all customers
        List<WebElement> allCustomersElement = driver.findElements(By.xpath("//div[starts-with(@class,'node customerNode')]//div[@class='text']")); //div[starts-with(@class,'node customerNode')]   ////div[@class='unfilteredContainer']//div[@class='text']

        String [][] data = new String [allCustomersElement.size()][1];
        System.out.println(data.length);

        for (int i=0; i<=allCustomersElement.size()-1; i++)
        {
            String customerName = allCustomersElement.get(i).getText();
            data[i][0] = customerName;
        }
        ExcelHandling4 excelHandling = new ExcelHandling4();
        String filePath = "D:\\CyberSuccess\\test data\\Actitme.xlsx";
        excelHandling.writeExcelData(filePath, "Sheet1", data);

        Thread.sleep(3000);
        driver.quit();
    }
}
