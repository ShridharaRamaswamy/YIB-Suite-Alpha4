package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.TokenUtility;

public class DecisionSupportPage {
	private WebDriver driver = DriverFactory.getDriver();

    private By dspageTitile = By.cssSelector("app-usp-decision-support-list h1");
    private By dslistGrid = By.xpath("//app-usp-decision-support-list//yib-grid-angular");
    private By wslistGridSize = By.xpath("//app-usp-decision-support-list//yib-grid-angular//div[@col-id='design_run_name'][@role='gridcell']");
    private By dsaddTooTip = By.xpath("//app-usp-decision-support-list//p-button[@ptooltip='Add Design Run']");
    private By dsaddBtn = By.xpath("//app-usp-decision-support-list//p-button[@ptooltip='Add Design Run']//button");
    private By dsaddtitle = By.cssSelector("app-usp-add-decision-support h2");
    private By dsaddnameField = By.cssSelector("app-usp-add-decision-support input[id='name']");
    private By dsadddescriptionField = By.cssSelector("app-usp-add-decision-support textarea[formcontrolname='description']");
    private By dsaddcancelBtn = By.cssSelector("app-usp-add-decision-support p-button[label='Cancel'] button");
    private By dsaddcreateBtn = By.cssSelector("app-usp-add-decision-support p-button[label='Create'] button");
    private By dsaddbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'/decision-support/add')]");


    
 // Method to check page title
    public boolean isDSPageTitleCorrect() {
        return driver.findElement(dspageTitile).getText().contains("Decision Support");
    }

    // Method to check if the grid is displayed
    public boolean isDSListGridDisplayed() {
        return driver.findElement(dslistGrid).isDisplayed();
    }

    // Method to check if the grid size is greater than 0
    public boolean isDSListGridSizeGreaterThanZero() {
        return driver.findElements(wslistGridSize).size() > 0;
    }

    // Method to check and click the "Add Design Run" tooltip
    public boolean checkAndClickDSAddToolTip() {
        return driver.findElement(dsaddTooTip).isDisplayed();
    }

    // Method to check and click the "Add Design Run" button
    public void checkAndClickDSAddButton() {
        if (driver.findElement(dsaddBtn).isDisplayed()) {
            driver.findElement(dsaddBtn).click();
        }
    }

    // Method to validate title text of the "Add Decision Support" page
    public boolean isDSAddTitleCorrect() {
        return driver.findElement(dsaddtitle).getText().contains("Create New Decision Support");
    }

    // Method to check and enter a name in the "Name" field
    public void checkAndEnterNameInDSNameField(String name) {
        if (driver.findElement(dsaddnameField).isDisplayed()) {
            driver.findElement(dsaddnameField).sendKeys(name);
        }
    }

    // Method to check and enter a description in the "Description" field
    public void checkAndEnterDescriptionInDSDescriptionField(String description) {
        if (driver.findElement(dsadddescriptionField).isDisplayed()) {
            driver.findElement(dsadddescriptionField).sendKeys(description);
        }
    }

    // Method to check and click the "Cancel" button
    public void checkAndClickDSCancelBtn() {
        if (driver.findElement(dsaddcancelBtn).isDisplayed()) {
            driver.findElement(dsaddcancelBtn).click();
        }
    }

    // Method to check and click the "Create" button
    public void checkAndClickDSCreateBtn() {
        if (driver.findElement(dsaddcreateBtn).isDisplayed()) {
            driver.findElement(dsaddcreateBtn).click();
        }
    }

    // Method to check and click the breadcrumb for "Add Decision Support"
    public void checkAndClickDSAddBreadcrumb() {
        if (driver.findElement(dsaddbreacrumb).isDisplayed()) {
            driver.findElement(dsaddbreacrumb).click();
        }
    }
       
 // Locator for error message when name field is left blank
    private By dsaddnameFieldErrorBlank = By.xpath("//small[contains(@class,'p-error') and text()=' Name is required']");

    // Method to validate error message for blank name field ("Name is required")
    public boolean isErrorMessageDisplayedForBlankDSNameField() {
        driver.findElement(dsadddescriptionField).clear();
        driver.findElement(dsaddnameField).click();// Ensure name field is empty
        driver.findElement(dsadddescriptionField).click();  // Try submitting the form

        // Check if the error message for blank name field is displayed
        return driver.findElement(dsaddnameFieldErrorBlank).isDisplayed();
    }
 // Locator for error message when name field exceeds 120 characters
    private By dsaddnameFieldErrorMaxLength = By.xpath("//small[contains(@class,'p-error') and text()=' Max 120 characters allowed.']");

    // Method to validate error message for max length exceeded ("Max 120 characters allowed.")
    public boolean isErrorMessageDisplayedForDSMaxLength() {
        driver.findElement(dsaddnameField).sendKeys("Error description");
        driver.findElement(dsadddescriptionField).sendKeys("This is a very long name that exceeds the maximum character limit of 120 characters. This should trigger an error message once we try to submit.");  // Enter text that exceeds 120 characters
        driver.findElement(dsaddnameField).click();

        // Check if the error message for exceeding the max length is displayed
        return driver.findElement(dsaddnameFieldErrorMaxLength).isDisplayed();
    }
    public void sendKeysToNameField(String name) {
        driver.findElement(dsaddnameField).clear();
        driver.findElement(dsaddnameField).sendKeys(name);  // Workspace example
    }

    public void sendKeysToDescriptionField(String description) {
        driver.findElement(dsadddescriptionField).clear();
        driver.findElement(dsadddescriptionField).sendKeys(description);  // Workspace example
    }
    public boolean checkDsaddCreateBtnEnabled() {
        return driver.findElement(dsaddcreateBtn).isEnabled();  // Workspace example
    }
    public boolean createDesignSpecification(String name, String description) {

        // Enter name and description for the Design Specification
        sendKeysToNameField(name);
        sendKeysToDescriptionField(description);

        // Ensure the Create button is enabled before clicking
        if (checkDsaddCreateBtnEnabled()) {
        	checkAndClickDSCreateBtn();  // Click the Create button

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