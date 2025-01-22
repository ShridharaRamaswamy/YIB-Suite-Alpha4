package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {
        DriverFactory.getDriver().get(ConfigReader.get("base.url"));
    }

    @When("the user enters username and password")
    public void enterCredentials() {
        loginPage.login("shridhara.ramaswamy@yokogawa.com", "June@2030");
    }
    

    @And("Enter authenticator token")
    public void entetoken() {
    	loginPage.entertoken();
    }
    
    @Then("Validate workspace landing page title")
    public void verifywstitle() {
    	Assert.assertTrue(loginPage.checkwspagetitle());
    }
    
}
