package functional;

//Evy

import com.coveros.selenified.Selenified;
import framework.pages.AppOverview;
import framework.pages.Login;
import framework.pages.WorkQ;
import framework.pages.Section8_ContactInfo;
import framework.pages.Search;
import framework.pages.initialQuestionnaire.InitialQuestionnaire;
import framework.pages.*;
import framework.pages.NationalProfileInd;
import framework.pages.Form855i.Application855i;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConditionalRouting855I extends Selenified {

    private final ThreadLocal<AppOverview> AppOverviewIT = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setLogIn() {
        AppOverviewIT.set(new AppOverview(this.apps.get()));
        Login loginPage = new Login(this.apps.get());
        WorkQ WorkQPage = new WorkQ(this.apps.get());
        Dashboard dashboard = new Dashboard(this.apps.get());
        loginPage.navigateToLoginPage();
        loginPage.login("QO35", "password");
        dashboard.clickDevLinks();
        //dashboard.navigateToMendezProfile();
        AppOverview AppOverviewPage = this.AppOverviewIT.get();

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
    }

    @Test
    public void inhsRouting855IYes() {
        NationalProfileInd nrpmPage = new NationalProfileInd(this.apps.get());
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        Section4_BusinessInfo section3 = new Section4_BusinessInfo(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Application855i app855i = new Application855i(this.apps.get());
        AppOverview AppOverviewPage = new AppOverview(this.apps.get());
        Search searchPage = new Search(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.validateProfileTableRowsAndAssert(searchKeyword);
            searchPage.navigateToProfileOverviewAndAssert();
            nrpmPage.createApplicationFromEnrollment();

            iqPage.clickVisitSection();

            iqPage.selectFormType("855I");
            iqPage.selectSubmissionReason(5);
            iqPage.clickReassignmentYes();
            iqPage.selectEftCheckBox();
            iqPage.saveAndContinue();

            iqPage.goToSection(3);
            section3.clickINHSYes();

            iqPage.startSubmission();
            app855i.assertInAppReview();
            appReview.setSubmitApplicationBtn();

            AppOverviewPage.routedToAppValidationAndAssert("Routed to Novitas");

        }
        finish();
    }

    @Test
    public void inhsRouting855INo() {
        NationalProfileInd nrpmPage = new NationalProfileInd(this.apps.get());
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        Section4_BusinessInfo section4 = new Section4_BusinessInfo(this.apps.get());
        Section5_PracticeLocation location = new Section5_PracticeLocation(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Application855i app855i = new Application855i(this.apps.get());
        AppOverview AppOverviewPage = new AppOverview(this.apps.get());
        Search searchPage = new Search(this.apps.get());

        String searchKeyword = "Mendez";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.validateProfileTableRowsAndAssert(searchKeyword);
            searchPage.navigateToProfileOverviewAndAssert();
            nrpmPage.createApplicationFromEnrollment();

            iqPage.clickVisitSection();

            iqPage.selectFormType("855I");
            iqPage.selectSubmissionReason(5);
            iqPage.clickReassignmentYes();
            iqPage.selectEftCheckBox();
            iqPage.saveAndContinue();

            iqPage.goToSection(3);
            section4.clickINHSNo();

            iqPage.goToSection(4);
            location.deleteAllLocations();
            location.addNewLocation("Florida");
            iqPage.saveAndContinue();

            iqPage.startSubmission();
            app855i.assertInAppReview();
            appReview.setSubmitApplicationBtn();

            AppOverviewPage.routedToAppValidationAndAssert("Routed to First Coast");
        }
        finish();
    }

    //Route based on Valid Group ID

    @Test
    public void validGroupId855R() {
        NationalProfileInd nrpmPage = new NationalProfileInd(this.apps.get());
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        Section5_PracticeLocation location = new Section5_PracticeLocation(this.apps.get());
        Section9_reassignmentData data = new Section9_reassignmentData(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Application855i app855i = new Application855i(this.apps.get());
        AppOverview AppOverviewPage = new AppOverview(this.apps.get());
        Search searchPage = new Search(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.validateProfileTableRowsAndAssert(searchKeyword);
            searchPage.navigateToProfileOverviewAndAssert();
            nrpmPage.createApplicationFromEnrollment();

            iqPage.clickVisitSection();

            iqPage.selectFormType("855I");
            iqPage.selectSubmissionReason(5);
            iqPage.clickReassignmentYes();
            iqPage.selectEftCheckBox();
            iqPage.saveAndContinue();

            iqPage.goToSection(4);
            location.rowCountLocations();
            if (location.rowCountLocations() < 2) {
                location.addNewLocation("Hawaii");
            } else {
                location.editLocation("Hawaii");
            }
            location.mainSaveAndContinue();

            iqPage.goToSection(10);
            data.addReassignmentData();

            iqPage.startSubmission();
            app855i.assertInAppReview();
            appReview.setSubmitApplicationBtn();

            AppOverviewPage.routedToAppValidationAndAssert("Routed to Noridian");
        }
        finish();

    }

    //Route based on ContractID
    @Test
    public void validContractIdRouting855I() {
        NationalProfileInd nrpmPage = new NationalProfileInd(this.apps.get());
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        Section5_PracticeLocation location = new Section5_PracticeLocation(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Application855i app855i = new Application855i(this.apps.get());
        AppOverview AppOverviewPage = new AppOverview(this.apps.get());
        Search searchPage = new Search(this.apps.get());

        String searchKeyword = "Mendez";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.validateProfileTableRowsAndAssert(searchKeyword);
            searchPage.navigateToProfileOverviewAndAssert();
            nrpmPage.createApplicationFromEnrollment();
            iqPage.clickVisitSection();

            iqPage.selectFormType("855I");
            iqPage.selectSubmissionReason(5);
            iqPage.clickReassignmentYes();
            iqPage.selectEftCheckBox();
            iqPage.saveAndContinue();

            iqPage.goToSection(4);
            location.deleteAllLocations();
            location.addNewLocation("Alaska");
            iqPage.saveAndContinue();

            iqPage.startSubmission();
            app855i.assertInAppReview();
            appReview.setSubmitApplicationBtn();

            AppOverviewPage.routedToAppValidationAndAssert("Routed to Noridian");
        }
        finish();
    }

    //Practice Location
    @Test
    public void routeBasedOnPracticeLocation() {
        NationalProfileInd nrpmPage = new NationalProfileInd(this.apps.get());
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        Section5_PracticeLocation location = new Section5_PracticeLocation(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Application855i app855i = new Application855i(this.apps.get());
        AppOverview AppOverviewPage = new AppOverview(this.apps.get());

        Search searchPage = new Search(this.apps.get());

        String searchKeyword = "Mendez";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.validateProfileTableRowsAndAssert(searchKeyword);
            searchPage.navigateToProfileOverviewAndAssert();
            nrpmPage.createApplicationFromEnrollment();
            iqPage.clickVisitSection();

            iqPage.selectFormType("855I");
            iqPage.selectSubmissionReason(5);
            iqPage.clickReassignmentYes();
            iqPage.selectEftCheckBox();
            iqPage.saveAndContinue();

            iqPage.goToSection(4);

            location.deleteAllLocations();
            location.addNewLocation("Florida");
            iqPage.saveAndContinue();

            iqPage.startSubmission();
            app855i.assertInAppReview();
            appReview.setSubmitApplicationBtn();

            AppOverviewPage.routedToAppValidationAndAssert("Routed to First Coast");
        }
        finish();
    }

    @Test
    public void routeBasedOnContactInformation() {
        NationalProfileInd nrpmPage = new NationalProfileInd(this.apps.get());
        InitialQuestionnaire iqPage = new InitialQuestionnaire(this.apps.get());
        Section5_PracticeLocation location = new Section5_PracticeLocation(this.apps.get());
        Section8_ContactInfo contactInfo = new Section8_ContactInfo(this.apps.get());
        ApplicationReview appReview = new ApplicationReview(this.apps.get());
        Application855i app855i = new Application855i(this.apps.get());
        AppOverview AppOverviewPage = new AppOverview(this.apps.get());

        Search searchPage = new Search(this.apps.get());

        String searchKeyword = "Mendez";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.validateProfileTableRowsAndAssert(searchKeyword);
            searchPage.navigateToProfileOverviewAndAssert();
            nrpmPage.createApplicationFromEnrollment();
            iqPage.clickVisitSection();

            iqPage.selectFormType("855I");
            iqPage.selectSubmissionReason(5);
            iqPage.clickReassignmentYes();
            iqPage.selectEftCheckBox();
            iqPage.saveAndContinue();

            iqPage.goToSection(4);
            location.deleteAllLocations();
            iqPage.saveAndContinue();

            iqPage.goToSection(7);
            contactInfo.removeExistingContactInfo();
            contactInfo.addNewContact("Florida");
            iqPage.saveAndContinue();


            iqPage.startSubmission();
            app855i.assertInAppReview();
            appReview.setSubmitApplicationBtn();

            AppOverviewPage.routedToAppValidationAndAssert("Routed to First Coast");
        }
        finish();
    }
}