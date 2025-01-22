package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.TokenUtility;

public class DesignSpecificationPage {
	private WebDriver driver = DriverFactory.getDriver();

    private By designspecpageTitile = By.cssSelector("app-usp-design-specification-list h1");
    private By designspeclistGrid = By.xpath("//app-usp-design-specification-list//yib-grid-angular");
    private By designspeclistGridSize = By.xpath("//app-usp-design-specification-list//yib-grid-angular//div[@col-id='design_spec_name'][@role='gridcell']");
    private By designspecaddTooTip = By.xpath("//app-usp-design-specification-list//p-button[@ptooltip='Add Design Specification']");
    private By designspecaddBtn = By.xpath("//app-usp-design-specification-list//p-button[@ptooltip='Add Design Specification']//button");
    private By designspecaddtitle = By.cssSelector("app-usp-add-design-specification h2");
    private By designspecaddnameField = By.cssSelector("app-usp-add-design-specification input[id='name']");
    private By designspecadddescriptionField = By.cssSelector("app-usp-add-design-specification textarea[formcontrolname='description']");
    private By designspecaddcancelBtn = By.cssSelector("app-usp-add-design-specification p-button[label='Cancel'] button");
    private By designspecaddcreateBtn = By.cssSelector("app-usp-add-design-specification p-button[label='Create'] button");
    private By designspecaddbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'/design-specification/add')]");
    private By designspeclandingbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'design-specification')]");
   



 // Method to check page title
    public boolean isDesignSpecPageTitleCorrect() {
        return driver.findElement(designspecpageTitile).getText().contains("Design Specification");
    }

    // Method to check if grid is displayed
    public boolean isDesignSpecListGridDisplayed() {
        return driver.findElement(designspeclistGrid).isDisplayed();
    }

    // Method to check if the grid size is greater than 0
    public boolean isDesignSpecListGridSizeGreaterThanZero() {
        return driver.findElements(designspeclistGridSize).size() > 0;
    }

    // Method to check and click the "Add Design Specification" tooltip
    public boolean checkAndClickDesignSpecAddToolTip() {
        return driver.findElement(designspecaddTooTip).isDisplayed();
    }

    // Method to check and click the "Add Design Specification" button
    public void checkAndClickDesignSpecAddButton() {
        if (driver.findElement(designspecaddBtn).isDisplayed()) {
            driver.findElement(designspecaddBtn).click();
        }
    }

    // Method to validate title text of the "Add Design Specification" page
    public boolean isDesignSpecAddTitleCorrect() {
        return driver.findElement(designspecaddtitle).getText().contains("Create New Design Specification");
    }

    // Method to check and enter a name in the "Name" field
    public void checkAndEnterNameInDesignSpecNameField(String name) {
        if (driver.findElement(designspecaddnameField).isDisplayed()) {
            driver.findElement(designspecaddnameField).sendKeys(name);
        }
    }

    // Method to check and enter a description in the "Description" field
    public void checkAndEnterDescriptionInDesignSpecDescriptionField(String description) {
        if (driver.findElement(designspecadddescriptionField).isDisplayed()) {
            driver.findElement(designspecadddescriptionField).sendKeys(description);
        }
    }

    // Method to check and click the "Cancel" button
    public void checkAndClickDesignSpecCancelBtn() {
        if (driver.findElement(designspecaddcancelBtn).isDisplayed()) {
            driver.findElement(designspecaddcancelBtn).click();
        }
    }

    // Method to check and click the "Create" button
    public void checkAndClickDesignSpecCreateBtn() {
        if (driver.findElement(designspecaddcreateBtn).isDisplayed()) {
            driver.findElement(designspecaddcreateBtn).click();
        }
    }

    // Method to check and click the breadcrumb for "Add Design Specification"
    public void checkAndClickDesignSpecAddBreadcrumb() {
        if (driver.findElement(designspecaddbreacrumb).isDisplayed()) {
            driver.findElement(designspecaddbreacrumb).click();
        }
    }

    // Method to check and click the breadcrumb for landing page
    public void checkAndClickDesignSpecLandingBreadcrumb() {
        if (driver.findElement(designspeclandingbreacrumb).isDisplayed()) {
            driver.findElement(designspeclandingbreacrumb).click();
        }
    }
 // Locator for error message when name field is left blank
    private By designspecaddnameFieldErrorBlank = By.xpath("//small[contains(@class,'p-error') and text()=' Name is required']");

    // Method to validate error message for blank name field ("Name is required")
    public boolean isErrorMessageDisplayedForBlankDesignSpecNameField() {
        driver.findElement(designspecadddescriptionField).clear();  // Ensure name field is empty
        driver.findElement(designspecaddnameField).click();
        driver.findElement(designspecadddescriptionField).click();// Try submitting the form

        // Check if the error message for blank name field is displayed
        return driver.findElement(designspecaddnameFieldErrorBlank).isDisplayed();
    }
 // Locator for error message when name field exceeds 120 characters
    private By designspecaddnameFieldErrorMaxLength = By.xpath("//small[contains(@class,'p-error') and text()=' Max 120 characters allowed.']");

    // Method to validate error message for max length exceeded ("Max 120 characters allowed.")
    public boolean isErrorMessageDisplayedForDesignSpecMaxLength() {
    	driver.findElement(designspecaddnameField).sendKeys("Error description");
        driver.findElement(designspecadddescriptionField).sendKeys("This is a very long name that exceeds the maximum character limit of 120 characters. This should trigger an error message once we try to submit.");  // Enter text that exceeds 120 characters
        driver.findElement(designspecaddnameField).click();  // Try submitting the form

        // Check if the error message for exceeding the max length is displayed
        return driver.findElement(designspecaddnameFieldErrorMaxLength).isDisplayed();
    }

    public void sendKeysToNameField(String name) {
        driver.findElement(designspecaddnameField).clear();
        driver.findElement(designspecaddnameField).sendKeys(name);  // Workspace example
    }

    public void sendKeysToDescriptionField(String description) {
        driver.findElement(designspecadddescriptionField).clear();
        driver.findElement(designspecadddescriptionField).sendKeys(description);  // Workspace example
    }
    public boolean checkDesignspecaddCreateBtnEnabled() {
        return driver.findElement(designspecaddcreateBtn).isEnabled();  // Workspace example
    }
    public boolean createDesignSpecification(String name, String description) {

        // Enter name and description for the Design Specification
        sendKeysToNameField(name);
        sendKeysToDescriptionField(description);

        // Ensure the Create button is enabled before clicking
        if (checkDesignspecaddCreateBtnEnabled()) {
        	checkAndClickDesignSpecCreateBtn();  // Click the Create button

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
