package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;
import utilities.ExtentManager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {"pretty", "json:target/cucumber-reports.json"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setupExtentReport() {
    	
        ExtentManager.createInstance(ConfigReader.get("report.path"));
    }

    @AfterSuite
    public void flushExtentReport() {
        ExtentManager.getInstance().flush();
    }
}
