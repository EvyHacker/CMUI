package functional;


import com.coveros.selenified.Selenified;
import framework.pages.*;
import framework.pages.AppOverview;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppOverviewIT extends Selenified {

  private final ThreadLocal<AppOverview> AppOverviewIT = new ThreadLocal<>();

  @BeforeMethod(alwaysRun = true)
  public void setLogIn() {
    AppOverviewIT.set(new AppOverview(this.apps.get()));
    Login loginPage = new Login(this.apps.get());
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    loginPage.navigateToLoginPage();
    loginPage.login("QO35", "password");
    AppOverview AppOverviewPage = this.AppOverviewIT.get();
    WorkQPage.navigateToWorkQueue();
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass(ITestContext test) {
    setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
  }
  @Test
  public void checkInProgressApplicationAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusInProgressAndAssert(getTestSite(this.getClass().getName(), context));
    String status = "In Progress";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      AppViewPage.inProgressAppValidationAndAssert();
    }
    finish();
  }
  @Test
  public void checkRoutedApplicationAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusRoutedAndAssert(getTestSite(this.getClass().getName(), context));
    String status = "Routed";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      String msgText = "The application has been successfully submitted and is now ready for processing.";
      AppViewPage.verifyMessageTextAndAssert(msgText);
      AppViewPage.routedAppValidationAndAssert();
    }
    finish();
  }

  @Test
  public void checkInReviewApplicationAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusInReviewAndAssert(getTestSite(this.getClass().getName(), context));
    String status = "In Review";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      AppViewPage.inReviewAppValidationAndAssert();
    }
    finish();
  }

  @Test
  public void checkPrimaryApplicationAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusCloned(getTestSite(this.getClass().getName(), context));
    String status = "Duplicated";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      String msgText = "This application will be processed by multiple Medicare Administrative Contractors (MACs) based on the locations where the applicant renders health care services.";
      AppViewPage.verifyMessageTextAndAssert(msgText);
      AppViewPage.clonedPrimaryAppValidationAndAssert();
    }
    finish();
  }

  @Test
  public void checkAssociatedApplicationAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusCloned(getTestSite(this.getClass().getName(), context));
    String status = "Duplicated";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      String msgText = "This application will be processed by multiple Medicare Administrative Contractors (MACs) based on the locations where the applicant renders health care services.";
      AppViewPage.verifyMessageTextAndAssert(msgText);
      AppViewPage.clonedPrimaryAppValidationAndAssert();
      AppViewPage.clonedChildAppValidationAndAssert();
    }
    finish();
  }

  @Test
  public void checkClosedApplicationAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusClosed(getTestSite(this.getClass().getName(), context));
    String status = "Closed";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      AppViewPage.closedAppValidationAndAssert();
    }
    finish();
  }

  @Test
  public void checkDispositionedApplicationAndAssert(ITestContext context){
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusDispositioned(getTestSite(this.getClass().getName(), context));
    String status = "Dispositioned";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      AppViewPage.dispositionedAppValidationAndAssert();
    }
    finish();
  }

  @Test
  public void checkManualAssignmentAndAssert(ITestContext context) {
    WorkQ WorkQPage = new WorkQ(this.apps.get());
    AppOverview AppViewPage = new AppOverview(this.apps.get());
    WorkQPage.setStatusAssigned(getTestSite(this.getClass().getName(), context));
    String status = "Assigned";
    if (WorkQPage.isRowReturned()>2) {
      WorkQPage.casePreviewToAppOverview();
      AppViewPage.verifyInfoTables();
      AppViewPage.verifyTimelineIsPresentAndAssert();
      AppViewPage.verifyTimelineStatusAndAssert(status);
      AppViewPage.assignedAppValidationAndAssert();
    }
    finish();
  }
}
