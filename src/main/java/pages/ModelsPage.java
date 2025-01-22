package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.DriverFactory;
import utilities.TokenUtility;

public class ModelsPage {
	private WebDriver driver = DriverFactory.getDriver();

    private By dtpageTitile = By.cssSelector("app-usp-digital-twin-list h1");
    private By dtlistGrid = By.xpath("//app-usp-digital-twin-list//yib-grid-angular");
    private By dtlistGridSize = By.xpath("//app-usp-digital-twin-list//yib-grid-angular//div[@col-id='digital_twin_name'][@role='gridcell']");
    private By dtaddTooTip = By.xpath("//app-usp-digital-twin-list//p-button[@ptooltip='Add digital Twin']");
    private By dtaddBtn = By.xpath("//app-usp-digital-twin-list//p-button[@ptooltip='Add digital Twin']//button");
    private By dtaddtitle = By.cssSelector("app-usp-add-digital-twin h1");
    private By dtaddnameField = By.cssSelector("app-usp-add-digital-twin input[id='name']");
    private By dtadddescriptionField = By.cssSelector("app-usp-add-digital-twin textarea[formcontrolname='description']");
    private By dtaddcancelBtn = By.cssSelector("app-usp-add-digital-twin p-button[label='Cancel'] button");
    private By dtaddcreateBtn = By.cssSelector("app-usp-add-digital-twin p-button[label='Create'] button");
    private By dtaddbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'/digital-twin/add')]");
    private By dtlandingbreacrumb = By.xpath("//p-breadcrumb//a[contains(@href,'models')]");
    private By dtlandingTwinBtn = By.cssSelector("app-usp-digital-twin-landing p-button[label='Digital Twin'] button");
    private By dtlandingMNMBtn = By.cssSelector("app-usp-digital-twin-landing p-button[label='MNM'] button");
    private By dttwinbrecrumb = By.xpath("//p-breadcrumb//a[contains(@href,'digital-twin')]");

    
    // Locator for the Side Navigation Workspace element
    private By sideNavWorkspace = By.cssSelector("yib-layout-sidenav a[title='Workspace']");

    // Locator for the Workspace Name Filter element
    private By workspaceNameFilter = By.xpath("//app-workspace-shell//div[@class='ag-header-cell-label']//span[contains(text(),'Name')]/parent::div/parent::div/span");

    // Locator for the Filter Search Box element
    private By filterSearchBox = By.cssSelector("input[aria-label='Search filter values']");

    // Locator for the Filter Apply Button element
    private By filterApplyBtn = By.cssSelector("button[type='submit']");
    
    private By workspaceElement = By.xpath("//div[contains(@class,'ag-row-first')]//div[@col-id='workspace_name']");
    
    
    



	// Method to get the Side Navigation Workspace element
    public void getSideNavWorkspace() {
        driver.findElement(sideNavWorkspace).click();;
    }

    // Method to get the Workspace Name Filter element
    public void getWorkspaceNameFilter() {
        driver.findElement(workspaceNameFilter).click();
    }

    // Method to get the Filter Search Box element
    public void getFilterSearchBox() {
         driver.findElement(filterSearchBox).sendKeys("workspace_qa");
    }

    // Method to get the Filter Apply Button element
    public void getFilterApplyBtn() throws InterruptedException {
         driver.findElement(filterApplyBtn).click();
         Thread.sleep(3000);
    }
    
    public void getSelectWspace() {
    	Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(workspaceElement)).click().build().perform();
    }
    public boolean isDtLandingBreacrumbDisplayed() {
        return driver.findElement(dtlandingbreacrumb).isDisplayed();
    }

    public boolean isDtTwinBreacrumbDisplayed() {
        return driver.findElement(dttwinbrecrumb).isDisplayed();
    }

    public void checkAndClickDtLandingMNMBtn() {
        if (driver.findElement(dtlandingMNMBtn).isDisplayed()) {
            
        }
    }

    public void checkAndClickDtLandingTwinBtn() {
        if (driver.findElement(dtlandingTwinBtn).isDisplayed()) {
            driver.findElement(dtlandingTwinBtn).click();
        }
    }

    public boolean isDtAddBreacrumbDisplayed() {
        return driver.findElement(dtaddbreacrumb).isDisplayed();
    }

    public void checkAndClickDtAddCreateBtn() {
        if (driver.findElement(dtaddcreateBtn).isDisplayed()) {
            driver.findElement(dtaddcreateBtn).click();
        }
    }

    public void checkAndClickDtAddCancelBtn() {
        if (driver.findElement(dtaddcancelBtn).isDisplayed()) {
            driver.findElement(dtaddcancelBtn).click();
        }
    }

    public void sendTextToDtAddDescriptionField(String text) {
        try {
            // Find the description field element using the dtadddescriptionField locator
            WebElement descriptionField = driver.findElement(dtadddescriptionField);

            // Check if the description field is displayed before sending the text
            if (descriptionField.isDisplayed()) {
                // Clear the field before sending keys (optional)
                descriptionField.clear();

                // Send the provided text to the description field
                descriptionField.sendKeys(text);
            } else {
                System.out.println("Description field is not displayed.");
            }
        } catch (Exception e) {
            // Handle exception (e.g., element not found)
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean isDtAddDescriptionFieldDisplayed() {
        try {
            // Find the description field element using the dtadddescriptionField locator
            WebElement descriptionField = driver.findElement(dtadddescriptionField);

            // Check if the description field is displayed
            return descriptionField.isDisplayed();
        } catch (Exception e) {
            // Return false if the element is not found or any other error occurs
            return false;
        }
    }

    public boolean sendTextToDtAddNameField(String text) {
        try {
            // Find the input field element using the dtaddnameField locator
            WebElement nameField = driver.findElement(dtaddnameField);

            // Check if the input field is displayed
            if (nameField.isDisplayed()) {
                // Clear the field before sending keys (optional)
                nameField.clear();

                // Send the provided text to the input field
                nameField.sendKeys(text);
                return true; // Return true after sending keys
            } else {
                return false; // Return false if the field is not displayed
            }
        } catch (Exception e) {
            // Return false if any exception occurs (e.g., element not found)
            return false;
        }
    }

    public boolean isDtAddNameFieldDisplayed() {
        try {
            // Find the input field element using the dtaddnameField locator
            WebElement nameField = driver.findElement(dtaddnameField);

            // Check if the input field is displayed
            return nameField.isDisplayed();
        } catch (Exception e) {
            // Return false if the element is not found or any other error occurs
            return false;
        }
    }

    public boolean checkDtAddTitleText(String expectedTitleText) {
        try {
            // Find the title element using the dtaddtitle locator
            WebElement titleElement = driver.findElement(dtaddtitle);

            // Get the text of the title element
            String actualTitleText = titleElement.getText();

            // Compare the actual title text with the expected title text
            return actualTitleText.contains(expectedTitleText);
        } catch (Exception e) {
            return false; // Return false if any exception occurs (e.g., element not found)
        }
    }

    public boolean checkAndClickDtAddBtn() {
        try {
            // Find the button element using the dtaddBtn locator
            WebElement addButton = driver.findElement(dtaddBtn);
            
            // Check if the button is displayed
            if (addButton.isDisplayed()) {
                // Click the button if it's displayed
                addButton.click();
                return true; // Return true after clicking
            }
            return false; // Return false if the button is not displayed
        } catch (Exception e) {
            return false; // Return false if any exception occurs (e.g., element not found)
        }
    }

    public boolean checkDtAddBtnDisplayed() {
        try {
            // Find the button element using the dtaddBtn locator
            WebElement addButton = driver.findElement(dtaddBtn);

            // Return true if the button is displayed
            return addButton.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if element is not found or any exception occurs
        }
    }

    public boolean checkDtAddTooltipText(String expectedTooltipText) {
        try {
            // Find the element with the tooltip
            WebElement tooltipElement = driver.findElement(dtaddTooTip);
            
            // Get the title attribute which typically holds the tooltip text
            String tooltipText = tooltipElement.getAttribute("title");
            
            // Return true if the tooltip text matches the expected text
            return tooltipText.equals(expectedTooltipText);
        } catch (Exception e) {
            return false; // Return false if any exception occurs (e.g., element not found)
        }
    }

    public boolean checkDtListGridSizeGreaterThanZero() {
        try {
            // Find all elements matching the XPath and store them in a list
            List<WebElement> elements = driver.findElements(dtlistGridSize);

            // Return true if the size of the list is greater than zero
            return elements.size() > 0;
        } catch (Exception e) {
            return false; // Return false if there is any exception (e.g., elements not found)
        }
    }

    public boolean checkDtListGridDisplayed() {
        try {
            return driver.findElement(dtlistGrid).isDisplayed();
        } catch (Exception e) {
            return false; // Return false if element is not found or any exception occurs
        }
    }

    public boolean checkDtPageTitleContains(String expectedText) {
        try {
            String pageTitle = driver.findElement(dtpageTitile).getText(); // Get the text of the title
            return pageTitle.contains(expectedText); // Check if it contains the expected text
        } catch (Exception e) {
            return false; // Return false if any exception occurs (e.g., element not found)
        }
    }

 // Locator for error message when name field is left blank
    private By dtaddnameFieldErrorBlank = By.xpath("//small[contains(@class,'p-error') and text()=' Name is required']");

    // Method to validate error message for blank name field ("Name is required")
    public boolean isErrorMessageDisplayedForBlankNameField() {
        driver.findElement(dtadddescriptionField).clear();  // Ensure name field is empty
        driver.findElement(dtaddnameField).click();
        driver.findElement(dtadddescriptionField).click();// Try submitting the form

        // Check if the error message for blank name field is displayed
        return driver.findElement(dtaddnameFieldErrorBlank).isDisplayed();
    }
 // Locator for error message when name field exceeds 120 characters
    private By dtaddnameFieldErrorMaxLength = By.xpath("//small[contains(@class,'p-error') and text()=' Max 120 characters allowed.']");

    // Method to validate error message for max length exceeded ("Max 120 characters allowed.")
    public boolean isErrorMessageDisplayedForMaxLength() {
    	driver.findElement(dtaddnameField).sendKeys("Error description"); 
        driver.findElement(dtadddescriptionField).sendKeys("This is a very long name that exceeds the maximum character limit of 120 characters. This should trigger an error message once we try to submit.");  // Enter text that exceeds 120 characters
        driver.findElement(dtadddescriptionField).click();  // Try submitting the form

        // Check if the error message for exceeding the max length is displayed
        return driver.findElement(dtaddnameFieldErrorMaxLength).isDisplayed();
    }
    public void sendKeysToNameField(String name) {
        driver.findElement(dtaddnameField).clear();
        driver.findElement(dtaddnameField).sendKeys(name);  // Workspace example
    }

    public void sendKeysToDescriptionField(String description) {
        driver.findElement(dtadddescriptionField).clear();
        driver.findElement(dtadddescriptionField).sendKeys(description);  // Workspace example
    }
    public boolean checkDIaddCreateBtnEnabled() {
        return driver.findElement(dtaddcreateBtn).isEnabled();  // Workspace example
    }
    public boolean createDesignSpecification(String name, String description) {

        // Enter name and description for the Design Specification
        sendKeysToNameField(name);
        sendKeysToDescriptionField(description);

        // Ensure the Create button is enabled before clicking
        if (checkDIaddCreateBtnEnabled()) {
        	checkAndClickDtAddCreateBtn();  // Click the Create button

            // Validate if the Design Specification is created or duplicated
            return validateFeatureCreation(name, "digital Twin");
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
            case "digital Twin":
                featureXPath = "//div[@col-id='digital_twin_name'] [contains(text()='" + name + "')]";
                break;
            default:
                System.out.println("Invalid feature type specified.");
                return false;
        }

        // Check if the feature already exists in the grid
        return driver.findElements(By.xpath(featureXPath)).size() > 0;  // If the element is found, it's a duplicate
    }


       
}
