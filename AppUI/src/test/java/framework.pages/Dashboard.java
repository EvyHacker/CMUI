package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Dashboard {

    //links
    private final Element workQueueLink;
    private final Element providerProfileLink;
    private final Element viewAllProvidersLink;
    private final Element devlinks;
    //Create application
    private final Element existingProviderBtn;
    private final Element existingProvider2Btn;
    private final Element forOrgMedNovaBtn;
    private final Element asProviderRepBtn;
    // View Profile
    private final Element selectProfileBtn;
    private final Element profileSectionDropDown;
    private final Element createAppBtn;
    //Create Profile
    private final Element indProfileRadio;
    private final Element orgProfileRadio;
    private final Element createProfileNameInput;
    private final Element createProfileSsnInput;
    private final Element createProfileDobInput;
    private final Element createProfileNpiInput;
    private final Element createProfileSubmit;
    //Microservice entry points
    private final Element applicationBtn;
    private final Element caseManagementBtn;
    private final Element applicationVerificationBtn;
    private final Element nrpmBtn;

    public Dashboard(App app) {

        /**links**/
        workQueueLink = app.newElement(Locator.LINKTEXT, "Work Queue");
        providerProfileLink = app.newElement(Locator.LINKTEXT, "Provider Profile - Gabriel R Mendez");
        viewAllProvidersLink = app.newElement(Locator.XPATH, "//a[contains(text(),'View All Provider Profiles')]");
        devlinks = app.newElement(Locator.XPATH, "//a[@href='/dev-links']");
        /**Create Application**/
        existingProviderBtn = app.newElement(Locator.XPATH, "//ul[1]//li[1]//button[1]");
        existingProvider2Btn = app.newElement(Locator.XPATH, "//button[contains(text(),'For Existing Provider 2')]");
        forOrgMedNovaBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'For Org (MedNova)')]" );
        asProviderRepBtn = app.newElement(Locator.XPATH, "//ul[2]//li[1]//button[1]");
        /**View Profile**/
        selectProfileBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Select Profile')]");
        profileSectionDropDown = app.newElement(Locator.ID, "select-entity");
        createAppBtn = app.newElement(Locator.XPATH, "//span[@class='jss174'][contains(text(),'Create Application')]");
        /**Create Profile**/
        indProfileRadio = app.newElement(Locator.CSS, "input[value='IND']");
        orgProfileRadio = app.newElement(Locator.CSS, "input[value='ORG']");
        createProfileNameInput = app.newElement(Locator.ID, "outlined-name");
        createProfileSsnInput = app.newElement(Locator.XPATH, "//input[@name='ssn']");
        createProfileDobInput = app.newElement(Locator.ID, "outlined-date");
        createProfileNpiInput = app.newElement(Locator.XPATH, "//input[@name='npi']");
        createProfileSubmit = app.newElement(Locator.XPATH, "//span[contains(text(),'Submit')]");
        /**Microservice Entry points**/
        applicationBtn = app.newElement(Locator.LINKTEXT, "Application");
        caseManagementBtn = app.newElement(Locator.LINKTEXT, "Case Management");
        applicationVerificationBtn = app.newElement(Locator.LINKTEXT, "Application Verification");
        nrpmBtn = app.newElement(Locator.LINKTEXT, "Nat'l Records & Profile Management");

        this.app = app;
    }

    private final App app;

    public void clickDevLinks(){
        devlinks.waitForState().displayed(30);
        devlinks.click();
    }

    /**
     * Click on For Existing Provider button
     */
    public void clickForExistingProviderBtn() {
        existingProviderBtn.click();
    }

    /**
     * Click on Existing Provider 2 button
     */

    public void clickForExistingProvider2Btn() {
        existingProvider2Btn.click();
    }
    /**
     * Click on For Org button
     */
    public void clickforOrgMedNovaBtn() {
        forOrgMedNovaBtn.click();
    }
    /**
     * Click on As provider rep button
     */
    public void clickForExistingProviderRepBtn(){
        asProviderRepBtn.click();
    }
    /**
     * Create a simple profile
     */
    public void createSimpleProfile(String name, String ssn, String dob, String npi){
        createProfileNameInput.type(name);
        createProfileSsnInput.type(ssn);
        createProfileDobInput.type(dob);
        createProfileNpiInput.type(npi);
        createProfileSubmit.click();
        app.wait(3d);
        app.azzert().textPresent("entityId");
    }

    public void navigateToMendezProfile(){
        providerProfileLink.click();
        app.wait(10d);
        app.waitFor().textPresent("Medicare Records");
    }
    public void navigateToNRPMProviderList(){
        nrpmBtn.click();
        app.waitFor().textPresent("Providers");
    }

    public void simpleProfileAppCreation(){
        createAppBtn.waitForState().enabled(30);
        createAppBtn.click();
        app.wait(20d);
        app.azzert().textPresent("Application Summary");
    }

    public void setViewAllProviders(){
        viewAllProvidersLink.waitForState().enabled(30);
        viewAllProvidersLink.click();
    }
}