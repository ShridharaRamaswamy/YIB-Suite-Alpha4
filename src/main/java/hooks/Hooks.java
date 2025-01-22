package hooks;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverFactory;
import utilities.ExtentManager;

import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        // Create a test in Extent Reports for the current scenario
        ExtentTest test = ExtentManager.getInstance().createTest(scenario.getName());
        ExtentManager.setTest(test);
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentManager.getTest().fail("Scenario failed: " + scenario.getName());
        } else {
            ExtentManager.getTest().pass("Scenario passed: " + scenario.getName());
        }
//        DriverFactory.quitDriver();
    }
}
