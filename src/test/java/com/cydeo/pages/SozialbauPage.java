package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SozialbauPage {
    public SozialbauPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"c115\"]/div/form/table/tbody/tr[1]/td[1]/a")
    public WebElement option1;

    @FindBy(xpath = "//*[@id=\"c115\"]/div/form/table/tbody/tr[1]/td[2]")
    public WebElement rooms1;

    @FindBy(xpath = "//*[@id=\"c115\"]/div/form/table/tbody/tr[1]/td[4]")
    public WebElement price1;
}
