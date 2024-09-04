package com.actitimeautomation.sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling3
{
    public Object [][] getExcelData(String filePth, String sheetName) throws IOException
    {
        FileInputStream fis = new FileInputStream(filePth);
        Sheet sheet= WorkbookFactory.create(fis).getSheet(sheetName);

        int lastRowIndex = sheet.getPhysicalNumberOfRows()-1;
        int lastCellIndex = sheet.getRow(0).getPhysicalNumberOfCells()-1;

        Object [][] testData = new Object[lastRowIndex][lastCellIndex+1];

        for(int i=1; i<=lastRowIndex; i++)
        {
            for(int j=0; j<=lastCellIndex; j++)
            {
                Cell cellInfo = sheet.getRow(i).getCell(j);
                CellType cellType = cellInfo.getCellType();

                Object value = null;

                if(cellType==(CellType.STRING))
                {
                    value = cellInfo.getStringCellValue();
                    //testData[i-1][j]=cellInfo.getStringCellValue();
                }
                else if (cellType==(CellType.NUMERIC))
                {
                    value = cellInfo.getNumericCellValue();
                    //testData[i-1][j]=cellInfo.getNumericCellValue();
                }
                else if (cellType==(CellType.BOOLEAN))
                {
                    value = cellInfo.getBooleanCellValue();
                    //testData[i-1][j]=cellInfo.getBooleanCellValue();
                }
                else
                {
                    value = " ";
                }
                testData[i-1][j] = value;
            }
        }
        return testData;
    }
}