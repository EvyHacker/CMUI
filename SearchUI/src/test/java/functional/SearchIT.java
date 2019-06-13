package functional;

import com.coveros.selenified.Selenified;
import com.coveros.selenified.exceptions.InvalidBrowserException;
import framework.pages.Login;
import org.testng.ITestContext;
import framework.pages.Search;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchIT extends Selenified {

  private final ThreadLocal<Search> SearchIT = new ThreadLocal<>();

  @BeforeMethod(alwaysRun = true)
  public void setLogIn() {
    SearchIT.set(new Search(this.apps.get()));
    Login loginPage = new Login(this.apps.get());
    loginPage.navigateToLoginPage();
    loginPage.login("Anna", "password");
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass(ITestContext test) throws InvalidBrowserException {
    // set the base URL for the tests here
    setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
  }

  @Test
  public void navigateToSearch(ITestContext context) {
    Search searchPage = this.SearchIT.get();
    String searchKeyword = "Mendez";
    searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
    finish();
  }

  @Test
  public void validateSearchPageAndAssert(ITestContext context) {
    Search searchPage = this.SearchIT.get();
    String searchKeyword = "Mendez";
    searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
    searchPage.validateTablistAndAssert();
    finish();
  }

  @Test
  public void doEmptySearch(ITestContext context) {
    Search searchPage = this.SearchIT.get();
    String searchKeyword = " ";
    searchPage.conductEmptyStringSearch(searchKeyword);
    finish();
  }

  @Test
  public void doStringSearchAndAssertURL(ITestContext context) {
    Search searchPage = this.SearchIT.get();
    String searchKeyword = "Me";
    searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
    finish();
  }

  @Test
  public void doStringSearchAndAssertAllResults(ITestContext context){
    Search searchPage = this.SearchIT.get();
    String searchKeyword = "Me";
    searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
    searchPage.validateAllResultsAndAssert(searchKeyword);
    finish();
  }

  @Test
  public void invalidSearchAndAssert(ITestContext context) {
    Search searchPage = this.SearchIT.get();
    String searchKeyword = "ZZZ";
    searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
    searchPage.invalidSearchString();
    finish();
  }

  @Test
  public void doStringSearchAndNavigateToProfileView(ITestContext context) {
    Search searchPage = this.SearchIT.get();
    String searchKeyword = "Me";
    searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
    if (searchPage.numOfRowReturned() > 1) {
      searchPage.validateProfileTableAndAssert();
      searchPage.validateProfileTableRowsAndAssert(searchKeyword);
      searchPage.navigateToProfileOverviewAndAssert();
    }
    finish();
  }

}
