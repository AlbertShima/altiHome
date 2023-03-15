package com.cydeo.step_definitions;

import com.cydeo.pages.SozialbauPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SozialbauStepDefinition {

    @Given("that you are in sozialbau page")
    public void that_you_are_in_sozialbau_page() {
        Driver.getDriver().get("https://www.sozialbau.at/angebot/sofort-verfuegbar/");
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("you search for Vienna all the options")
    public void you_search_for_vienna_all_the_options() throws Exception {
        for (int i = 1; i <= 19; i++) {
            WebElement address = Driver.getDriver().findElement(By.xpath("//*[@id='c115']/div/form/table/tbody/tr[" + i + "]/td[1]/a"));

            WebElement numberOfRooms = Driver.getDriver().findElement(By.xpath("//*[@id='c115']/div/form/table/tbody/tr[" + i + "]/td[2]"));

            WebElement price = Driver.getDriver().findElement(By.xpath("//*[@id='c115']/div/form/table/tbody/tr[" + i + "]/td[4]"));

            if (address.getText().contains("Wien") && Integer.parseInt(numberOfRooms.getText()) == 3 && (Integer.parseInt(price.getText().substring(2, price.getText().length() - 3).replaceAll("\\.", ""))) < 1000) {
               Assert.assertTrue(true);
                System.out.println("Shikoje i here si mundesi");
                break;
            } else {
               Assert.fail();
                System.out.println("Ska shpi");
            }
        }
    }
}
