package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends BasePage {
    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouch;
    @FindBy(name = "upload_file")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "(//div[text()='Success! Your details have been submitted successfully.'])[1]")
    public WebElement verifyOK;

    @FindBy(className = "fa fa-angle-double-left")
    public WebElement backToHome;

    public WebElement ContactUsInputMenu(String placeHolderName) {
        return Driver.get().findElement(By.xpath("//*[@placeholder='" + placeHolderName + "']"));
    }

    public void fileUpload() {

        WebElement chooseFile = uploadFile;

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Eurotech_Batch11_2.txt";
        String fullPath = projectPath + "/" + filePath;

        chooseFile.sendKeys(fullPath);
    }

}
