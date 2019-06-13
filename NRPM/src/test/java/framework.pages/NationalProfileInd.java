package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;
import org.testng.Assert;

public class NationalProfileInd {

    private final Element providerlist;
    private final Element recentProvider;
    private final Element sideNav;
    private final Element medicareTable;
    private final Element enrollmentNumber;
    private final Element enrollmentLink;
    private final Element enrollmentTableMRPage;
    private final Element overviewTab;
    private final Element identificationTab;
    private final Element billingTab;
    private final Element relationshipsTab;
    private final Element locationsTab;
    private final Element createAppBtn;
    private final Element revalidateBtn;
    private final Element activeApplicationsTable;
    private final Element caseIdLink;
    private final Element identificationTable;

    private final Element identifyingInfoTable1;
    private final Element identifyingInfoTable2;
    private final Element licenseAndCertTable;
    private final Element alaTable;
    private final Element filterBtn;

    private final Element reassignmentsTable;
    private final Element associationsTable;
    private final Element entityProfileBreadCrumb;
    private final Element medicareBreadcrumb;
    private final Element enrollmentOverviewBreadcrumb;
    private final Element activeApplicationsTableMRpage;

    private final Element enrollmentInfoTable;
    private final Element entityInfoTable;
    private final Element enrollmentHistoryTable;

    private final Element currentEnrollmentDetailsButton;
    private final Element practiceLocationInformation;
    private final Element enrollmentDetailsBreadcrumb;
    private final Element addressLocation1;
    private final Element addressLocationTable1;
    private final Element locationDetails1;
    private final Element locationDetailsTable1;
    private final Element medicalRecordStorageFacility1;
    private final Element medicalRecordStorageTable1;
    private final Element ptanAndNpi1;
    private final Element ptanAndNpiTable1;

    private final App app;

    public NationalProfileInd(App app) {

        providerlist = app.newElement(Locator.XPATH, "//ul[@class='nrpm-provider-list']");
        recentProvider = app.newElement(Locator.XPATH, "//ul[@class='nrpm-provider-list']//following::li[last()]");

        sideNav = app.newElement(Locator.XPATH, "//ul[@class='nrpm--sidebar-outline']");

        overviewTab = app.newElement(Locator.XPATH, "//li[contains(text(),'overview')]");
        identificationTab = app.newElement(Locator.XPATH, "//li[contains(text(),'identification')]");
        billingTab = app.newElement(Locator.XPATH, "//li[contains(text(),'billing')]");
        relationshipsTab = app.newElement(Locator.XPATH, "//li[contains(text(),'relationships')]");
        locationsTab = app.newElement(Locator.XPATH, "//li[contains(text(),'locations')]");

        //overview Tab
        medicareTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
        activeApplicationsTable = app.newElement(Locator.XPATH, "(//table)[2]");
        caseIdLink = app.newElement(Locator.XPATH, "((//table)[2]/tbody/tr/td[1]/button)[1]");
        identificationTable = app.newElement(Locator.XPATH, "(//table)[3]");

        //identification tab
        identifyingInfoTable1 = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[1]");
        identifyingInfoTable2 = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[2]");
        licenseAndCertTable = app.newElement(Locator.XPATH, "(//table[1])[3]");
        alaTable = app.newElement(Locator.XPATH, "(//table[1])[4]");
        filterBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Filter')]");

        // relationships tab
        reassignmentsTable = app.newElement(Locator.XPATH, "(//table)[1]");
        associationsTable = app.newElement(Locator.XPATH, "(//table)[2]");

        //breadcrumbs
        entityProfileBreadCrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[1]");
        medicareBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[2]");
        enrollmentOverviewBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[3]//div[1]");
        enrollmentDetailsBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[4]//div[1]");

        //enrollments Table
        enrollmentLink = app.newElement(Locator.XPATH, "//div[@class='nrpm-card__body']//div//tr[1]//td[1]//a[1]");
        enrollmentTableMRPage = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
        activeApplicationsTableMRpage = app.newElement(Locator.XPATH, "(//table)[2]");


        //enrollment Overview table
        enrollmentInfoTable = app.newElement(Locator.XPATH, "(//div[@class='nrpm--enrollment-info']//table[@class='ds-c-table'])[1]");
        entityInfoTable = app.newElement(Locator.XPATH, "(//div[@class='nrpm--enrollment-info']//table[@class='ds-c-table'])[2]");
        enrollmentHistoryTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable']");

        enrollmentNumber = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]//tbody//td[3]");
        createAppBtn = app.newElement(Locator.NAME, "createApplicationButton");
        revalidateBtn = app.newElement(Locator.NAME, "revalidationButton");

        //enrollment details
        currentEnrollmentDetailsButton = app.newElement(Locator.XPATH, "(//a//button)[2]");
        practiceLocationInformation = app.newElement(Locator.CLASSNAME, "nrpm--enrollment-practice_location");
        addressLocation1 = app.newElement(Locator.XPATH, "//div[contains(text(),'Address Location')][1]");
        locationDetails1 = app.newElement(Locator.XPATH, "//div[contains(text(),'Location Details')][1]");
        medicalRecordStorageFacility1 = app.newElement(Locator.XPATH, "//div[contains(text(),'Medical Record Storage Facility Address')][1]");
        ptanAndNpi1 = app.newElement(Locator.XPATH, "//div[contains(text(),'PTAN & NPI Associations')][1]");
        addressLocationTable1 = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[1]");
        locationDetailsTable1 = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[2]");
        medicalRecordStorageTable1 = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[3]");
        ptanAndNpiTable1 = app.newElement(Locator.XPATH, "(//table[@class='ds-c-table'])[4]");



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
        enrollmentTableMRPage.waitForState().displayed(15);
        int rowsCount = enrollmentTableMRPage.get().numOfTableRows();
        Assert.assertEquals(rowsCount, 3);
    }

    public void individualVerifyBreadcrumbContentAndAssert() {
        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTableMRPage.waitForState().displayed(5d);
        enrollmentLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();
        //breadcrumb content
        enrollmentOverviewBreadcrumb.assertContains().text("Enrollment Overview");
        enrollmentOverviewBreadcrumb.assertContains().text("Enrollment ID");
        enrollmentOverviewBreadcrumb.assertContains().text("Revalidation");
        enrollmentOverviewBreadcrumb.assertContains().text("Status");

        medicareBreadcrumb.assertContains().text("Physician");
        medicareBreadcrumb.assertContains().text("Status");

        entityProfileBreadCrumb.assertContains().text("NPI");
        entityProfileBreadCrumb.assertContains().text("SSN");
        entityProfileBreadCrumb.assertContains().text("Date of Birth");
        entityProfileBreadCrumb.assertContains().text("Status");
    }

    public void individualOverviewTabAndAssert() {

        app.wait(30d);
        overviewTab.click();
        createAppBtn.waitForState().enabled(10d);
        app.azzert().textPresent("Medicare Records");

        entityProfileBreadCrumb.assertContains().text("Entity Profile");

        //verify mr table
        medicareTable.waitForState().displayed();
        medicareTable.assertEquals().text(0, 0, "Entity Type");
        medicareTable.assertEquals().text(0, 1, "Status");
        medicareTable.assertEquals().text(0, 2, "Enrollments");
        medicareTable.assertEquals().text(0, 3, "Effective Date");
        medicareTable.assertEquals().text(0, 4, "Revalidation Status");
        medicareTable.assertEquals().text(0, 5, "Revalidation Due Date");
        medicareTable.assertEquals().text(0, 6, "Revalidation Date");
        medicareTable.assertEquals().text(0, 7, "Actions");

        // verify active apps table
        activeApplicationsTable.waitForState().displayed();
        activeApplicationsTable.get().tableCell(0, 0).assertContains().text("Case ID ");
        activeApplicationsTable.assertEquals().text(0, 1, "Application ID");
        activeApplicationsTable.assertEquals().text(0, 2, "Submission Date");
        activeApplicationsTable.assertEquals().text(0, 3, "Application Submittal Reason");
        activeApplicationsTable.assertEquals().text(0, 4, "Status");
        if (caseIdLink.is().present()){
            caseIdLink.click();
            app.waitFor().textPresent("Application Overview");
            app.goBack();
        }

        // Verify Identification table
        identificationTable.waitForState().displayed();
    }

    public void individualMedicareRecordPageAndAssert() {

        app.refresh();
        app.wait(30d);
        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTableMRPage.waitForState().displayed(5d);
        createAppBtn.is().present();

        //verify breadcrumbs
        entityProfileBreadCrumb.assertContains().text("Entity Profile");
        medicareBreadcrumb.assertContains().text("Medicare Record");

        //verify enrollments
        enrollmentTableMRPage.assertEquals().text(0, 0, "Enrollment Number");
        enrollmentTableMRPage.assertEquals().text(0, 1, "State");
        enrollmentTableMRPage.assertEquals().text(0, 2, "Status");
        enrollmentTableMRPage.assertEquals().text(0, 3, "Effective Date");
        enrollmentTableMRPage.assertEquals().text(0, 4, "MAC / Jurisdiction");
        // Verify active apps
        activeApplicationsTableMRpage.get().tableCell(0, 0).assertContains().text("Case ID");
        activeApplicationsTableMRpage.assertEquals().text(0, 1, "Application ID");
        activeApplicationsTableMRpage.assertEquals().text(0, 2, "Submission Date");
        activeApplicationsTableMRpage.assertEquals().text(0, 3, "Application Submittal Reason");
        activeApplicationsTableMRpage.assertEquals().text(0, 4, "Status");
        activeApplicationsTableMRpage.assertEquals().text(0, 5, "Submitted By");
        activeApplicationsTableMRpage.assertEquals().text(0, 6, "State");
        activeApplicationsTableMRpage.assertEquals().text(0, 7, "PTAN");
        if (caseIdLink.is().present()){
            caseIdLink.click();
            app.waitFor().textPresent("Application Overview:");
            app.goBack();
        }
    }

    public void individualEnrollmentOverviewAndAssert() {

        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTableMRPage.waitForState().displayed(5d);
        enrollmentLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();

        //enrollment info table
        enrollmentInfoTable.waitForState().displayed();
        app.waitFor().textPresent("<Enrollment Information>");
        enrollmentInfoTable.assertEquals().text(0, 0, "Enrollment ID:");
        enrollmentInfoTable.assertEquals().text(1, 0, "State / Territory:");
        enrollmentInfoTable.assertEquals().text(2, 0, "Effective Date:");
        enrollmentInfoTable.assertEquals().text(3, 0, "MAC / Jurisdiction:");

        //entity info table
        entityInfoTable.waitForState().displayed();
        app.waitFor().textPresent("<Entity Information>");
        entityInfoTable.assertEquals().text(0, 0, "Other Name(s):");
        entityInfoTable.assertEquals().text(1, 0, "SSN:");
        entityInfoTable.assertEquals().text(2, 0, "DOB:");
        entityInfoTable.assertEquals().text(3, 0, "NPI:");
        entityInfoTable.assertEquals().text(4, 0, "Practitioner Type:");
        entityInfoTable.assertEquals().text(5, 0, "Primary Specialty:");

        //
        enrollmentHistoryTable.waitForState().displayed();
        app.waitFor().textPresent("Viewing");
        enrollmentHistoryTable.assertEquals().text(0, 0, "<Version>");
        enrollmentHistoryTable.assertEquals().text(0, 1, "<Time updated>");
        enrollmentHistoryTable.assertEquals().text(0, 2, "<Reason for Change>");
        enrollmentHistoryTable.assertEquals().text(0, 3, "<What changed record>");
        enrollmentHistoryTable.assertEquals().text(0, 4, "Org");
        enrollmentHistoryTable.assertEquals().text(0, 5, "State");
        enrollmentHistoryTable.assertEquals().text(0, 6, "Case ID");
    }

    public void individualIdentificationTabAndAssert() {

        identificationTab.click();
        createAppBtn.assertState().notPresent();
        app.azzert().textPresent("Identifying Information");

        //info table1 assert
        identifyingInfoTable1.assertState().present();
        identifyingInfoTable1.get().tableRow(0).assertContains().text("NPI");
        identifyingInfoTable1.get().tableRow(1).assertContains().text("Date of Birth");
        identifyingInfoTable1.get().tableRow(2).assertContains().text("Country of Birth");
        identifyingInfoTable1.get().tableRow(3).assertContains().text("State of Birth");
        identifyingInfoTable1.get().tableRow(4).assertContains().text("SSN");
        identifyingInfoTable1.get().tableRow(5).assertContains().text("Gender");
        identifyingInfoTable1.get().tableRow(6).assertContains().text("State of Residence");
        identifyingInfoTable1.get().tableRow(7).assertContains().text("Other Names Used");

        //info table2 assert
        identifyingInfoTable2.assertState().present();
        identifyingInfoTable2.get().tableRow(0).assertContains().text("Medical School");
        identifyingInfoTable2.get().tableRow(1).assertContains().text("Year of Graduation");
        identifyingInfoTable2.get().tableRow(2).assertContains().text("Practitioner Type");
        identifyingInfoTable2.get().tableRow(3).assertContains().text("Primary Specialty");
        identifyingInfoTable2.get().tableRow(4).assertContains().text("Secondary Specialties");
        identifyingInfoTable2.get().tableRow(5).assertContains().text("Residency");
        identifyingInfoTable2.get().tableRow(6).assertContains().text("Address");
        identifyingInfoTable2.get().tableRow(7).assertContains().text("Graduation Date");

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

    public void individualRelationshipsTabAndAssert() {

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

    public void individualBillingTabAndASsert() {

        billingTab.click();
        app.azzert().textPresent("No data to display");
    }

    public void individualLocationsTabAndASsert() {

        locationsTab.click();
        app.azzert().textPresent("No data to display");
    }

    public void validateSideNavAndAssert() {
        sideNav.waitForState().present();
        sideNav.assertContains().text("Overview");
        sideNav.assertContains().text("Identification");
        sideNav.assertContains().text("Billing");
        sideNav.assertContains().text("Relationships");
        sideNav.assertContains().text("Locations");
    }

    public void createApplicationFromEnrollment() {
        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTableMRPage.waitForState().displayed(5d);
        enrollmentLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();
        createAppBtn.click();
    }

    public void createApplicationForNewProfile() {

        createAppBtn.waitForState().enabled();
        createAppBtn.click();
    }

    //enrollment details page
    public void enrollmentDetailsPageAndAssert(){
        currentEnrollmentDetailsButton.waitForState().enabled(20);
        currentEnrollmentDetailsButton.click();
        enrollmentDetailsBreadcrumb.assertContains().text("Enrollment Details");
        app.azzert().textPresent("Address Location");
        practiceLocationInformation.waitForState().displayed(20);
        addressLocation1.waitForState().displayed();
        locationDetails1.waitForState().displayed();
        medicalRecordStorageFacility1.waitForState().displayed();
        ptanAndNpi1.waitForState().displayed();
    }

    //address location table on enrollment details page
    public void enrollmentDetailsAddressTableAssert() {
        addressLocationTable1.waitForState().present();
        addressLocationTable1.get().tableCell(0, 0).assertContains().text("Practice Location Name");
        addressLocationTable1.get().tableCell(1, 0).assertContains().text("Practice Location Address");
        addressLocationTable1.get().tableCell(2, 0).assertContains().text("Telephone Number");
        addressLocationTable1.get().tableCell(3, 0).assertContains().text("Extension");
        addressLocationTable1.get().tableCell(4, 0).assertContains().text("Email Address");
        addressLocationTable1.get().tableCell(5, 0).assertContains().text("Special Payment Address");
        addressLocationTable1.get().tableCell(6, 0).assertContains().text("Effective Date");
        addressLocationTable1.get().tableCell(7, 0).assertContains().text("End Date");
    }

    //location details table on enrollment details page
    public void enrollmentDetailsLocationTableAssert() {
        locationDetailsTable1.waitForState().present();
        locationDetailsTable1.get().tableCell(0, 0).assertContains().text("Date of First Patient");
        locationDetailsTable1.get().tableCell(1, 0).assertContains().text("Practice Location Type");
        locationDetailsTable1.get().tableCell(2, 0).assertContains().text("CLIA Number");
        locationDetailsTable1.get().tableCell(3, 0).assertContains().text("FDA/Radiology Number");
        locationDetailsTable1.get().tableCell(4, 0).assertContains().text("Effective Date");
        locationDetailsTable1.get().tableCell(5, 0).assertContains().text("End Date");
    }

    //medical record storage address table on enrollment details page
    public void medicalRecordStorageTableAssert() {
        medicalRecordStorageTable1.waitForState().present();
        medicalRecordStorageTable1.get().tableCell(0,0).assertContains().text("Does the applicant store medical records at a storage facility?");
        medicalRecordStorageTable1.get().tableCell(1,0).assertContains().text("Facility Address");
        medicalRecordStorageTable1.get().tableCell(2,0).assertContains().text("Effective Date");
        medicalRecordStorageTable1.get().tableCell(3,0).assertContains().text("End Date");
    }

    //PTAN and NPI table on enrollment details page
    public void ptanAndNpiTableAssert(){
        ptanAndNpiTable1.waitForState().present();
        ptanAndNpiTable1.get().tableCell(0, 0).assertContains().text("PTAN");
        ptanAndNpiTable1.get().tableCell(0, 1).assertContains().text("NPI");
        ptanAndNpiTable1.get().tableCell(0, 2).assertContains().text("Effective Date");
        ptanAndNpiTable1.get().tableCell(0, 3).assertContains().text("End Date");
    }
}
