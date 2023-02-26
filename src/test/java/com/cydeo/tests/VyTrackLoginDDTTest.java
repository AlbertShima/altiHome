package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashBoardPage;
import com.cydeo.pages.VyTrackLoginPages;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {
    VyTrackLoginPages loginPage = new VyTrackLoginPages();
    VyTrackDashBoardPage dashBoardPage = new VyTrackDashBoardPage();

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vy.track.url"));
    }

    @After
    public void tearDown() {
        //   Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {

        String filePath = "Vytrack.xlsx";

        //to read from excel we need to load it to FileInputStream
        FileInputStream in = new FileInputStream(filePath);

        //The flow will be: workbook > sheet > row > cell

        //<1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(in);

        //<2> Create a sheet. We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            String userName = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastname = sheet.getRow(i).getCell(3).toString();

            loginPage.login(userName, password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask.shown']"));

            wait.until(ExpectedConditions.visibilityOf(loaderMask));

            String actualFullName = dashBoardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);
            if (actualFullName.contains(firstName) && actualFullName.contains(lastname)) {
                System.out.println("Pass");
                resultCell.setCellValue("Pass");
            } else {
                System.out.println("Fail");
                resultCell.setCellValue("Fail");
            }
            dashBoardPage.logout();
        }
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        in.close();
        outputStream.close();
        workbook.close();

    }
}
