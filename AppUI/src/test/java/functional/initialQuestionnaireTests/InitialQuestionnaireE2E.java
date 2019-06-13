package functional.initialQuestionnaireTests;

import com.coveros.selenified.Selenified;
import framework.pages.Dashboard;
import framework.pages.Login;
import framework.pages.NationalProfileInd;
import org.testng.ITestContext;
import framework.pages.initialQuestionnaire.InitialQuestionnaire;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;


public class InitialQuestionnaireE2E extends Selenified {

    private final ThreadLocal<InitialQuestionnaire> iqPage = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setLogin() {
        Login loginPage = new Login(this.apps.get());
        NationalProfileInd nrpmIndPage = new NationalProfileInd(this.apps.get());
        iqPage.set(new InitialQuestionnaire(this.apps.get()));
        loginPage.navigateToLoginPage();
        loginPage.login("QO35", "password");
        Dashboard dashboard = new Dashboard(this.apps.get());
        dashboard.clickDevLinks();
        dashboard.navigateToMendezProfile();
        nrpmIndPage.createApplicationFromEnrollment();

        //dashboard.clickForExistingProvider2Btn();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        //sets the base URL for tests
        setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
    }

    @DataProvider(name = "submissionReasons", parallel = true)
    public Object[][] submissionReasons() throws IOException {
        return new Object[][]{new Object[]{0, 1},
        };
    }

    @Test
    //This will select the 855I
    public void Select855I() {
        InitialQuestionnaire iq = new InitialQuestionnaire(this.apps.get());
        iq.clickVisitSection();
        iq.selectFormType("855I");
        finish();
    }

    @Test(dataProvider = "submissionReasons")
    public void CompleteIqForm855I(int submissionReason, int section) {
        InitialQuestionnaire iq = new InitialQuestionnaire(this.apps.get());
        iq.clickVisitSection();
        iq.selectFormType("855I");
        iq.selectSubmissionReason(0);
        iq.clickReassignmentYes();
        iq.selectEftCheckBox();
        iq.saveAndContinue();
        finish();
    }

    @Test(dataProvider = "submissionReasons")
    public void CompleteIqForm855B(int submissionReason, int section) {
        InitialQuestionnaire iq = new InitialQuestionnaire(this.apps.get());
        iq.clickVisitSection();
        iq.selectFormType("855B");
        iq.selectSubmissionReason(1);
        iq.clickReassignmentYes();
        iq.selectEftCheckBox();
        iq.saveAndContinue();
        finish();
    }

    @Test(dataProvider = "submissionReasons")
    public void CompleteIqForm855A(int submissionReason, int section) {
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        iqPage.clickVisitSection();
        iqPage.selectFormType("855A");
        iqPage.selectSubmissionReason(2);
        iqPage.clickReassignmentYes();
        iqPage.selectEftCheckBox();
        iqPage.saveAndContinue();
        finish();
    }

    @Test(dataProvider = "submissionReasons")
    public void CompleteIqForm855R(int submissionReason, int section) {
        InitialQuestionnaire iq = new InitialQuestionnaire(this.apps.get());
        iq.clickVisitSection();
        iq.selectFormType("855R");
        iq.selectSubmissionReason(3);
        iq.selectEftCheckBox();
        iq.saveAndContinue();
        finish();
    }

    @Test(dataProvider = "submissionReasons")
    public void CompleteIqForm855O(int submissionReason, int section) {
        InitialQuestionnaire iq = new InitialQuestionnaire(this.apps.get());
        iq.clickVisitSection();
        iq.selectFormType("855O");
        iq.selectSubmissionReason(1);
        iq.saveAndContinue();
        finish();
    }
    @Test(dataProvider = "submissionReasons")
    public void CompleteIqFormEFT(int submissionReason, int section) {
        InitialQuestionnaire iq = new InitialQuestionnaire(this.apps.get());
        iq.clickVisitSection();
        iq.selectFormType("588");
        iq.selectSubmissionReason(0);
        iq.selectSubmissionReason(1);
        iq.selectSubmissionReason(2);
        iq.selectSubmissionReason(3);
        iq.saveAndContinue();
        finish();
    }
}
