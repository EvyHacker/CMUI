package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;
import org.testng.Assert;

public class NationalProfileOrg {

    private final Element providerlist;
    private final Element recentProvider;
    private final Element medicareTable;
    private final Element enrollmentNumber;
    private final Element enrollmentLink;
    private final Element enrollmentNumLink;
    private final Element enrollmentTable;
    private final Element overviewTab;
    private final Element identificationTab;
    private final Element billingTab;
    private final Element relationshipsTab;
    private final Element locationsTab;
    private final Element createAppBtn;
    private final Element revalidateBtn;
    private final Element activeApplicationsTable;
    private final Element identificationTable;

    private final Element identifyingInfoTable1;
    private final Element licenseAndCertTable;
    private final Element alaTable;
    private final Element filterBtn;

    private final Element reassignmentsTable;
    private final Element associationsTable;
    private final Element entityProfileBreadCrumb;
    private final Element medicareBreadcrumb;
    private final Element enrollmentOverviewBreadcrumb;
    private final Element applicationsEnrollTable;

    private final Element enrollmentInfoTable;
    private final Element entityInfoTable;
    private final Element enrollmentHistoryTable;
    private final Element identifyingLink;

    private final Element currentEnrollmentDetailsButton;
    private final Element practiceLocationInformation;
    private final Element enrollmentDetailsBreadcrumb;
    private final Element addressLocation;
    private final Element addressLocationTable;
    private final Element locationDetails;
    private final Element locationDetailsTable;
    private final Element medicalRecordStorageFacility;
    private final Element medicalRecordStorageTable;
    private final Element ptanAndNpi;
    private final Element ptanAndNpiTable;

    private final App app;

    public NationalProfileOrg(App app) {

        providerlist = app.newElement(Locator.XPATH, "//ul[@class='nrpm-provider-list']");
        recentProvider = app.newElement(Locator.XPATH, "//ul[@class='nrpm-provider-list']//following::li[last()]");

        overviewTab = app.newElement(Locator.XPATH, "//li[contains(text(),'overview')]");
        identificationTab = app.newElement(Locator.XPATH, "//li[contains(text(),'identification')]");
        billingTab = app.newElement(Locator.XPATH, "//li[contains(text(),'billing')]");
        relationshipsTab = app.newElement(Locator.XPATH, "//li[contains(text(),'relationships')]");
        locationsTab = app.newElement(Locator.XPATH, "//li[contains(text(),'locations')]");

        //overview Tab
        medicareTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
        activeApplicationsTable = app.newElement(Locator.XPATH, "(//table)[2]");
        identificationTable = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[1]");
        identifyingLink = app.newElement(Locator.PARTIALLINKTEXT, "View All Identifying Information");

        //identification tab
        identifyingInfoTable1 = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[1]");
        licenseAndCertTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
        alaTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[2]");
        filterBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Filter')]");

        // relationships tab
        reassignmentsTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable nrpm-relationships table'])[1]");
        associationsTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable']");

        //breadcrumbs
        entityProfileBreadCrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[1]");
        medicareBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[2]");
        enrollmentOverviewBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[3]//div[1]");

        //Medicare Record Table
        //a[contains(text(),'DME')]
        enrollmentLink = app.newElement(Locator.PARTIALLINKTEXT, "DME");
        enrollmentNumLink = app.newElement(Locator.XPATH, "//table[1]/tbody[1]/tr[1]/td[3]");
        enrollmentTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
        applicationsEnrollTable = app.newElement(Locator.XPATH, "(//table)[2]");

        //enrollment Overview table
        enrollmentInfoTable = app.newElement(Locator.XPATH, "(//div[@class='nrpm--enrollment-info']//table)[1]");
        entityInfoTable = app.newElement(Locator.XPATH, "(//div[@class='nrpm--enrollment-info']//table)[2]");
        enrollmentHistoryTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable']");

        enrollmentNumber = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]//tbody//td[3]");
        createAppBtn = app.newElement(Locator.NAME, "createApplicationButton");
        revalidateBtn = app.newElement(Locator.NAME, "revalidationButton");

        //enrollment details page
        currentEnrollmentDetailsButton = app.newElement(Locator.XPATH, "(//a//button)[2]");
        enrollmentDetailsBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[4]//div[1]");
        practiceLocationInformation = app.newElement(Locator.CLASSNAME, "nrpm--enrollment-practice_location");
        addressLocation = app.newElement(Locator.XPATH, "//div[contains(text(),'Address Location')][1]");
        addressLocationTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[1]");
        locationDetails = app.newElement(Locator.XPATH, "//div[contains(text(),'Location Details')][1]");
        locationDetailsTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[2]");
        medicalRecordStorageFacility = app.newElement(Locator.XPATH, "//div[contains(text(),'Medical Record Storage Facility Address')][1]");
        medicalRecordStorageTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[3]");
        ptanAndNpi = app.newElement(Locator.XPATH, "//div[contains(text(),'PTAN & NPI Associations')][1]");
        ptanAndNpiTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[4]");


        this.app = app;
    }

    public void enrollmentCreationSingleAssert() {
        app.refresh();
        app.wait(30d);
        medicareTable.waitForState().displayed(20);
        enrollmentNumber.assertEquals().text("1");

    }

    public void enrollmentCreationClonedAssert() {
        app.wait(15d);
        app.refresh();
        medicareTable.waitForState().displayed(20);
        enrollmentNumber.assertEquals().text("2");
        enrollmentLink.click();
        app.wait(10d);
        app.waitFor().textPresent("Enrollments");
        enrollmentTable.waitForState().displayed(15);
        int rowsCount = enrollmentTable.get().numOfTableRows();
        Assert.assertEquals(rowsCount, 3);
    }

    public void orgVerifyBreadcrumbContentAndAssert() {

        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTable.waitForState().displayed(5d);
        enrollmentNumLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();
        //breadcrumb content
        enrollmentOverviewBreadcrumb.assertContains().text("Enrollment Overview");
        enrollmentOverviewBreadcrumb.assertContains().text("Enrollment ID");
        enrollmentOverviewBreadcrumb.assertContains().text("Revalidation");
        enrollmentOverviewBreadcrumb.assertContains().text("Status");

        medicareBreadcrumb.assertContains().text("Status");

        entityProfileBreadCrumb.assertContains().text("EIN");
        entityProfileBreadCrumb.assertContains().text("Status");
    }

    public void orgOverviewTabAndAssert() {

        app.wait(30d);
        overviewTab.click();
        createAppBtn.waitForState().enabled(10d);
        app.azzert().textPresent("Medicare Records");
        identifyingLink.assertState().enabled();

        entityProfileBreadCrumb.assertContains().text("Entity Profile");

        //verify Medicare Record table
        medicareTable.waitForState().displayed();
        medicareTable.assertEquals().text(0, 0, "Entity Type");
        medicareTable.assertEquals().text(0, 1, "Status");
        medicareTable.assertEquals().text(0, 2, "Enrollments");
        medicareTable.assertEquals().text(0, 3, "States");
        medicareTable.assertEquals().text(0, 4, "Revalidation Status");
        medicareTable.assertEquals().text(0, 5, "Actions");

        // verify active apps table
        activeApplicationsTable.waitForState().displayed();
        activeApplicationsTable.get().tableCell(0, 0).assertContains().text("Case ID");
        activeApplicationsTable.assertEquals().text(0, 1, "Application ID");
        activeApplicationsTable.assertEquals().text(0, 2, "Submission Date");
        activeApplicationsTable.assertEquals().text(0, 3, "Application Submittal Reason");
        activeApplicationsTable.assertEquals().text(0, 4, "Status");

        // Verify Identification table
        identificationTable.waitForState().displayed();
        identificationTable.assertEquals().text(0, 0, "Date Created");
        identificationTable.assertEquals().text(1, 0, "Country of Practice:");
        identificationTable.assertEquals().text(2, 0, "Number of States:");
        identificationTable.assertEquals().text(3, 0, "EIN:");
        identificationTable.assertEquals().text(4, 0, "Number of Practitioners:");
        identificationTable.assertEquals().text(5, 0, "Number of Locations:");

        //navigate to identifying info
        identifyingLink.click();
        app.waitFor().textPresent("Identifying Information");
    }

    public void orgEnrollmentTableAndAssert() {

        app.refresh();
        app.wait(30d);
        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTable.waitForState().displayed(5d);
        createAppBtn.is().present();

        //verify breadcrumbs
        entityProfileBreadCrumb.assertContains().text("Entity Profile");
        medicareBreadcrumb.assertContains().text("Medicare Record");

        //verify enrollments table
        app.azzert().textPresent("Group Enrollments");
        enrollmentTable.assertEquals().text(0, 0, "Doing Business As");
        enrollmentTable.assertEquals().text(0, 1, "State");
        enrollmentTable.assertEquals().text(0, 2, "Enrollment Number");
        enrollmentTable.assertEquals().text(0, 3, "Status");
        enrollmentTable.assertEquals().text(0, 4, "Effective Date");
        enrollmentTable.assertEquals().text(0, 5, "Revalidation Status");
        enrollmentTable.assertEquals().text(0, 6, "MAC / Jurisdiction");
        enrollmentTable.assertEquals().text(0, 7, "Locations");

        // Verify active apps table
        applicationsEnrollTable.get().tableCell(0, 0).assertContains().text("Case ID");
        applicationsEnrollTable.assertEquals().text(0, 1, "Application ID");
        applicationsEnrollTable.assertEquals().text(0, 2, "Submission Date");
        applicationsEnrollTable.assertEquals().text(0, 3, "Application Submittal Reason");
        applicationsEnrollTable.assertEquals().text(0, 4, "Status");
        applicationsEnrollTable.assertEquals().text(0, 5, "Submitted By");
        applicationsEnrollTable.assertEquals().text(0, 6, "State");
        applicationsEnrollTable.assertEquals().text(0, 7, "PTAN");

        //Verify Timeline
        app.azzert().textPresent("Timeline");

    }

    public void orgEnrollmentOverviewAndAssert() {

        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTable.waitForState().displayed(5d);
        enrollmentNumLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();

        //enrollment info table
        enrollmentInfoTable.waitForState().displayed();
        enrollmentInfoTable.assertEquals().text(0, 0, "Enrollment ID:");
        enrollmentInfoTable.assertEquals().text(1, 0, "State / Territory:");
        enrollmentInfoTable.assertEquals().text(2, 0, "Effective Date:");
        enrollmentInfoTable.assertEquals().text(3, 0, "MAC / Jurisdiction:");

        //entity info table
        entityInfoTable.waitForState().displayed();
        /*entityInfoTable.assertEquals().text(0, 0, "Doing Business As:");
        entityInfoTable.assertEquals().text(1, 0, "TAX ID:");
        entityInfoTable.assertEquals().text(2, 0, "NPI:");*/

        //
        enrollmentHistoryTable.waitForState().displayed();
/*
        app.waitFor().textPresent("Viewing");
*/
        enrollmentHistoryTable.assertEquals().text(0, 0, "<Version>");
        enrollmentHistoryTable.assertEquals().text(0, 1, "<Time updated>");
        enrollmentHistoryTable.assertEquals().text(0, 2, "<Reason for Change>");
        enrollmentHistoryTable.assertEquals().text(0, 3, "<What changed record>");
        enrollmentHistoryTable.assertEquals().text(0, 4, "Org");
        enrollmentHistoryTable.assertEquals().text(0, 5, "State");
        enrollmentHistoryTable.assertEquals().text(0, 6, "Case ID");
    }

    public void orgIdentificationTabAndAssert() {

        identificationTab.click();
        createAppBtn.assertState().notPresent();
        app.azzert().textPresent("Identifying Information");

        //info table assert
        identifyingInfoTable1.assertState().present();
        identifyingInfoTable1.get().tableRow(0).assertContains().text("EIN:");
        identifyingInfoTable1.get().tableRow(1).assertContains().text("Number of States:");
        identifyingInfoTable1.get().tableRow(2).assertContains().text("Practitioners:");
        identifyingInfoTable1.get().tableRow(3).assertContains().text("Locations:");

        //Licence table assert
        licenseAndCertTable.assertState().present();
        filterBtn.assertState().enabled();
        licenseAndCertTable.get().tableCell(0, 3).assertContains().text("Effective Date");
        licenseAndCertTable.assertEquals().text(0, 0, "Type");
        licenseAndCertTable.assertEquals().text(0, 1, "ID");
        licenseAndCertTable.assertEquals().text(0, 2, "Issuing State");
        licenseAndCertTable.assertEquals().text(0, 4, "Expiration Date");

        // ala table assert
        alaTable.assertState().present();
        alaTable.get().tableCell(0, 0).assertContains().text("Category");
        alaTable.get().tableCell(0, 1).assertContains().text("Reason");
        alaTable.get().tableCell(0, 2).assertContains().text("Date Reported");
        alaTable.get().tableCell(0, 3).assertContains().text("Date of Action");
        alaTable.get().tableCell(0, 4).assertContains().text("Action Taken By");
    }

    public void orgRelationshipsTabAndASsert() {

        relationshipsTab.click();
        app.azzert().textPresent("Reassignments / Employment Relationships");
        //reassignment table assert
        reassignmentsTable.assertState().present();
        reassignmentsTable.get().tableCell(0, 0).assertContains().text("Entity Name");
        reassignmentsTable.get().tableCell(0, 1).assertContains().text("NPI");
        reassignmentsTable.get().tableCell(0, 2).assertContains().text("PTAN");
        reassignmentsTable.get().tableCell(0, 3).assertContains().text("Effective Date");
        reassignmentsTable.get().tableCell(0, 4).assertContains().text("End Date");

        //associations table
        associationsTable.assertState().present();
        associationsTable.get().tableCell(0, 0).assertContains().text("Entity Name");
        associationsTable.get().tableCell(0, 1).assertContains().text("Type of Relationship");
        associationsTable.get().tableCell(0, 2).assertContains().text("Effective Date");
        associationsTable.get().tableCell(0, 3).assertContains().text("End Date");

    }

    public void orgBillingTabAndASsert() {

        billingTab.click();
        app.azzert().textPresent("No data to display");
    }

    public void orgLocationsTabAndASsert() {

        locationsTab.click();
        app.azzert().textPresent("No data to display");
    }

    //enrollment details page
    public void orgEnrollmentDetailsPageAndAssert() {
        currentEnrollmentDetailsButton.waitForState().enabled(20);
        currentEnrollmentDetailsButton.click();
        enrollmentDetailsBreadcrumb.assertContains().text("Enrollment Details");
        app.azzert().textPresent("Address Location");
        practiceLocationInformation.waitForState().displayed(20);
        addressLocation.waitForState().displayed();
        locationDetails.waitForState().displayed();
        medicalRecordStorageFacility.waitForState().displayed();
        ptanAndNpi.waitForState().displayed();
    }

    //address location table
    public void orgAddressLocationAndAssert(){
        addressLocationTable.waitForState().present();
        addressLocationTable.get().tableCell(0,0).assertContains().text("Practice Location Name");
        addressLocationTable.get().tableCell(1,0).assertContains().text("Practice Location Address");
        addressLocationTable.get().tableCell(2,0).assertContains().text("Telephone Number");
        addressLocationTable.get().tableCell(3,0).assertContains().text("Extension");
        addressLocationTable.get().tableCell(4,0).assertContains().text("Email Address");
        addressLocationTable.get().tableCell(5,0).assertContains().text("Special Payment Address");
        addressLocationTable.get().tableCell(6,0).assertContains().text("Effective Date");
        addressLocationTable.get().tableCell(7,0).assertContains().text("End Date");
    }

    //Location Details table
    public void orgLocationDetailsAndAssert(){
        locationDetailsTable.waitForState().present();
        locationDetailsTable.get().tableCell(0, 0).assertContains().text("Date of First Patient");
        locationDetailsTable.get().tableCell(1, 0).assertContains().text("Practice Location Type");
        locationDetailsTable.get().tableCell(2, 0).assertContains().text("CLIA Number");
        locationDetailsTable.get().tableCell(3, 0).assertContains().text("FDA/Radiology Number");
        locationDetailsTable.get().tableCell(4, 0).assertContains().text("Effective Date");
        locationDetailsTable.get().tableCell(5, 0).assertContains().text("End Date");
    }

    //medical record storage facility address table on enrollment details page
    public void orgMedicalRecordStorageAndAssert(){
        medicalRecordStorageTable.waitForState().present();
        medicalRecordStorageTable.get().tableCell(0,0).assertContains().text("Does the applicant store medical records at a storage facility?");
        medicalRecordStorageTable.get().tableCell(1,0).assertContains().text("Facility Address");
        medicalRecordStorageTable.get().tableCell(2,0).assertContains().text("Effective Date");
        medicalRecordStorageTable.get().tableCell(3,0).assertContains().text("End Date");
    }

    //PTAN and NPI table on enrollment details page
    public void orgPtanAndNpiTableAndAssert(){
        ptanAndNpiTable.waitForState().present();
        ptanAndNpiTable.get().tableCell(0,0).assertContains().text("PTAN");
        ptanAndNpiTable.get().tableCell(0, 1).assertContains().text("NPI");
        ptanAndNpiTable.get().tableCell(0,2).assertContains().text("Effective Date");
        ptanAndNpiTable.get().tableCell(0,3).assertContains().text("End Date");
    }
}