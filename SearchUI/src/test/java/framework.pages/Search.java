package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

import java.util.List;

/*
 * @author Sukanya
 * Search page
 */

public class Search {

  private final Element searchLink;
  private final Element headerText;
  private final Element searchString;
  private final Element searchButton;
  private final Element allTab;
  private final Element profilesTab;
  private final Element casesTab;
  private final Element medicareTab;
  private final Element enrollmentTab;
  private final Element paymentTab;
  private final Element siteVisitTab;
  private final Element fingerPrintTab;
  private final Element verifyAllList;
  private final Element verifyProfileTable;
  private final Element resultOne;



  private final App app;

  public Search(App app) {

    this.app = app;

    searchLink = app.newElement(Locator.ID, "header-search-input");
    headerText = app.newElement(Locator.XPATH, "//h1[contains(text(),'Search')]");
    searchString = app.newElement(Locator.XPATH, "//input[@type='text']");
    searchButton = app.newElement(Locator.XPATH, "(//*[@class='ds-c-icon'])[2]");
    allTab = app.newElement(Locator.PARTIALLINKTEXT, "All");
    profilesTab = app.newElement(Locator.PARTIALLINKTEXT, "Profiles");
    casesTab = app.newElement(Locator.PARTIALLINKTEXT, "Cases");
    medicareTab = app.newElement(Locator.PARTIALLINKTEXT, "Medicare Records");
    enrollmentTab = app.newElement(Locator.PARTIALLINKTEXT, "Enrollments");
    paymentTab = app.newElement(Locator.PARTIALLINKTEXT, "Payments");
    siteVisitTab = app.newElement(Locator.PARTIALLINKTEXT, "Site Visits");
    fingerPrintTab = app.newElement(Locator.PARTIALLINKTEXT, "Fingerprints");
    verifyAllList = app.newElement(Locator.XPATH, "//ul[@class='s-all-results']");
    verifyProfileTable = app.newElement(Locator.XPATH, "//table[1]");
    resultOne = app.newElement(Locator.XPATH, "//table[1]/tbody[1]/tr[1]/td[1]//a");
  }

  public void navigateToGlobalSearchAndAssert(String searchKeyword) {
    app.wait(10d);
    searchLink.waitForState().enabled();
    searchLink.type(searchKeyword);
    searchLink.submit();
    searchString.waitForState().enabled();
    // app.azzert().urlEquals(baseURL + "search/#/?keyword="+searchKeyword+"&type=all&page=0&size=20");
    app.azzert().textPresent("Search");
  }

  public void validateTablistAndAssert() {
    headerText.waitForState().displayed(30);
    app.azzert().textPresent("Search");
    allTab.waitForState().enabled();
    profilesTab.waitForState().enabled();
    casesTab.waitForState().notEditable();
    medicareTab.waitForState().notEditable();
    enrollmentTab.waitForState().notEditable();
    paymentTab.waitForState().notEditable();
    siteVisitTab.waitForState().notEditable();
    fingerPrintTab.waitForState().notEditable();

  }

  public void conductEmptyStringSearch(String searchKeyword) {
    searchLink.type(searchKeyword);
    searchLink.submit();
    app.azzert().textPresent("Dashboard");
  }

  public void validateAllResultsAndAssert(String searchKeyword) {
    if (verifyAllList.is().present()) {
      app.wait(1d);
      verifyAllList.findChild(verifyAllList).assertContains().text(searchKeyword);
    }
  }
  public void validateProfileTableAndAssert() {
    verifyProfileTable.waitForState().displayed(20);
    verifyProfileTable.assertEquals().text(0, 0, "Provider");
    verifyProfileTable.assertEquals().text(0, 1, "Address");
    verifyProfileTable.assertEquals().text(0, 2, "TIN");
    verifyProfileTable.assertEquals().text(0, 3, "NPI");
  }

  public void validateProfileTableRowsAndAssert(String searchKeyword) {
    app.wait(5d);
    verifyProfileTable.waitForState().displayed(15);
    int results = verifyProfileTable.get().numOfTableRows();
    for (int rnum = 1; rnum < results; rnum++) {
      Element row = verifyProfileTable.get().tableRow(rnum);
      row.assertContains().text(searchKeyword);
    }
  }

  public void navigateToProfileOverviewAndAssert() {
    resultOne.waitForState().enabled(15);
    resultOne.click();
    app.wait(30d);
    app.azzert().textPresent("Medicare Records");
  }

  public int numOfRowReturned() {
    profilesTab.click();
    app.wait(3d);
    if (verifyProfileTable.is().present()) {
      return verifyProfileTable.get().numOfTableRows();
    }
    return 0;
  }

  public void invalidSearchString() {
    app.wait(1d);
    app.azzert().textPresent("No results found for \"");
    profilesTab.click();
    app.wait(1d);
    app.azzert().textPresent("No results found for \"");
  }

}
