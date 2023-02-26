package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashBoardPage {
    public VyTrackDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='user-menu']/a")
    public WebElement fullName;

    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logOutLink;

    public void logout(){
        fullName.click();
        logOutLink.click();
    }
}
