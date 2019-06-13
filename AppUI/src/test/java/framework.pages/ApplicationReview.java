package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class ApplicationReview {

    //TOP LINKS
    private final Element backToAppOverview;
    private final Element returnToAppBtn;
    private final Element printBtn;
    private final Element submitApplicationBtn;
    //App review header
    private final Element appReviewHeader;
    // MAC Information
    private final Element macInfoSection;
    private final Element entityProfileBreadcrumb;

    public ApplicationReview(App app) {
        /**Top links**/
        backToAppOverview = app.newElement(Locator.PARTIALLINKTEXT, "Overview");
        returnToAppBtn = app.newElement(Locator.LINKTEXT, "Return to Application");
        printBtn = app.newElement(Locator.LINKTEXT, "Print");
        submitApplicationBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Submit Application')]");
        /**App review header**/
        appReviewHeader = app.newElement(Locator.XPATH, "//h2[contains(text(),'Application Review')]");
        /**MAC Info**/
        macInfoSection = app.newElement(Locator.XPATH, "//div[@class='accordion']//div[@class='ds-l-container app-grid--striped']//div[1]//div[1]");
        entityProfileBreadcrumb = app.newElement(Locator.PARTIALLINKTEXT, "Entity Profile");

        this.app = app;
    }

    private final  App app;

    public void clickBackToAppOverview() {
        backToAppOverview.click();
    }

    public void navigateToEntity() {
        app.wait(2d);
        entityProfileBreadcrumb.click();
    }

    public void returnToApp() {
        returnToAppBtn.click();
    }

    public void print() {
        printBtn.click();
    }

    public void setSubmitApplicationBtn(){
        submitApplicationBtn.waitForEquals().changeDefaultWait(30);
        submitApplicationBtn.click();
        app.wait(5d);
        app.refresh();
        app.wait(5d);
        // submitApplicationBtn.waitForEquals().changeDefaultWait(60);
        //changed to In Progress status
        app.azzert().textPresent("In Progress");
    }

    public void appReviewHeader(){
        appReviewHeader.get();
    }
    public void getMacInfo() {
        macInfoSection.get();
    }


}