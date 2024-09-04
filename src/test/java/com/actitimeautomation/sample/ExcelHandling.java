package com.actitimeautomation.sample;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling
{
    public static void main(String[] args) throws IOException
    {
//        Workbook workbook = null;
//        String filePath = "D:\\CyberSuccess\\test data\\Book1.xlsx";
//        String extension = filePath.substring(filePath.indexOf(".")+1);
//        System.out.println(extension);
//
//        FileInputStream fis = new FileInputStream(filePath);
//        if(extension.equals("xlsx"))
//        {
//            workbook = new XSSFWorkbook(fis);
//        }
//        else if (extension.equals("xls"))
//        {
//            workbook = new HSSFWorkbook(fis);
//        }

        FileInputStream fis = new FileInputStream("D:\\CyberSuccess\\test data\\Book1.xlsx");
        Sheet sheet= WorkbookFactory.create(fis).getSheet("Sheet1");
        //Sheet sheet = workbook.getSheet("Sheet1");

        int lastRowIndex = sheet.getPhysicalNumberOfRows()-1;
        int lastCellIndex = sheet.getRow(0).getPhysicalNumberOfCells()-1;

        for(int i=1; i<=lastRowIndex; i++)
        {
            for(int j=0; j<=lastCellIndex; j++)
            {
                Cell cellInfo = sheet.getRow(i).getCell(j);
                CellType cellType = cellInfo.getCellType();

                if(cellType==(CellType.STRING))
                {
                    System.out.print(cellInfo.getStringCellValue()+"  ");
                }
                else if (cellType==(CellType.NUMERIC))
                {
                    System.out.print(cellInfo.getNumericCellValue()+"  ");
                }
                else if (cellType==(CellType.BOOLEAN))
                {
                    System.out.print(cellInfo.getBooleanCellValue()+"  ");
                }
            }
            System.out.println();
        }
    }
}
