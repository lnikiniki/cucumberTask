package com.epam.lab.gmailTask.businessObjects;

import com.epam.lab.gmailTask.pageObjects.GmailSignIn;
import org.openqa.selenium.WebDriver;

public class GmailSignInBO {
    private GmailSignIn gmailSignIn;

    public GmailSignInBO(WebDriver driver){
        gmailSignIn = new GmailSignIn(driver);
    }

    public void signIn(String email, String password){
        gmailSignIn.printEmail(email);
        gmailSignIn.clickNextButton();
        gmailSignIn.printPassword(password);
        gmailSignIn.clickPasswordNextButton();
    }

    public boolean signInIsFailed(){
        return gmailSignIn.wrongPasswordMessageisPresent();
    }
}
