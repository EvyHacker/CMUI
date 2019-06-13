package functional;

import com.coveros.selenified.Locator;
import com.coveros.selenified.Selenified;
import com.coveros.selenified.element.Element;
import framework.pages.*;
import framework.pages.Form855b.Application855b;
import framework.pages.initialQuestionnaire.InitialQuestionnaire;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;



/**
 * @author Brian Curtin
 * This test will create and submit an 855b applicaiton.
 * This test was originally created by Lija V and I modified it to suite Dev 3
 */

public class Application855bE2E extends Selenified {

    private final ThreadLocal<InitialQuestionnaire> iqPage = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setLogin() {
        Login loginPage = new Login(this.apps.get());
        NationalProfileInd nrpmIndPage = new NationalProfileInd(this.apps.get());
        loginPage.navigateToLoginPage();
        loginPage.login("QO35", "password");
        Dashboard dashboard = new Dashboard(this.apps.get());
        dashboard.clickDevLinks();
        dashboard.navigateToMendezProfile();
        nrpmIndPage.createApplicationFromEnrollment();
        iqPage.set(new InitialQuestionnaire(this.apps.get()));
    }


    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        //sets the base URL for tests
        setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
    }

    @DataProvider(name = "submissionReasons", parallel = true)
    public Object[][] submissionReasons() throws IOException {
        return new Object[][]{new Object[]{0, 0},
        };
    }


    @Test(dataProvider = "submissionReasons")
    public void TestSubmission855b(int submissionReason, int section) {
        InitialQuestionnaire iq = this.iqPage.get();
        Application855b app855b = new Application855b(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Section5_PracticeLocation location = new Section5_PracticeLocation((this.apps.get()));
        iq.clickVisitSection();
        iq.selectFormType("855B");
        iq.selectSubmissionReason(0);
        iq.clickReassignmentYes();
        iq.selectEftCheckBox();
        iq.saveAndContinue();
        //submit the application
        app855b.clickBeginSubmission();
        app855b.assertInAppReview();
        appReview.setSubmitApplicationBtn();
        finish();

    }
}

