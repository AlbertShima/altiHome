package com.cydeo.step_definitions;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(WebDriver driver, String from, String to, String subject, String message, String password) throws Exception {

        // Navigate to Gmail login page
        driver.get("https://mail.google.com");

        // Enter email and password and click sign in button
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys(from);
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(6000);
        WebElement passwordField = driver.findElement(By.xpath("//input[@aria-label='Enter your password']"));
        passwordField.sendKeys(password);
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(5000);

        // Compose and send email
        driver.findElement(By.cssSelector(".aic .z0 div")).click();
        Thread.sleep(6000);

        WebElement toField = driver.findElement(By.xpath("//div[@class='aoD hl']"));
        BrowserUtils.waitForVisibility(toField, 5);
        toField.sendKeys(to);
        WebElement subjectField = driver.findElement(By.cssSelector(".aoD.az6 input"));
        subjectField.sendKeys(subject);
        WebElement messageField = driver.findElement(By.cssSelector(".Ar.Au div"));
        messageField.sendKeys(message);
        driver.findElement(By.cssSelector(".dC div")).click();
        Thread.sleep(5000);

        System.out.println("Email sent successfully!");

    }

}
