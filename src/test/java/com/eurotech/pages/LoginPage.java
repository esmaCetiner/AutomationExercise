package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement signupText;
    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement inputName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpBtn;
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement verifiesEnterAccount;
    @FindBy(id = "uniform-id_gender1")
    public WebElement genderMrRadioBtn;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "days")
    public WebElement selectDays;
    @FindBy(id = "months")
    public  WebElement selectMonth;
    @FindBy(id = "years")
    public WebElement selectYear;
    @FindBy(id = "newsletter")
    public WebElement newsletter;
    @FindBy(id = "optin")
    public WebElement offers;
    @FindBy(id = "first_name")
    public WebElement inputFirstName;
    @FindBy(id = "last_name")
    public WebElement inputLastName;
    @FindBy(id = "company")
    public WebElement inputCompany;
    @FindBy(id = "address1")
    public WebElement inputAddress;
    @FindBy(id = "country")
    public WebElement selectCountryBtn;


    public void selectBirth(String day, String month, String year){

        Select select= new Select(selectDays);
        select.selectByVisibleText(day);

        Select select1=new Select(selectMonth);
        select1.selectByVisibleText(month);

        Select select2=new Select(selectYear);
        select2.selectByVisibleText(year);
    }
    public void selectCountry(String country){
        Select select = new Select(selectCountryBtn);
        select.selectByVisibleText(country);
    }
}
