package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class AppOverview {

  private final Element messageText;
  private final Element currentCaseStatus;
  private final Element processAppButton;
  private final Element reviewAppButton;
  private final Element viewDispositionLink;
  private final Element appInfoTable;
  private final Element entityInfoTable;
  private final Element timelineTab;
  private final Element currentStatus;
  private final Element relatedAppSection;
  private final Element primaryAppBadge;
  private final Element associatedAppBadge;
  private final Element associatedAppLink;
  private final Element continueProcessingApp;
  private final Element appReviewLink;
  private final Element dispostionButton;
  private final Element reviewDispositionButton;


  private final App app;

  public AppOverview(App app) {
    this.app = app;

    messageText = app.newElement(Locator.XPATH, "//h3[@class='ds-u-margin-bottom--3']");
    currentCaseStatus = app.newElement(Locator.XPATH, "//div[1]/table[1]/tbody[1]/tr[4]/td[1]");
    processAppButton = app.newElement(Locator.XPATH, "//button[contains(text(),'Process Application')]");
    reviewAppButton = app.newElement(Locator.PARTIALLINKTEXT, "Review Application");
    continueProcessingApp = app.newElement(Locator.PARTIALLINKTEXT, "Continue Processing this Application");
    viewDispositionLink = app.newElement(Locator.PARTIALLINKTEXT, "View Disposition");
    relatedAppSection = app.newElement(Locator.XPATH, "//h2[contains(text(),'Related Work')]");
    appInfoTable = app.newElement(Locator.ID, "application-info-tbl");
    entityInfoTable = app.newElement(Locator.ID, "entity-info-tbl");
    timelineTab = app.newElement(Locator.XPATH, "//div[@class='ds-c-tabs__panel']");
    currentStatus = app.newElement(Locator.XPATH, "//div[@class='ds-c-tabs__panel']/ol/li[1]/dl/dt");
    appReviewLink = app.newElement(Locator.XPATH, "//span[@class='app-form__link']");
    dispostionButton = app.newElement(Locator.PARTIALLINKTEXT, "Begin Disposition");
    associatedAppLink = app.newElement(Locator.XPATH, "//main//ul//li[1]//a");
    primaryAppBadge = app.newElement(Locator.XPATH, "//span[contains(text(),'Primary Appliction')]");
    associatedAppBadge = app.newElement(Locator.XPATH, "//span[contains(text(),'Associated Application(s)')]");
    reviewDispositionButton = app.newElement(Locator.PARTIALLINKTEXT, "<Review Disposition>");
  }

  public void verifyInfoTables() {
    appInfoTable.waitForState().present(60);
    appInfoTable.assertContains().rows(4);
    entityInfoTable.waitForState().present(60);
    entityInfoTable.assertContains().rows(4);
    reviewAppButton.is().enabled();
    reviewAppButton.click();
    app.goBack();
  }

  public void verifyMessageTextAndAssert(String msgText) {
    messageText.waitForState().displayed(60);
    app.azzert().textPresent(msgText);
  }

  public void verifyCurrentStatusAndAssert(String status) {
    currentCaseStatus.waitForState().displayed(60);
    currentCaseStatus.assertContains().text(status);
  }

  public void verifyTimelineIsPresentAndAssert() {
    timelineTab.waitForState().displayed();
  }

  public void verifyTimelineStatusAndAssert(String status) {
    currentStatus.waitForState().displayed();
    currentStatus.assertContains().text(status);
  }

  public void routedAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    processAppButton.waitForState().displayed();
    processAppButton.click();
  }

  public void inReviewAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    continueProcessingApp.waitForState().displayed();
    continueProcessingApp.click();
    dispostionButton.waitForState().enabled();
    // app.goBack();
  }

  public void clonedPrimaryAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    app.azzert().textPresent("Primary Application Overview");
    relatedAppSection.waitForState().displayed(60);
    associatedAppLink.waitForState().enabled();
    continueProcessingApp.waitForState().notPresent();
    associatedAppBadge.waitForState().present();
  }

  public void clonedChildAppValidationAndAssert() {
    associatedAppLink.waitForState().enabled();
    associatedAppLink.click();
    reviewAppButton.waitForState().enabled(60);
    app.azzert().textPresent("Associated Application Overview");
    relatedAppSection.waitForState().displayed(60);
    primaryAppBadge.waitForState().present();
  }

  public void closedAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    viewDispositionLink.is().enabled();
  }

  public void dispositionedAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    reviewDispositionButton.is().enabled();
  }

  public void inProgressAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    viewDispositionLink.waitForState().notPresent();
    processAppButton.waitForState().notPresent();
    continueProcessingApp.waitForState().notPresent();
  }

  public void assignedAppValidationAndAssert() {
    reviewAppButton.is().enabled();
    app.azzert().textPresent("Application Assigned");
  }

  public void routedToAppValidationAndAssert(String routed){
    app.maximize();
    app.azzert().textPresent(routed);
  }

  public void navigateToAppReview(){
    app.waitFor().textPresent("Application Overview");
    reviewAppButton.click();
  }
}
