package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.DriverFactory;
import utilities.TokenUtility;

public class WorkSpacePage {

	private WebDriver driver = DriverFactory.getDriver();

    private By wssideNav = By.cssSelector("yib-layout-sidenav-item a[title='Workspace']");
    private By wslistGrid = By.xpath("//app-workspace-list//yib-grid-angular");
    private By wslistGridSize = By.xpath("//app-workspace-list//yib-grid-angular//div[@col-id='workspace_name'][@role='gridcell']");
    private By wsaddTooTip = By.xpath("//app-workspace-list//p-button[@routerlink='create-workspace']");
    private By wsaddBtn = By.xpath("//app-workspace-list//p-button[@routerlink='create-workspace']//button");
    private By wsaddtitle = By.cssSelector("app-workspace-create h1");
    private By wsaddsubtitle = By.cssSelector("app-workspace-create h2");
    private By wsaddnameField = By.cssSelector("app-workspace-create input[id='name']");
    private By wsadddescriptionField = By.cssSelector("app-workspace-create textarea[formcontrolname='description']");
    private By wsaddcancelBtn = By.cssSelector("app-workspace-create p-button[label='Cancel'] button");
    private By wsaddcreateBtn = By.cssSelector("app-workspace-create p-button[label='Create'] button");
    private By wasaddbreacrumb = By.cssSelector("//p-breadcrumb//a[contains(@href,'create-workspace')]");

    private By designspecSideNav = By.cssSelector("yib-layout-sidenav yib-layout-sidenav-item a[title='Design Specification']");
    private By decisionsupportSideNav = By.cssSelector("yib-layout-sidenav yib-layout-sidenav-item a[title='Decision Support']");
    private By modelsSideNav = By.cssSelector("yib-layout-sidenav yib-layout-sidenav-item a[title='Models']");
    private By assetsSideNav = By.cssSelector("yib-layout-sidenav yib-layout-sidenav-item a[title='Assets']");
    private By dataSideNav = By.cssSelector("yib-layout-sidenav yib-layout-sidenav-item a[title='Data']");
    
    
    
    public void clickdataSideNav() {
    	driver.findElement(dataSideNav).click();
    }
    public void clickdesignspecSideNav() {
    	driver.findElement(designspecSideNav).click();
    }
    public void clickdecisionsupportSideNav() {
    	driver.findElement(decisionsupportSideNav).click();
    }
    
    public void clickmodelsSideNav() {
    	driver.findElement(modelsSideNav).click();
    }
    public void clickwssideNav() {
    	driver.findElement(wssideNav).click();
    	
    }
    public boolean checkDesignSpecSideNavDisplayed() {
        try {
            return driver.findElement(designspecSideNav).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkDecisionSupportSideNavDisplayed() {
        try {
            return driver.findElement(decisionsupportSideNav).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean checkModelsSideNavDisplayed() {
        try {
            return driver.findElement(modelsSideNav).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean checkAssetsSideNavDisplayed() {
        try {
            return driver.findElement(assetsSideNav).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean checkDataSideNavDisplayed() {
        try {
            return driver.findElement(dataSideNav).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkWasaddBreadcrumbDisplayed() {
        try {
            return driver.findElement(wasaddbreacrumb).isDisplayed(); // Check if the breadcrumb is displayed
        } catch (Exception e) {
            return false; // If the element is not found or any other exception occurs, return false
        }
    }

    
    public void clickCreateButton() {
        if (checkWsaddCreateBtnDisplayed()) {  // First, check if it's displayed
            driver.findElement(wsaddcreateBtn).click();  // Click the 'Create' button
        } else {
            System.out.println("The create button is not displayed.");
        }
    }

    public boolean checkWsaddCreateBtnDisplayed() {
        try {
            return driver.findElement(wsaddcreateBtn).isDisplayed();
        } catch (Exception e) {
            return false; // If the element is not found, return false
        }
    }

    
    public void clickCancelButton() {
        if (checkWsaddCancelBtnDisplayed()) {  // First, check if it's displayed
            driver.findElement(wsaddcancelBtn).click();  // Click the 'Cancel' button
        } else {
            System.out.println("The cancel button is not displayed.");
        }
    }

    
    public boolean checkWsaddCancelBtnDisplayed() {
        try {
            return driver.findElement(wsaddcancelBtn).isDisplayed();
        } catch (Exception e) {
            return false; // If the element is not found, return false
        }
    }

    // Method to send keys to the 'description' field
    public void sendKeysToDescriptionField(String description) {
        if (checkWsaddDescriptionFieldDisplayed()) {  // First, check if it's displayed
            driver.findElement(wsadddescriptionField).clear();  // Clear any existing value
            driver.findElement(wsadddescriptionField).sendKeys(description);  // Send the new value
        } else {
            System.out.println("The description field is not displayed.");
        }
    }
    
    
    // Method to check if the 'description' field is displayed
    public boolean checkWsaddDescriptionFieldDisplayed() {
        try {
            return driver.findElement(wsadddescriptionField).isDisplayed();
        } catch (Exception e) {
            return false; // If the element is not found, return false
        }
    }
    // Method to send keys to the 'name' field
    public void sendKeysToNameField(String name) {
        if (checkWsaddNameFieldDisplayed()) {  // First, check if it's displayed
            driver.findElement(wsaddnameField).clear();  // Clear any existing value
            driver.findElement(wsaddnameField).sendKeys(name);  // Send the new value
        } else {
            System.out.println("The name field is not displayed.");
        }
    }
    
    public boolean checkWsaddNameFieldDisplayed() {
    	return driver.findElement(wsaddnameField).isDisplayed();
    }
   
    
    public boolean checkwsaddsubtitle() {
    	return driver.findElement(wsaddsubtitle).getText().contains("Create Workspace");
    }
    
    public boolean checkwsaddtitle() {
    	return driver.findElement(wsaddtitle).getText().contains("Workspace");
    }
    
 
    public boolean checkwssideNavtitle() {
    	
		return driver.findElement(wssideNav).getText().contains("Workspace");
      
    }
    
    public boolean checkwsgrid() {
    	return driver.findElement(wslistGrid).isDisplayed();
    }
    
    public int checkwsgridSize() {
    	
    	return driver.findElements(wslistGridSize).size();
    }
    
    public boolean checkaddwstootip() {
    	return driver.findElement(wsaddTooTip).getAttribute("ptooltip").contains("Add Workspace");
    }
    
    public void checkwsaddBtn() {
    	 driver.findElement(wsaddBtn).isDisplayed();
    }
    
    public void clickwsaddBtn() {
   	 driver.findElement(wsaddBtn).click();
   }

 // Locator for error message when name field is left blank
    private By wsaddnameFieldErrorBlank = By.xpath("//small[contains(@class,'p-error') and text()=' Name is required']");

    // Method to validate error message for blank name field ("Name is required")
    public boolean isErrorMessageDisplayedForBlankWsNameField() {
        driver.findElement(wsadddescriptionField).clear();  // Ensure name field is empty
        driver.findElement(wsaddnameField).click();
        driver.findElement(wsadddescriptionField).click();// Try submitting the form

        // Check if the error message for blank name field is displayed
        return driver.findElement(wsaddnameFieldErrorBlank).isDisplayed();
    }
 // Locator for error message when name field exceeds 120 characters
    private By wsaddnameFieldErrorMaxLength = By.xpath("//small[contains(@class,'p-error') and text()=' Max 120 characters allowed.']");

    // Method to validate error message for max length exceeded ("Max 120 characters allowed.")
    public boolean isErrorMessageDisplayedForWsMaxLength() {
    	driver.findElement(wsaddnameField).sendKeys("Error description"); 
        driver.findElement(wsadddescriptionField).sendKeys("This is a very long name that exceeds the maximum character limit of 120 characters. This should trigger an error message once we try to submit.");  // Enter text that exceeds 120 characters
        driver.findElement(wsadddescriptionField).click();  // Try submitting the form

        // Check if the error message for exceeding the max length is displayed
        return driver.findElement(wsaddnameFieldErrorMaxLength).isDisplayed();
    }

    public boolean checkWsaddCreateBtnEnabled() {
        return driver.findElement(wsaddcreateBtn).isEnabled();  // Workspace example
    }
    public boolean createWorkspace(String name, String description) {
        // Enter name and description for the Workspace
    	clickwssideNav();
    	clickwsaddBtn();
        sendKeysToNameField(name);
        sendKeysToDescriptionField(description);

        // Ensure the Create button is enabled before clicking
        if (checkWsaddCreateBtnEnabled()) {
            clickCreateButton(); 
            clickwssideNav();// Click the Create button

            // Validate if the Workspace is created or duplicated
            return validateFeatureCreation(name, "workspace");
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
