package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = ".fa.fa-lock")
    public WebElement signupLoginBtn;

    @FindBy(xpath = "//a[text()=' Contact us']")
    public WebElement contactUs;

}
