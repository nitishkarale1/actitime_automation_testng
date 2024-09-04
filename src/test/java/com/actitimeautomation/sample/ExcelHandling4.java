package com.actitimeautomation.sample;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHandling4
{
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




    public static void main(String[] args) throws IOException
    {
        String filePath = "D:\\CyberSuccess\\test data\\Book1.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        Sheet sheet = WorkbookFactory.create(fis).getSheet("Sheet1");

        int lastRowIndex=sheet.getLastRowNum();
        int lastCellIndex=sheet.getRow(0).getLastCellNum()-1;

        for(int i=1; i<=lastRowIndex; i++)
        {
            for(int j=0; j<=lastCellIndex; j++)
            {
                System.out.print(sheet.getRow(i).getCell(j)+"  ");
            }
            System.out.println();
        }
    }
}
