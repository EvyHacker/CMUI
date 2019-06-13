
package functional;

import com.coveros.selenified.Selenified;
import framework.pages.*;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class nrpmPagesTests extends Selenified {

    @BeforeMethod(alwaysRun = true)
    public void setLogin() {
        Login loginPage = new Login(this.apps.get());
        loginPage.navigateToLoginPage();
        loginPage.login("QO35", "password");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        //sets the base URL for tests
        setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");

    }

// Individual Profile Tests
// Test suite that navigates through the individual profile and verifies elements on each page

    // Search for provider and then verify side navigation elements on the provider profile page
    @Test
    public void validateSideNavAndAssertSections(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.validateSideNavAndAssert();
        }
        finish();
    }

    // Search for provider and then verify elements on the overview tab of provider profile page
    @Test
    public void individualOverviewTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualOverviewTabAndAssert();
            finish();
        }
    }

    // Search for provider and then verify elements on the Identification tab of the provider profile page
    @Test
    public void individualIdentificationTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualIdentificationTabAndAssert();
            finish();
        }
    }

    // Search for provider and then verify elements on the Relationships tab of the provider profile page
    @Test
    public void individualRelationsTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualRelationshipsTabAndAssert();
            finish();
        }
    }
    // Search for provider and then verify elements on the Billing tab of the provider profile page
    @Test
    public void individualBillingTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualBillingTabAndASsert();
            finish();
        }
    }

    // Search for provider and then verify elements on the Locations tab of the provider profile page
    @Test
    public void individualLocationsTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualLocationsTabAndASsert();
            finish();
        }
    }

    // Verify elements on the Medicare Record Overview page
    @Test
    public void individualMedicareRecordsPageAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualMedicareRecordPageAndAssert();
            finish();
        }
    }

    // Verify elements on the Enrollment Overview Page
    @Test
    public void individualEnrollmentsOverviewAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualEnrollmentOverviewAndAssert();
            finish();
        }

    }

    // Verify elements on the Enrollment Details Page
    @Test
    public void individualEnrollmentDetailsAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualEnrollmentOverviewAndAssert();
            profile.enrollmentDetailsPageAndAssert();
            profile.enrollmentDetailsAddressTableAssert();
            profile.enrollmentDetailsLocationTableAssert();
            profile.medicalRecordStorageTableAssert();
            profile.ptanAndNpiTableAssert();
            finish();
        }
    }

    // Verify elements in the breadcrumb header
    @Test
    public void individualBreadcrumbsValidationAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileInd profile = new NationalProfileInd(this.apps.get());

        String searchKeyword = "Wilson";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            profile.individualVerifyBreadcrumbContentAndAssert();
            finish();
        }
    }



// Org Profile Tests
// Test suite that navigates through the org profile to verify elements on each page

    // Search for org provider and then verify elements on the overview tab of provider profile page
    @Test
    public void orgOverviewTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgOverviewTabAndAssert();
            finish();
        }
    }

    // Search for org provider and then verify elements on the Identification tab of the provider profile page
    @Test
    public void orgIdentificationTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgIdentificationTabAndAssert();
            finish();
        }
    }

    // Search for org provider and then verify elements on the Relationships tab of the provider profile page
    @Test
    public void orgRelationsTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgRelationshipsTabAndASsert();
            finish();
        }
    }

    // Search for org provider and then verify elements on the Billing tab of the provider profile page
    @Test
    public void orgBillingTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgBillingTabAndASsert();
            finish();
        }
    }

    // Search for org provider and then verify elements on the Locations tab of the provider profile page
    @Test
    public void orgLocationsTabAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgLocationsTabAndASsert();
            finish();
        }
    }

    // Verify elements on the org Medicare Record Overview page
    @Test
    public void orgMedicareRecordsPageAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 1) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgEnrollmentTableAndAssert();
            finish();
        }
    }

    // Verify elements on the org Enrollment Overview page
    @Test
    public void orgEnrollmentsOverviewAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 1) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgEnrollmentOverviewAndAssert();
            finish();
        }
    }
    // Verify elements in the org profile breadcrumb header
    @Test
    public void orgBreadcrumbsValidationAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 1) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgVerifyBreadcrumbContentAndAssert();
            finish();
        }
    }

    // Verify elements on the Org profile Enrollment Details Page
    @Test
    public void orgEnrollmentDetailsPageAndAssert(ITestContext context) {
        Search searchPage = new Search(this.apps.get());
        NationalProfileOrg orgProfile = new NationalProfileOrg(this.apps.get());

        String searchKeyword = "MedNova";
        searchPage.navigateToGlobalSearchAndAssert(searchKeyword);
        if (searchPage.numOfRowReturned() > 0) {
            searchPage.validateProfileTableAndAssert();
            searchPage.navigateToProfileOverviewAndAssert();
            orgProfile.orgEnrollmentOverviewAndAssert();
            orgProfile.orgEnrollmentDetailsPageAndAssert();
            orgProfile.orgAddressLocationAndAssert();
            orgProfile.orgLocationDetailsAndAssert();
            orgProfile.orgMedicalRecordStorageAndAssert();
            orgProfile.orgPtanAndNpiTableAndAssert();
            finish();
        }
    }
}
