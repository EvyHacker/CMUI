package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

/**
 * @author Lija V
 */


public class Login {

    private final Element loginLink;
    private final Element loginPageElement;
    private final Element alertElement;
    private final Element username;
    private final Element password;
    private final Element loginButton;
    private final Element verifyUserLoggedIn;
    private final Element forgotIdLink;
    private final Element forgotPasswordLink;
    private final Element profileLink;
    private final Element learnMoreLink;
    private final Element npiLink;
    private final Element registerLink;
    private final Element modalWindow;
    private final Element yes;
    private final Element no;
    private final Element dhhsFooterLink;
    private final Element verifyHHSPageElement;
    private final Element cmsFooterLink;
    private final Element accessibilityFooterLink;
    private final App app;

    public Login(App app) {
        loginLink = app.newElement(Locator.LINKTEXT, "Login");
        loginPageElement = app.newElement(Locator.XPATH, "//*[@id='authentication_ui-login']/section/div[2]/div[1]");
        alertElement = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[2]/div[1]/div[2]/form/div[2]");
        username = app.newElement(Locator.NAME, "username");
        password = app.newElement(Locator.NAME, "password");
        loginButton = app.newElement(Locator.XPATH, "//button[contains(text(),'Log In')]");
        verifyUserLoggedIn = app.newElement(Locator.PARTIALLINKTEXT, "Dev Links");
        forgotIdLink = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[2]/div[1]/div/a[1]");
        forgotPasswordLink = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[2]/div[1]/div/a[2]");
        profileLink = app.newElement(Locator.XPATH, "//*[@id='authentication_ui-login']/section/div[2]/div[1]/div/a[3]");
        learnMoreLink = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[2]/div[2]/a");
        npiLink = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[2]/div[2]/p[2]/a");
        registerLink = app.newElement(Locator.XPATH, "//button[contains(text(),'Register')]");
        dhhsFooterLink = app.newElement(Locator.XPATH, "//*[@id='authentication_ui-login']/section/div[3]/div[2]/div[1]/a");
        cmsFooterLink = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[3]/div[2]/div[2]/a");
        accessibilityFooterLink = app.newElement(Locator.XPATH, "//*[@id=\'authentication_ui-login\']/section/div[3]/div[2]/div[3]/a");
        modalWindow = app.newElement(Locator.XPATH, "//*[@id='react-aria-modal-dialog']");
        yes = app.newElement(Locator.XPATH, "//*[@id=\'react-aria-modal-dialog\']/div/aside/div/a");
        no = app.newElement(Locator.XPATH, "//*[@id=\"react-aria-modal-dialog\"]/div/aside/div/button");
        verifyHHSPageElement = app.newElement(Locator.NAME, "q");

        this.app = app;
    }

    public void navigateToLoginPage() {

      loginLink.click();
    }

    public boolean waitForLoggedIn() {
        username.waitForState().notPresent(30);
        return username.is().present();
    }

    //Verify the Title of the PECOS Page.
    public void verifyDashboardTitle() {
        app.azzert().titleEquals("PECOS");
    }

    //Verify the Element in the Dashboard page.
    public void verifyOnDashboardPage() {
        verifyUserLoggedIn.waitForState().enabled(30);
        verifyUserLoggedIn.assertContains().text("Dev Links");
    }

    //Verify the Alert from the False Login.
    public void verifyFalseLogin() {
        alertElement.waitForState().present(30);
        alertElement.assertContains().text("Please Enter a Valid User ID");
    }

    // Method to Login to PECOS.
    public void login(String uname, String pwd) {
        username.type(uname);
        password.type(pwd);
        loginButton.click();
    }

    public void verifyOnLoginPage() {
        loginPageElement.assertState().displayed();
        loginPageElement.assertContains().text("person I&A User ID");
    }

    public void verifyForgotUserIdLink() {
        forgotIdLink.assertState().enabled();
        forgotIdLink.assertContains().text("Forgot your user ID?");
    }

    //Verify the Forgot password Link in the LoginPage and clicks on it.
    public void verifyForgotPwdLink() {
        forgotPasswordLink.assertState().enabled();
        forgotPasswordLink.assertContains().text("Forgot your password?");
    }

    //Verify the Mange Profile Link in the LoginPage and clicks on it.
    public void verifyManageProfileLink() {
        profileLink.assertState().enabled();
        profileLink.assertContains().text("Manage your user profile");
    }

    //Verify the Mange Profile Link in the LoginPage and clicks on it.
    public void verifyLearnMoreLink() {
        learnMoreLink.assertState().enabled();
        learnMoreLink.assertContains().text("Learn more about registering for an account.");
    }

    //Verify the Mange Profile Link in the LoginPage and clicks on it.
    public void verifyRegisterForNPILink() {
        npiLink.assertState().enabled();
        npiLink.assertContains().text("register for a National Provider Identifier (NPI)");
    }

    //Verify the Manage Profile Link in the LoginPage and clicks on it.
    public void verifyRegisterLink() {
        registerLink.assertState().enabled();
        registerLink.assertContains().text("Register");
    }

    //Verify the HHS Footer Link in LoginPage.
    public void verifyHhsLink() {
        dhhsFooterLink.assertState().enabled();
        dhhsFooterLink.assertContains().text("Department of Health & Human Services");
    }

    //Verify the CMS Footer Link in LoginPage.
    public void verifyCmsLink() {
        cmsFooterLink.assertState().enabled();
        cmsFooterLink.assertContains().text("CMS");
    }

    //Verify the Accessibility Footer Link in LoginPage.
    public void verifyAccessibilityLink() {
        accessibilityFooterLink.assertState().enabled();
        accessibilityFooterLink.assertContains().text("Accessibility");
    }

    //Verify the HHS Footer Link in LoginPage.
    public void waitForVerifyHhsPage() {
        verifyHHSPageElement.waitForState().enabled(30);
    }

    //Switch to the Modal window and verify the right modal window is opened.
    public void verifyForgotLinkModalWindow() {
        modalWindow.assertState().enabled();
        modalWindow.assertContains().text("warningLeaving the PECOS Website");
    }

    public void clickNo() {
        no.click();
    }

    public void clickYes() {
        yes.click();
    }

    public void clickYesForIdentityButton() {
        yes.click();
        app.azzert().titleEquals("Identity & Access Management System - CMS Warning");
    }

    public void clickYesForRegisterButton() {
        yes.click();
        app.azzert().titleEquals("PECOS IA Confirm");
    }
}
