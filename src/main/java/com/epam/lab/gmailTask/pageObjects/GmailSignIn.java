package com.epam.lab.gmailTask.pageObjects;

import com.epam.lab.gmailTask.webElements.Button;
import com.epam.lab.gmailTask.webElements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailSignIn extends GmailPageObject {
    @FindBy(id = "identifierId")
    private Input emailInput;

    @FindBy(id = "identifierNext")
    private Button nextButton;

    @FindBy(name = "password")
    private Input passwordInput;

    @FindBy(css = "div#passwordNext")
    private Button passwordNextButton;

    @FindBy(css="div.dE00ab.RxsGPe")
    private WebElement wrongPasswordMessage;

    public GmailSignIn(WebDriver driver) {
        super(driver);
    }

    public void printEmail(String email){
        emailInput.print(email);
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void printPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickPasswordNextButton(){
        passwordNextButton.waitUntilVisible(driver);
        passwordNextButton.waitUntilClickable(driver);
        passwordNextButton.click();
    }

    public boolean wrongPasswordMessageisPresent() {
        return wrongPasswordMessage.isDisplayed();
    }

    public void openPage(){
        driver.get("https://gmail.com");
    }
}
