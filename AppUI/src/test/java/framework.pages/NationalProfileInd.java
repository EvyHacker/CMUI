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
    private final Element identifyingInfoTable2;
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
        activeApplicationsTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[2]");
        identificationTable = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[1]");

        //identification tab
        identifyingInfoTable1 = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[1]");
        identifyingInfoTable2 = app.newElement(Locator.XPATH, "(//table[@class='nrpm--bare-table'])[2]");
        licenseAndCertTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable ds-c-datatable--paging']");
        alaTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable']");
        filterBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Filter')]");

        // relationships tab
        reassignmentsTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable nrpm-relationships table'])[1]");
        associationsTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable ds-c-datatable--paging']");

        //breadcrumbs
        entityProfileBreadCrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[1]");
        medicareBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[2]");
        enrollmentOverviewBreadcrumb = app.newElement(Locator.XPATH, "//div[@class='breadcrumb-container']//div[3]//div[1]");

        //enrollments Table
        enrollmentLink = app.newElement(Locator.XPATH, "//div[@class='nrpm-card__body']//div//tr[1]//td[1]//a[1]");
        enrollmentTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
        applicationsEnrollTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[2]");

        //enrollment Overview table
        enrollmentInfoTable = app.newElement(Locator.XPATH, "//div[@class='enrollmentInfo']//table[@class='ds-c-table']");
        entityInfoTable = app.newElement(Locator.XPATH, "//div[@class='entityInfo']//table[@class='ds-c-table']");
        enrollmentHistoryTable = app.newElement(Locator.XPATH, "//table[@class='ds-c-datatable']");

        enrollmentNumber = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]//tbody//td[3]");
        createAppBtn = app.newElement(Locator.XPATH, "//button[@name='createApplicationButton']");
        revalidateBtn = app.newElement(Locator.XPATH, "//button[@name='revalidationButton']");

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

    public void individualVerifyBreadcrumbContentAndAssert() {
        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTable.waitForState().displayed(5d);
        enrollmentLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();
        //breadcrumb content
        enrollmentOverviewBreadcrumb.assertContains().text("Enrollment Overview");
        enrollmentOverviewBreadcrumb.assertContains().text("Enrollment Number");
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
        activeApplicationsTable.get().tableCell(0, 0).assertContains().text("Case ID");
        activeApplicationsTable.assertEquals().text(0, 1, "Application ID");
        activeApplicationsTable.assertEquals().text(0, 2, "Submission Date");
        activeApplicationsTable.assertEquals().text(0, 3, "Application Submittal Reason");
        activeApplicationsTable.assertEquals().text(0, 4, "Status");

        // Verify Identification table
        identificationTable.waitForState().displayed();
    }

    public void individualEnrollmentTableAndAssert() {

        app.refresh();
        app.wait(30d);
        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTable.waitForState().displayed(5d);
        createAppBtn.is().present();

        //verify breadcrumbs
        entityProfileBreadCrumb.assertContains().text("Entity Profile");
        medicareBreadcrumb.assertContains().text("Medicare Record");

        //verify enrollments
        enrollmentTable.assertEquals().text(0, 0, "Enrollment Number");
        enrollmentTable.assertEquals().text(0, 1, "State");
        enrollmentTable.assertEquals().text(0, 2, "Status");
        enrollmentTable.assertEquals().text(0, 3, "Effective Date");
        enrollmentTable.assertEquals().text(0, 4, "MAC / Jurisdiction");
        // Verify active apps
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

    public void individualEnrollmentOverviewAndAssert() {

        medicareTable.waitForState().displayed(20);
        enrollmentLink.click();
        enrollmentTable.waitForState().displayed(5d);
        enrollmentLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();

        //enrollment info table
        enrollmentInfoTable.waitForState().displayed();
        app.waitFor().textPresent("<Enrollment Information>");
        enrollmentInfoTable.assertEquals().text(0, 0, "Enrollment Number:");
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
        enrollmentTable.waitForState().displayed(5d);
        enrollmentLink.click();
        createAppBtn.waitForState().enabled();
        revalidateBtn.waitForState().enabled();
        createAppBtn.click();
    }
}