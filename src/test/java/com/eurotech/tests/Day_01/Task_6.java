package com.eurotech.tests.Day_01;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;


public class Task_6 extends TestBase {
    /**Test Case 6: Contact Us Form
     Launch browser
     Navigate to url 'http://automationexercise.com/'
     Verify that home page is visible successfully
     Click on 'Contact Us' button
     Verify 'GET IN TOUCH' is visible
     Enter name, email, subject and message
     Upload file
     Click 'Submit' button
     Click OK button
     Verify success message 'Success! Your details have been submitted successfully.' is visible
     Click 'Home' button and verify that landed to home page successfully*/

    @Test
    public void test1(){
        driver.get(ConfigurationReader.get("url"));



}
    }


