package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";
        File file = new File(path);

        //to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(file);

        //The flow will be: workbook > sheet > row > cell

        //<1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //<2> Create a sheet. We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //<3> Select row and cell
        //Print out mary´s cell
        //Indexes starts at zero
        System.out.println(sheet.getRow(1).getCell(0));

        System.out.println(sheet.getRow(3).getCell(2));

        //Return the count of  a cells only
        //Starts counting from 1

        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Returning the number from top cell to bottom cell
        //It does not care if the cell is empty or not
        //Starts counting from 0

        int lastRow = sheet.getLastRowNum();
        System.out.println(lastRow);

        //TODO: Create a logic to print Vinods name
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: Create a logic to print out Lindas job ID
        //Check if name is LInda --> print out Job_ID of Linda

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println("Lindas Job_ID "+sheet.getRow(rowNum).getCell(2));
            }
        }



    }
}
