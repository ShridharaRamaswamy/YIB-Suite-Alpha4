package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import pages.WorkSpacePage;
import utilities.DriverFactory;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class WorkspaceSteps {

    
    

    // Constructor to initialize WebDriver and WorkSpacePage object
   
          // Assuming DriverFactory is managing the driver
    WorkSpacePage workSpacePage = new WorkSpacePage();  // Assuming WorkSpacePage is your page object class
    
    
    @Given("I am on the Create Workspace page")
    public void iAmOnaddwsThePage() {
        // Assuming you navigate to the correct page based on the page string passed
    	workSpacePage.clickwssideNav();
        workSpacePage.clickwsaddBtn();
    }
    // Scenario 1: Workspace Creation with Valid Data
    @Given("I am on the Workspace page")
    public void iAmOnThePage() {
        // Assuming you navigate to the correct page based on the page string passed
        workSpacePage.clickwssideNav();
    }

    @When("I create a workspace with the following details")
    public void iCreateAWorkspaceWithTheFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        
        for (Map<String, String> row : rows) {
            String name = row.get("Name");
            String description = row.get("Description");

            // Use the methods to interact with the workspace fields
            workSpacePage.createWorkspace(name, description);
        }
    }

    @Then("I should see the workspaces {string} and {string} in the list")
    public void iShouldSeeTheWorkspacesInTheList(String workspace1, String workspace2) {
        boolean workspace1Exists = workSpacePage.validateFeatureCreation(workspace1, "workspace");
        boolean workspace2Exists = workSpacePage.validateFeatureCreation(workspace2, "workspace");

        Assert.assertTrue(workspace1Exists,"Workspace " + workspace1 + " not found");
        Assert.assertTrue( workspace2Exists,"Workspace " + workspace2 + " not found");
    }

    // Scenario 2: Add Workspace Button Tooltip with Data Table
    @When("I hover over the {string} button")
    public void iHoverOverTheButton(String buttonName) {
        // Assuming we don't have hover functionality yet, this can be customized
        boolean isTooltipCorrect = workSpacePage.checkaddwstootip();
        Assert.assertTrue( isTooltipCorrect,"Tooltip not found for the button");
    }

    @Then("I should see the tooltip {string}")
    public void iShouldSeeTheTooltip(String tooltipText) {
        // Use the existing method to check the tooltip
        boolean isTooltipCorrect = workSpacePage.checkaddwstootip();
        Assert.assertTrue(isTooltipCorrect,"Tooltip does not match");
    }

    // Scenario 3: Workspace Grid Visibility and Size Validation
    @Then("I should see the Workspace grid")
    public void iShouldSeeTheWorkspaceGrid() {
        boolean isGridVisible = workSpacePage.checkwsgrid();
        Assert.assertTrue(isGridVisible,"Workspace grid is not visible");
    }

    @Then("the Workspace grid should have more than 0 entries")
    public void theWorkspaceGridShouldHaveMoreThan0Entries() {
        int gridSize = workSpacePage.checkwsgridSize();
        Assert.assertTrue(gridSize > 0,"Workspace grid has no entries");
    }

    // Scenario 4: Workspace Name Field Error Validations with Data Table
    @When("I create a workspace with invalid data")
    public void iCreateAWorkspaceWithInvalidData() {

            workSpacePage.isErrorMessageDisplayedForBlankWsNameField();  // Send the name
            workSpacePage.isErrorMessageDisplayedForWsMaxLength();  // Send the description
            Assert.assertFalse(workSpacePage.checkWsaddCreateBtnEnabled());  // Attempt to create the workspace
        
    }



    // Scenario 5: Workspace Grid and Size Validation with Data Table
    @Then("the grid should have the following workspaces")
    public void theGridShouldHaveTheFollowingWorkspaces(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String workspaceName = row.get("Workspace Name");
            boolean isWorkspaceVisible = workSpacePage.validateFeatureCreation(workspaceName, "workspace");
            Assert.assertTrue(isWorkspaceVisible,"Workspace " + workspaceName + " is not found in the grid");
        }
    }

    // Scenario 6: Side Navigation Visibility Checks
    @Then("I should see the all side navigation items")
    public void iShouldSeeTheFollowingSideNavigationItems() {
    	Assert.assertTrue(workSpacePage.checkwsaddtitle());
    	Assert.assertTrue(workSpacePage.checkDesignSpecSideNavDisplayed());
    	Assert.assertTrue(workSpacePage.checkDecisionSupportSideNavDisplayed());
    	Assert.assertTrue(workSpacePage.checkModelsSideNavDisplayed());
    	Assert.assertTrue(workSpacePage.checkAssetsSideNavDisplayed());
    	Assert.assertTrue(workSpacePage.checkDataSideNavDisplayed());
    	
       
    }

    // Scenario 7: Workspace Breadcrumb Visibility
    @Then("I should see the workspace breadcrumb displayed")
    public void iShouldSeeTheWorkspaceBreadcrumbDisplayed() {
        boolean isBreadcrumbVisible = workSpacePage.checkWasaddBreadcrumbDisplayed();
        Assert.assertTrue( isBreadcrumbVisible,"Workspace breadcrumb is not visible");
    }

    // Scenario 8: Workspace Creation Page Title and Subtitle Validation
    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String title) {
        boolean isTitleCorrect = workSpacePage.checkwsaddtitle();
        Assert.assertTrue(isTitleCorrect,"Page title does not contain expected text");
    }

    @Then("the subtitle should contain {string}")
    public void theSubtitleShouldContain(String subtitle) {
        boolean isSubtitleCorrect = workSpacePage.checkwsaddsubtitle();
        Assert.assertTrue(isSubtitleCorrect,"Page subtitle does not contain expected text");
    }

    // Scenario 9: Add Workspace Button Tooltip (Duplicate of Scenario 2)
    @Then("I should see the tooltip {string} on the Add Workspace button")
    public void iShouldSeeTheTooltipOnTheAddWorkspaceButton(String tooltipText) {
        boolean isTooltipCorrect = workSpacePage.checkaddwstootip();
        Assert.assertTrue(isTooltipCorrect,"Tooltip does not match");
    }
}
