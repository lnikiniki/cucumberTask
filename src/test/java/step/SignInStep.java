package step;

import com.epam.lab.gmailTask.businessObjects.GmailSignInBO;
import com.epam.lab.gmailTask.drivers.DriverPool;
import com.epam.lab.gmailTask.parsers.PropertyParser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SignInStep {
    private GmailSignInBO signIn;
    private WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", new PropertyParser("src/main/resources/driver.properties").getDriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(new PropertyParser("src/main/resources/driver.properties").getWaitTime(), TimeUnit.SECONDS);
    }

    @Given("^Open gmail page$")
    public void openGmailPage(){
        driver.get("https://gmail.com");
        signIn = new GmailSignInBO(driver);
    }

    @When("^I enter correct username (.*) and password (.*)$")
    public void signIn(String email, String password){
            signIn.signIn(email, password);
    }

    @Then("^I should successfully sign in and page title should contain '(.*)'$")
    public void successSignIn(String title){
        Assert.assertTrue(driver.getTitle().contains(title));
    }

    @Then("^I should see alert message$")
    public void failedSignIn(){
        Assert.assertTrue(signIn.signInIsFailed());
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
