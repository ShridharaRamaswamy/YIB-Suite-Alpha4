package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.TokenUtility;

public class DataPage {
	private WebDriver driver = DriverFactory.getDriver();

    private By DIpageTitile = By.cssSelector("app-di-data-integration-list h1");
    private By DIlistGrid = By.xpath("//app-di-data-integration-list//yib-grid-angular");
    private By DIlistGridSize = By.xpath("//app-di-data-integration-list//yib-grid-angular//div[@col-id='data_integration_name'][@role='gridcell']");
    private By DIaddTooTip = By.xpath("//app-di-data-integration-list//p-button[@routerlink='create-data-integration']");
    private By DIaddBtn = By.xpath("//app-di-data-integration-list//p-button[@routerlink='create-data-integration']//button");
    private By DIaddtitle = By.cssSelector("app-data-integration-create h1");
    private By DIaddsubtitle = By.cssSelector("app-data-integration-create h2");
    private By DIaddnameField = By.cssSelector("app-data-integration-create input[id='name']");
    private By DIadddescriptionField = By.cssSelector("app-data-integration-create textarea[formcontrolname='description']");
    private By DIaddcancelBtn = By.cssSelector("app-data-integration-create p-button[label='Cancel'] button");
    private By DIaddcreateBtn = By.cssSelector("app-data-integration-create p-button[label='Create'] button");
    private By DIaddbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'create-data-integration')]");
    private By DIlandingbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'data-integration')]");

   
 // Method to check page title
    public boolean isDIPageTitleCorrect() {
        return driver.findElement(DIpageTitile).getText().contains("Data Integration");
    }

    // Method to check if the grid is displayed
    public boolean isDIListGridDisplayed() {
        return driver.findElement(DIlistGrid).isDisplayed();
    }

    // Method to check if the grid size is greater than 0
    public boolean isDIListGridSizeGreaterThanZero() {
        return driver.findElements(DIlistGridSize).size() > 0;
    }

    // Method to check and click the "Create Data Integration" tooltip
    public void checkAndClickDICreateToolTip() {
        if (driver.findElement(DIaddTooTip).isDisplayed()) {
            driver.findElement(DIaddTooTip).click();
        }
    }

    // Method to check and click the "Create Data Integration" button
    public void checkAndClickDICreateButton() {
        if (driver.findElement(DIaddBtn).isDisplayed()) {
            driver.findElement(DIaddBtn).click();
        }
    }

    // Method to validate title text of the "Create Data Integration" page
    public boolean isDIAddTitleCorrect() {
        return driver.findElement(DIaddtitle).getText().contains("Create Data Integration");
    }

    // Method to validate subtitle text of the "Create Data Integration" page
    public boolean isDIAddSubtitleCorrect() {
        return driver.findElement(DIaddsubtitle).getText().contains("Data Integration");
    }

    // Method to check and enter a name in the "Name" field
    public void checkAndEnterNameInDINameField(String name) {
        if (driver.findElement(DIaddnameField).isDisplayed()) {
            driver.findElement(DIaddnameField).sendKeys(name);
        }
    }

    // Method to check and enter a description in the "Description" field
    public void checkAndEnterDescriptionInDIDescriptionField(String description) {
        if (driver.findElement(DIadddescriptionField).isDisplayed()) {
            driver.findElement(DIadddescriptionField).sendKeys(description);
        }
    }

    // Method to check and click the "Cancel" button
    public void checkAndClickDICancelButton() {
        if (driver.findElement(DIaddcancelBtn).isDisplayed()) {
            driver.findElement(DIaddcancelBtn).click();
        }
    }

    // Method to check and click the "Create" button
    public void checkAndClickDICreateButton1() {
        if (driver.findElement(DIaddcreateBtn).isDisplayed()) {
            driver.findElement(DIaddcreateBtn).click();
        }
    }

    // Method to check and click the breadcrumb for "Create Data Integration"
    public void checkAndClickDICreateBreadcrumb() {
        if (driver.findElement(DIaddbreacrumb).isDisplayed()) {
            driver.findElement(DIaddbreacrumb).click();
        }
    }

    // Method to check and click the breadcrumb for "Data Integration" landing page
    public void checkAndClickDILandingBreadcrumb() {
        if (driver.findElement(DIlandingbreacrumb).isDisplayed()) {
            driver.findElement(DIlandingbreacrumb).click();
        }
    }


 // Locator for error message when name field is left blank
    private By DIaddnameFieldErrorBlank = By.xpath("//small[contains(@class,'p-error') and text()=' Data Integration name is required.']");

    // Method to validate error message for blank name field ("Name is required")
    public boolean isErrorMessageDisplayedForBlankDINameField() {
        driver.findElement(DIadddescriptionField).clear();  // Ensure name field is empty
        driver.findElement(DIaddnameField).click();
        driver.findElement(DIadddescriptionField).click();// Try submitting the form

        // Check if the error message for blank name field is displayed
        return driver.findElement(DIaddnameFieldErrorBlank).isDisplayed();
    }

    public void sendKeysToNameField(String name) {
        driver.findElement(DIaddnameField).clear();
        driver.findElement(DIaddnameField).sendKeys(name);  // Workspace example
    }

    public void sendKeysToDescriptionField(String description) {
        driver.findElement(DIadddescriptionField).clear();
        driver.findElement(DIadddescriptionField).sendKeys(description);  // Workspace example
    }
    public boolean checkDIaddCreateBtnEnabled() {
        return driver.findElement(DIaddcreateBtn).isEnabled();  // Workspace example
    }
    public boolean createDesignSpecification(String name, String description) {

        // Enter name and description for the Design Specification
        sendKeysToNameField(name);
        sendKeysToDescriptionField(description);

        // Ensure the Create button is enabled before clicking
        if (checkDIaddCreateBtnEnabled()) {
        	checkAndClickDICreateButton();  // Click the Create button

            // Validate if the Design Specification is created or duplicated
            return validateFeatureCreation(name, "design specification");
        } else {
            System.out.println("Create button is disabled due to invalid name.");
            return false;  // Name is required and Create button is disabled
        }
    }
    
    public boolean validateFeatureCreation(String name, String featureType) {
        // Construct feature-specific XPath based on the feature type
        String featureXPath = "";

        switch (featureType.toLowerCase()) {
            case "workspace":
                featureXPath = "//div[@col-id='workspace_name' and text()='" + name + "']";
                break;
            case "design specification":
                featureXPath = "//div[@col-id='design_spec_name' and text()='" + name + "']";
                break;
            case "decision support":
                featureXPath = "//div[@col-id='design_run_name' and text()='" + name + "']";
                break;
            case "data integration":
                featureXPath = "//div[@col-id='data_integration_name' and text()='" + name + "']";
                break;
            default:
                System.out.println("Invalid feature type specified.");
                return false;
        }

        // Check if the feature already exists in the grid
        return driver.findElements(By.xpath(featureXPath)).size() > 0;  // If the element is found, it's a duplicate
    }


}
       

