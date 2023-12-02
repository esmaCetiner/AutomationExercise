package com.eurotech.stepDefs;

import com.eurotech.pages.HomePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register_StepDef {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user clicks on SignupLogin button")
    public void the_user_clicks_on_signup_login_button() {

        homePage.signupLoginBtn.click();
    }
    @Then("The user verifies that New User Signup! is visible")
    public void the_user_verifies_that_new_user_signup_is_visible() {
        Assert.assertEquals("New User Signup!",loginPage.signupText.getText());
    }
    @When("The user enters name and email address")
    public void the_user_enters_and_address() {
        loginPage.inputName.sendKeys(ConfigurationReader.get("userName"));
        loginPage.inputEmail.sendKeys(ConfigurationReader.get("email"));
    }

    @When("The user clicks Signup button")
    public void the_user_clicks_signup_button() {
        loginPage.signUpBtn.click();
    }
    @Then("The user verifies that ENTER ACCOUNT INFORMATION is visible")
    public void the_user_verifies_that_enter_account_information_is_visible() {
        Assert.assertTrue(loginPage.verifiesEnterAccount.isDisplayed());
    }
    @When("The user fills details: Title, Date of birth")
    public void the_user_fills_details_title_date_of_birth() {
        loginPage.genderMrRadioBtn.click();
        BrowserUtils.scrollToElement(loginPage.inputPassword);
        loginPage.inputPassword.sendKeys(ConfigurationReader.get("password"));
       // BrowserUtils.scrollToElement(loginPage.selectDays);
        loginPage.selectBirth("1","April","1988");
    }
    @When("The user selects the Sign up for our newsletter! checkbox")
    public void the_user_selects_the_sign_up_for_our_newsletter_checkbox() {
        loginPage.newsletter.click();
    }
    @And("The user selects the Receive special offers from our partners checkbox")
    public void theUserSelectsTheReceiveSpecialOffersFromOurPartnersCheckbox() {
        loginPage.offers.click();
    }
    @When("The user fills details: {string}, {string}, {string}, {string}")
    public void the_user_fills_details(String firstName, String lastName, String company, String address) {
        loginPage.inputFirstName.sendKeys(firstName);
        loginPage.inputLastName.sendKeys(lastName);
        loginPage.inputCompany.sendKeys(company);
        loginPage.inputAddress.sendKeys(address);
    }
    @When("The user selects country {string}")
    public void the_user_selects_country(String country) {
        loginPage.selectCountry(country);
    }

}
