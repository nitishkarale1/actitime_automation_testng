package com.actitimeautomation.sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling1
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

        Object data [][] = new Object[lastRowIndex+1][lastCellIndex+1];
        System.out.println("=========================");
        for(int i=1; i<=lastRowIndex; i++)
        {
            for(int j=0; j<=lastCellIndex; j++)
            {
                Cell cellInfo = sheet.getRow(i).getCell(j);
                CellType cellType = cellInfo.getCellType();

                if(cellType==(CellType.STRING))
                {
                    System.out.print(cellInfo.getStringCellValue()+"  ");
                    data[i][j]=cellInfo.getStringCellValue();
                }
                else if (cellType==(CellType.NUMERIC))
                {
                    System.out.print(cellInfo.getNumericCellValue()+"   ");
                    data[i][j]=cellInfo.getNumericCellValue();
                }
                else if (cellType==(CellType.BOOLEAN))
                {
                    System.out.print(cellInfo.getBooleanCellValue()+"   ");
                    data[i][j]=cellInfo.getBooleanCellValue();
                }
            }
            System.out.println();
        }
        System.out.println("=========================");
        System.out.println("2D array length: "+data.length);
        for(int i=1; i<=lastRowIndex; i++)
        {
            for (int j = 0; j<=data[i].length-1; j++)
            {
                if(data[i][j]instanceof String)
                {
                    System.out.print((String) data[i][j] + "   ");
                }
                else if(data[i][j]instanceof Double)
                {
                    System.out.print((double) data[i][j] + "   ");
                }
                else if(data[i][j]instanceof Boolean)
                {
                    System.out.print((boolean) data[i][j] + "   ");
                }
            }
            System.out.println();
        }
        System.out.println("=========================");
    }
}