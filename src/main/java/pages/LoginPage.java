package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.TokenUtility;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("gigya-loginID-77152811960799260");
    private By passwordField = By.id("gigya-password-116353530441464400");
    private By loginButton = By.cssSelector("input[value='SIGN IN']");
    private By tokenField=By.cssSelector("input[class='gig-tfa-code-textbox']");
    private By submitBtn=By.xpath("//div[contains(@class,'gig-tfa-button-submit')]");
    private By wspageTitile = By.cssSelector("app-workspace-list h1");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(loginButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    
    public void entertoken() {
    	TokenUtility tokenutility = new TokenUtility();
    	String token =  TokenUtility.getOTPFromAPI();
    	driver.findElement(tokenField).sendKeys(token);
    	driver.findElement(submitBtn).click();
    }
    public boolean checkwspagetitle() {
    	return driver.findElement(wspageTitile).getText().contains("Workspace");
    }
}
