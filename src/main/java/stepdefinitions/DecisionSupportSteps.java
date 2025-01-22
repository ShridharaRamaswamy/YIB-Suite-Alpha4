package stepdefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DecisionSupportPage;
import pages.ModelsPage;
import pages.WorkSpacePage;


public class DecisionSupportSteps {

    
    private DecisionSupportPage decisionSupportPage = new DecisionSupportPage();
    private ModelsPage modelsPage = new ModelsPage();
    WorkSpacePage workSpacePage = new WorkSpacePage();
    
    @Given("select workspace and filter")
    public void selectWorkspaceAndFilter() throws InterruptedException {
        // Code to select workspace and apply filter
    	modelsPage.getSideNavWorkspace();
    	modelsPage.getWorkspaceNameFilter();
    	modelsPage.getFilterSearchBox();
    	modelsPage.getFilterApplyBtn();
    	modelsPage.getSelectWspace();
        System.out.println("Workspace and filter selection is successful.");
        // Add method call here if selection logic exists in a page object
    }

    @When("I navigate to the Decision Support page")
    public void navigateToDecisionSupportPage() {
        // Code to navigate to the Decision Support page
    	workSpacePage.clickdecisionsupportSideNav();
    	Assert.assertTrue(decisionSupportPage.isDSPageTitleCorrect(), "The page title is incorrect.");
        System.out.println("Navigated to the Decision Support page.");
        // Add method call here if navigation logic exists in a page object
    }

    
    @When("I check the page title")
    public void checkPageTitle() {
        Assert.assertTrue(decisionSupportPage.isDSPageTitleCorrect(), "The page title is incorrect.");
    }

    @Then("the title should contain Decision Support")
    public void validatePageTitle() {
        Assert.assertTrue(decisionSupportPage.isDSPageTitleCorrect(), "Expected title not found");
    }

    @When("I check the grid display on the page")
    public void checkGridDisplay() {
        Assert.assertTrue(decisionSupportPage.isDSListGridDisplayed(), "The grid is not displayed.");
    }

    @Then("the grid should be visible")
    public void validateGridVisibility() {
        Assert.assertTrue(decisionSupportPage.isDSListGridDisplayed(), "The grid is not visible.");
    }

    @When("I check the size of the grid")
    public void checkGridSize() {
        Assert.assertTrue(decisionSupportPage.isDSListGridSizeGreaterThanZero(), "The grid size is zero.");
    }

    @Then("the grid should have entries")
    public void validateGridSize() {
        Assert.assertTrue(decisionSupportPage.isDSListGridSizeGreaterThanZero(), "The grid has no entries.");
    }

    @When("I check and click the Add Design Run tooltip")
    public void checkAndClickTooltip() {
        Assert.assertTrue(decisionSupportPage.checkAndClickDSAddToolTip());
    }

    @When("I check and click the Add Design Run button")
    public void checkAndClickAddButton() {
        decisionSupportPage.checkAndClickDSAddButton();
    }

    @Then("I should navigate to the Add Decision Support page")
    public void validateNavigationToAddPage() {
        Assert.assertTrue(decisionSupportPage.isDSAddTitleCorrect(), "Navigation to Add Decision Support page failed.");
    }



    @When("I check and click the Cancel button")
    public void checkAndClickCancelButton() {
        decisionSupportPage.checkAndClickDSCancelBtn();
    }


    @When("I check and click the Add Decision Support breadcrumb")
    public void checkAndClickBreadcrumb() {
        decisionSupportPage.checkAndClickDSAddBreadcrumb();
    }

    @When("I leave the Name field blank and validate error message")
    public void leaveNameFieldBlankAndCreate() {
        Assert.assertTrue(decisionSupportPage.isErrorMessageDisplayedForBlankDSNameField(),
                "Error message for blank Name field is not displayed.");
    }

    @When("I enter a name exceeding 120 characters and validate error message")
    public void enterExceedingMaxLengthNameAndCreate() {
        Assert.assertTrue(decisionSupportPage.isErrorMessageDisplayedForDSMaxLength(),
                "Error message for exceeding max length is not displayed.");
    }



    @Then("the Create button should be enabled")
    public void validateCreateButtonEnabled() {
        Assert.assertTrue(decisionSupportPage.checkDsaddCreateBtnEnabled(), "The Create button is not enabled.");
    }

    @When("I create a Design Specification with Name {string} and Description {string}")
    public void createDesignSpecification(String name, String description) {
        Assert.assertTrue(decisionSupportPage.createDesignSpecification(name, description),
                "Failed to create the Design Specification.");
    }

    @Then("the decision support entry {string} should be displayed in the grid")
    public void validateDesignSpecificationInGrid(String name) {
        Assert.assertTrue(decisionSupportPage.validateFeatureCreation(name, "design specification"),
                "The Design Specification is not visible in the grid.");
    }
}
