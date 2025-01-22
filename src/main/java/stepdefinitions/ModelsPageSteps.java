package stepdefinitions;

import pages.ModelsPage;
import pages.WorkSpacePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ModelsPageSteps {

    private ModelsPage modelsPage = new ModelsPage();
    WorkSpacePage workSpacePage = new WorkSpacePage();
    @Given("select workspace")
    public void select_workspace() throws InterruptedException {
    	modelsPage.getSideNavWorkspace();
    	modelsPage.getWorkspaceNameFilter();
    	modelsPage.getFilterSearchBox();
    	modelsPage.getFilterApplyBtn();
    	modelsPage.getSelectWspace();
    	workSpacePage.clickmodelsSideNav();
    	modelsPage.checkAndClickDtLandingTwinBtn();
    	
    }
    @Then("I am on the Models page {string}")
    public void i_am_on_models_Page(String expectedText)  {
     	
    	
    	Assert.assertTrue(modelsPage.checkDtPageTitleContains(expectedText), "Page title doesn't contain expected text");
        
    }
    @Then("the DT page title should contain {string}")
    public void thedtPageTitleShouldContain(String expectedText)   {
    
    	
        Assert.assertTrue(modelsPage.checkDtPageTitleContains(expectedText), "Page title doesn't contain expected text");
    }

    @Then("the Digital Twin list grid should be displayed")
    public void theDigitalTwinListGridShouldBeDisplayed() {
        Assert.assertTrue(modelsPage.checkDtListGridDisplayed(), "Digital Twin list grid is not displayed");
    }

    @Then("the Digital Twin list grid size should be greater than 0")
    public void theDigitalTwinListGridSizeShouldBeGreaterThanZero() {
        Assert.assertTrue(modelsPage.checkDtListGridSizeGreaterThanZero(), "Digital Twin list grid is empty");
    }

    @Then("the Add Digital Twin button should be displayed")
    public void theAddDigitalTwinButtonShouldBeDisplayed() {
        Assert.assertTrue(modelsPage.checkDtAddBtnDisplayed(), "Add Digital Twin button is not displayed");
    }

    @Then("the Add Digital Twin button should have the tooltip {string}")
    public void theAddDigitalTwinButtonShouldHaveTheTooltip(String expectedTooltip) {
        Assert.assertTrue(modelsPage.checkDtAddTooltipText(expectedTooltip), "Tooltip text mismatch");
    }

    @When("I click on the Add Digital Twin button")
    public void iClickOnTheAddDigitalTwinButton() {
        modelsPage.checkAndClickDtAddBtn();
    }

    @When("I enter the name {string}")
    public void iEnterTheName(String name) {
        modelsPage.sendKeysToNameField(name);
    }

    @When("I enter the description {string}")
    public void iEnterTheDescription(String description) {
        modelsPage.sendKeysToDescriptionField(description);
    }

    @When("I click on the Create button")
    public void iClickOnTheCreateButton() {
        modelsPage.checkAndClickDtAddCreateBtn();
    }

    @Then("the Digital Twin should be created with the name {string}")
    public void theDigitalTwinShouldBeCreatedWithTheName(String name) {
    	workSpacePage.clickmodelsSideNav();
    	modelsPage.checkAndClickDtLandingTwinBtn();
        Assert.assertTrue(modelsPage.validateFeatureCreation(name, "digital Twin"), "Digital Twin not created");
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        if (errorMessage.equals("Name is required")) {
            Assert.assertTrue(modelsPage.isErrorMessageDisplayedForBlankNameField(), "Error message for blank name not displayed");
        } else if (errorMessage.equals("Max 120 characters allowed.")) {
            Assert.assertTrue(modelsPage.isErrorMessageDisplayedForMaxLength(), "Error message for max length exceeded not displayed");
        }
    }
    
    @Given("I am on the Add Digital Twin page")
    public void add_digital_twin_validation() {
    	Assert.assertTrue(modelsPage.checkDtAddTitleText("Create Digital Twin"));
    }
    
    @Then("I should see the Add Digital Twin breadcrumb")
    public void iShouldSeeTheAddDigitalTwinBreadcrumb() {
        Assert.assertTrue(modelsPage.isDtAddBreacrumbDisplayed(), "Add Digital Twin breadcrumb not displayed");
    }

    @When("I click on the Cancel button")
    public void iClickOnTheCancelButton() {
        modelsPage.checkAndClickDtAddCancelBtn();
    }

    @Given("Navigate to models page")
    public void Navigatetomodelspage() {
    	workSpacePage.clickmodelsSideNav();
    }

    @When("I click on the Digital Twin button")
    public void iClickOnTheDigitalTwinButton() {
        modelsPage.checkAndClickDtLandingTwinBtn();
    }

    @Then("I should be on the Digital Twin landing page")
    public void iShouldBeOnTheDigitalTwinLandingPage() {
        Assert.assertTrue(modelsPage.isDtTwinBreacrumbDisplayed(), "Not on Digital Twin landing page");
    }

    @When("I click on the MNM button")
    public void iClickOnTheMNMButton() {
        modelsPage.checkAndClickDtLandingMNMBtn();
    }

//    @Then("I should be on the MNM page")
//    public void iShouldBeOnTheMNMPage() {
//        // Validation logic for MNM page can be added here
//    }
}
