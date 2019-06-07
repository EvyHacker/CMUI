package functional;

import com.coveros.selenified.Browser;
import com.coveros.selenified.Capabilities;
import com.coveros.selenified.OutputFile;
import com.coveros.selenified.Selenified;
import com.coveros.selenified.exceptions.InvalidBrowserException;
import com.coveros.selenified.services.Call;
import com.coveros.selenified.services.HTTP;
import com.google.gson.JsonArray;
//import framework.api.Case;
import framework.pages.Form855i.Application855i;
import framework.pages.Login;
import framework.pages.WorkQ;
import framework.pages.*;
import framework.pages.initialQuestionnaire.InitialQuestionnaire;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * @author Sukanya
 * Functional Test for Work Q
 */

public class WorkQIT extends Selenified {

  private final ThreadLocal<WorkQ> WorkQIT = new ThreadLocal<>();

  @BeforeMethod(alwaysRun = true)
  public void setLogIn() {
    WorkQIT.set(new WorkQ(this.apps.get()));
    Login loginPage = new Login(this.apps.get());
    loginPage.navigateToLoginPage();
    loginPage.login("Anna", "password");
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.navigateToWorkQueue();
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass(ITestContext test) throws InvalidBrowserException {
    // set the base URL for the tests here
    setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");

    /*// determining the providers
    Case caze = new Case(new Call(new HTTP(getTestSite(this.getClass().getName(),test)),
      new OutputFile("/tmp", "setup", new Capabilities(new Browser("None")), null,
        null, null, null, null, null), null));
    JsonArray providers = caze.getProviders();
    // at least 10 rows of data are needed on the WorkQ
    // creating them here for each test case to have access to
    // looping through the available providers, using mods
    for (int count = 0; count < 10; count++) {
      caze.createCase(caze.getProviderId(providers.get(count % providers.size()).getAsJsonObject()), "855I", "INITIAL_ENROLLMENT");
    }*/
  }

  @Test
  public void verifyWorkQTable() {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.verifyWorkQueuePage();
    finish();
  }

  @Test
  public void noFiltersTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.clickOnQuickFilters();
    WorkQPage.selectNoFiltersAndAssertURL(getTestSite(this.getClass().getName(), context));
    finish();
  }

  @Test
  public void unAssignedFiltersTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.clickOnQuickFilters();
    int contractCodes = 15102;
    WorkQPage.selectUnassignedFiltersAndAssertURL(getTestSite(this.getClass().getName(), context), contractCodes);
    finish();
  }

  @Test
  public void assignedFiltersTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.clickOnQuickFilters();
    String userId = "anna";
    WorkQPage.selectAssignedToMeFiltersAndAssertURL(getTestSite(this.getClass().getName(), context), userId);
    finish();
  }

  @Test
  public void allTasksFiltersTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.clickOnQuickFilters();
    int contractCodes = 15102;
    WorkQPage.selectAllTasksFiltersAndAssertURL(getTestSite(this.getClass().getName(), context), contractCodes);
    finish();
  }

  @Test
  public void closedTasksFiltersTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.clickOnQuickFilters();
    int contractCodes = 15102;
    WorkQPage.selectClosedFiltersAndAssertURL(getTestSite(this.getClass().getName(), context), contractCodes);
    finish();
  }

  @Test
  public void openTasksFiltersTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.clickOnQuickFilters();
    int contractCodes = 15102;
    WorkQPage.selectOpenFiltersAndAssertURL(getTestSite(this.getClass().getName(), context), contractCodes);
    finish();
  }

  @Test
  public void keywordSearchTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    String keyword = "Anna";
    String formType = "855B,855I";
    WorkQPage.setKeywordStringAndAssertURL(getTestSite(this.getClass().getName(), context), keyword);
    WorkQPage.setFormType855B(getTestSite(this.getClass().getName(), context));
    WorkQPage.setFormType855IAndAssert(getTestSite(this.getClass().getName(), context), keyword, formType);
    finish();
  }

  @Test
  public void statusKeywordTest(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    String status = "routed";
    WorkQPage.statusKeywordSearchAndAssertURL(getTestSite(this.getClass().getName(), context), status);
    finish();
  }


  @Test
  public void statusDispositioned(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.setStatusDispositioned(getTestSite(this.getClass().getName(), context));
    finish();
  }


  @Test(enabled = false)
  public void statusManualAssignment() {
    WorkQ WorkQPage = this.WorkQIT.get();
    String assignee = "Anna";
    WorkQPage.setManualAssignmentAndAssert(assignee);
    finish();
  }

  @Test
  public void reasonInitialEnrollment(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    String submittalReason = "INITIAL_ENROLLMENT";
    WorkQPage.setInitialEnrollment(getTestSite(this.getClass().getName(), context), submittalReason);
    finish();
  }

  @Test
  public void reasonEnrollingWithAnotherPractice(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    String submittalReason = "ENROLLING_WITH_ANOTHER_PRACTICE";
    WorkQPage.setInitialEnrollingWithAnotherPractice(getTestSite(this.getClass().getName(), context), submittalReason);
    finish();
  }

  @Test
  public void reasonReactivatingEnrollment(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    String submittalReason = "REACTIVATION";
    WorkQPage.setReasonReactivatingEnrollment(getTestSite(this.getClass().getName(), context), submittalReason);
    finish();
  }

  @Test
  public void reasonRevalidationEnrollment(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    String submittalReason = "REVALIDATION";
    WorkQPage.setReasonRevalidatingEnrollmentEnrollment(getTestSite(this.getClass().getName(), context), submittalReason);
    finish();
  }

  @Test
  public void reasonWithdrawal(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    String submittalReason = "WITHDRAWAL";
    WorkQPage.setReasonWithdrawal(getTestSite(this.getClass().getName(), context), submittalReason);
    finish();
  }

  @Test
  public void reasonChangeOfInformation(ITestContext context){
    WorkQ WorkQPage = this.WorkQIT.get();
    String submittalReason = "CHANGE_OF_INFORMATION";
    WorkQPage.setReasonChangingOfInformation(getTestSite(this.getClass().getName(), context), submittalReason);
    finish();
  }

  @Test
  public void statusCombo855IAndAssertBadges(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.setVerificationCombo855IAndAssert();
    finish();
  }

  @Test
  public void statusCombo855BAndAssertBadges(ITestContext context) {
    WorkQ WorkQPage = this.WorkQIT.get();
    WorkQPage.setVerificationCombo855BAndAssert();
    finish();
  }
}
