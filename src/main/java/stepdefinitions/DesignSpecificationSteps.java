package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;

import pages.DecisionSupportPage;
import pages.DesignSpecificationPage;
import pages.ModelsPage;
import pages.WorkSpacePage;
import utilities.DriverFactory;

public class DesignSpecificationSteps {

    DesignSpecificationPage designSpecPage = new DesignSpecificationPage();
    private DecisionSupportPage decisionSupportPage = new DecisionSupportPage();
    private ModelsPage modelsPage = new ModelsPage();
    WorkSpacePage workSpacePage = new WorkSpacePage();
    


    @When("I navigate to the Design Specification page")
    public void navigateToDesignSpecificationPage() {
        // Navigate to Design Specification page logic
    	workSpacePage.clickdesignspecSideNav();
    	Assert.assertTrue(designSpecPage.isDesignSpecPageTitleCorrect(), "Page title is incorrect!");
        System.out.println("Navigated to Design Specification page.");
    }

    @When("I check the design page title")
    public void checkPageTitle() {
        Assert.assertTrue(designSpecPage.isDesignSpecPageTitleCorrect(), "Page title is incorrect!");
    }

    @Then("the title should contain Design Specification")
    public void titleShouldContain() {
        Assert.assertTrue(designSpecPage.isDesignSpecPageTitleCorrect(), "Page title does not contain the expected text!");
    }

    @When("I check the design grid display on the page")
    public void checkGridDisplay() {
        Assert.assertTrue(designSpecPage.isDesignSpecListGridDisplayed(), "Grid is not displayed!");
    }

    @Then("the design grid should be visible")
    public void gridShouldBeVisible() {
        Assert.assertTrue(designSpecPage.isDesignSpecListGridDisplayed(), "Grid is not visible!");
    }

    @When("I check the size of the design grid")
    public void checkGridSize() {
        Assert.assertTrue(designSpecPage.isDesignSpecListGridSizeGreaterThanZero(), "Grid size is not greater than zero!");
    }

    @Then("the design grid should have entries")
    public void gridShouldHaveEntries() {
        Assert.assertTrue(designSpecPage.isDesignSpecListGridSizeGreaterThanZero(), "Grid does not have entries!");
    }

    @Given("I see the Add Design Specification tooltip")
    public void seeTooltip() {
        // Assuming tooltip text verification if needed
        Assert.assertTrue(designSpecPage.checkAndClickDesignSpecAddToolTip());
    }

    @When("I click on the Add Design Specification button")
    public void clickOnButton() {
        designSpecPage.checkAndClickDesignSpecAddButton();
    }

    @Then("I should navigate to the Add Design Specification page")
    public void navigateToPage() {
        Assert.assertTrue(designSpecPage.isDesignSpecAddTitleCorrect(), "Not navigated to the expected page!");
    }

    @When("I leave the Design Name field blank and validate error message")
    public void leaveFieldBlank() {
        // Logic for blanking out the field
    	Assert.assertTrue(designSpecPage.isErrorMessageDisplayedForBlankDesignSpecNameField(), "Error message for blank name is not displayed!");
    }
    
    @And("Click on design creation button")
    public void checkAndClickDesignSpecCreateBtn() {
    	designSpecPage.checkAndClickDesignSpecCreateBtn();
    }

    @And("I enter a design description exceeding 120 characters and validate error message")
    public void checknaxerror() {
    	Assert.assertTrue(designSpecPage.isErrorMessageDisplayedForDesignSpecMaxLength(), "Error message for exceeding max length is not displayed!");
    }


    @When("I enter a valid design name {string}")
    public void enterValidName(String name) {
        designSpecPage.sendKeysToNameField(name);
    }

    @And("I enter a valid design description {string}")
    public void enterValidDescription(String description) {
        designSpecPage.sendKeysToDescriptionField(description);
    }

    @Then("the design specification entry {string} should be displayed in the grid")
    public void entryShouldBeDisplayedInGrid(String entryName) {
        Assert.assertTrue(designSpecPage.validateFeatureCreation(entryName, "design specification"), 
            "Design Specification entry is not displayed in the grid!");
    }

    @When("Click on cancel create design")
    public void clickButton() {
    
            designSpecPage.checkAndClickDesignSpecCancelBtn();
       
    }

    @Then("I should be redirected back to the Design Specification list page")
    public void redirectedToListPage() {
        Assert.assertTrue(designSpecPage.isDesignSpecListGridDisplayed(), 
            "Not redirected to the Design Specification list page!");
    }
}
