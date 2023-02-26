package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    String filePath = "SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salaryCell.setCellValue(200000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salaryCell.setCellValue(110000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salaryCell.setCellValue(135000);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salaryCell.setCellValue(125000);

        //TODO: changes Marys last name to Jones

        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")) {
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");
            }
        }

        //save changes
        //open to write to the file: FileInputStream --> reading
        //save changes               FileOutputStream --> writing

        FileOutputStream outputStream = new FileOutputStream(filePath);

        //save / write changes to the workbook
        workbook.write(outputStream);

        //close all
        outputStream.close();
        workbook.close();
        fileInputStream.close();


    }
}
