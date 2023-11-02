package com.eurotech.tests.Day_01;

import com.eurotech.pages.ContactUs;
import com.eurotech.pages.HomePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_6 extends TestBase {
    /**
     * Test Case 6: Contact Us Form
     * Launch browser
     * Navigate to url 'http://automationexercise.com/'
     * Verify that home page is visible successfully
     * Click on 'Contact Us' button
     * Verify 'GET IN TOUCH' is visible
     * Enter name, email, subject and message
     * Upload file
     * Click 'Submit' button
     * Click OK button
     * Verify success message 'Success! Your details have been submitted successfully.' is visible
     * Click 'Home' button and verify that landed to home page successfully
     */
    HomePage homePage = new HomePage();
    ContactUs contactUs = new ContactUs();



    @Test
    public void task6_test1() {
        driver.get(ConfigurationReader.get("url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
        homePage.contactUs.click();
        Assert.assertTrue(contactUs.getInTouch.isDisplayed());
        WebElement nameInPut = contactUs.ContactUsInputMenu("Name");
        nameInPut.sendKeys("Bilal");
        WebElement  EmailInput = contactUs.ContactUsInputMenu("Email");
        EmailInput.sendKeys("abc@yahoo.com");
        WebElement SubjectInPut = contactUs.ContactUsInputMenu("Subject");
        SubjectInPut.sendKeys("i need your urgent help");
        WebElement MessageInPut = contactUs.ContactUsInputMenu("Your Message Here");
        MessageInPut.sendKeys("i need your urgent help 2");
        contactUs.fileUpload();
        BrowserUtils.scrollToElement(contactUs.submitBtn);
        contactUs.submitBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(contactUs.verifyOK.getText(),"Success! Your details have been submitted successfully.");
        contactUs.backToHome.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://automationexercise.com/");
    }
}