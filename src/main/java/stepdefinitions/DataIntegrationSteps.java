package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DataPage;
import pages.DecisionSupportPage;
import pages.DesignSpecificationPage;
import pages.ModelsPage;
import pages.WorkSpacePage;
import utilities.DriverFactory;

public class DataIntegrationSteps {

    DataPage dataPage = new DataPage();
    DesignSpecificationPage designSpecPage = new DesignSpecificationPage();
    private DecisionSupportPage decisionSupportPage = new DecisionSupportPage();
    private ModelsPage modelsPage = new ModelsPage();
    WorkSpacePage workSpacePage = new WorkSpacePage();

    @Given("I navigate to the Data Integration page")
    public void navigateToDataIntegrationPage() {
        // Assuming navigation logic is handled
    	workSpacePage.clickdataSideNav();
        System.out.println("Navigated to Data Integration page.");
    }

    @When("I check the DI page title")
    public void checkPageTitle() {
        Assert.assertTrue(dataPage.isDIPageTitleCorrect(), "Page title is incorrect!");
    }

    @Then("the title should contain Data Integration")
    public void titleShouldContain() {
        Assert.assertTrue(dataPage.isDIPageTitleCorrect(), "Page title does not contain the expected text!");
    }

    @When("I check the DI grid display on the page")
    public void checkGridDisplay() {
        Assert.assertTrue(dataPage.isDIListGridDisplayed(), "Grid is not displayed!");
    }

    @Then("the DI grid should be visible")
    public void gridShouldBeVisible() {
        Assert.assertTrue(dataPage.isDIListGridDisplayed(), "Grid is not visible!");
    }

    @When("I check the size of the DI grid")
    public void checkGridSize() {
        Assert.assertTrue(dataPage.isDIListGridSizeGreaterThanZero(), "Grid size is not greater than zero!");
    }

    @Then("the DI grid should have entries")
    public void gridShouldHaveEntries() {
        Assert.assertTrue(dataPage.isDIListGridSizeGreaterThanZero(), "Grid does not have entries!");
    }

    @When("I click on the Create Data Integration button")
    public void clickOnDIcreateButton() {
    	dataPage.checkAndClickDICreateButton();
    }

    @When("I enter a valid name {string}")
    public void enterValidName(String name) {
        dataPage.checkAndEnterNameInDINameField(name);
    }

    @And("I enter a valid description {string}")
    public void enterValidDescription(String description) {
        dataPage.checkAndEnterDescriptionInDIDescriptionField(description);
    }
    
    @And("I click the Create button")
    	public void clickoncreatebutton() {
    	dataPage.checkAndClickDICreateButton1();
    }
    

    @Then("the data integration entry {string} should be displayed in the grid")
    public void entryShouldBeDisplayedInGrid(String entryName) {
    	workSpacePage.clickdataSideNav();
        Assert.assertTrue(dataPage.validateFeatureCreation(entryName, "data integration"),
                "Data Integration entry is not displayed in the grid!");
    }

    @When("I leave the {string} field blank")
    public void leaveFieldBlank(String fieldName) {
        if (fieldName.equalsIgnoreCase("Name")) {
            dataPage.checkAndEnterNameInDINameField("");
        }
    }

    @Then("I leave the DI Name field blank and validate error message")
    public void errorMessageShouldBeDisplayed() {
        
            Assert.assertTrue(dataPage.isErrorMessageDisplayedForBlankDINameField(),
                    "Error message for blank name is not displayed!");
        
    }
    @When("I click the Cancel button")
    public void clickondicancelbutton() {
    	dataPage.checkAndClickDICancelButton();
    	
    }
    @Then("I should be redirected back to the Data Integration list page")
    public void redirectedToListPage() {
        Assert.assertTrue(dataPage.isDIListGridDisplayed(),
                "Not redirected to the Data Integration list page!");
    }
}
