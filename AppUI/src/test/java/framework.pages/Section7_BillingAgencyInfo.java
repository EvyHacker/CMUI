package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section7_BillingAgencyInfo {

    private final Element addbillingAgencybtn;
    private final Element individualRadioBtn;
    private final Element orgRadioBtn;
    private final Element billingAgencyLegalBusinessName;
    private final Element billingAgencyFirstName;
    private final Element billingAgencyMiddleInitial;
    private final Element billingAgencyLastName;
    private final Element billingAgencyDOB;
    private final Element billingAgencyBusinessName;
    private final Element billingAgencySSN;
    private final Element billingAgencyState;
    private final Element billingAgencyAddress1;
    private final Element billingAgencyAddress2;
    private final Element billingAgencyCity;
    private final Element billingAgencyZip;
    private final Element billingAgencyMailState;
    private final Element billingAgencyCountry;
    private final Element billingAgencyPhone;
    private final Element billingAgencyPhoneExt;
    private final Element billingAgencyFax;
    private final Element billingAgencyEmail;
    private final Element billingAgencyEffectiveDate;
    private final Element billingAgencyEndDate;
    private final Element billingAgencyTIN;

    private final Element saveAndContinueBtn;
    private final Element backBtn;
    private final Element filterbtn;


    public Section7_BillingAgencyInfo(App app) {

        filterbtn = app.newElement(Locator.XPATH, "\"//button[contains(text(),'Filter')]");
        addbillingAgencybtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Billing Agency')]");

        /**Agency RadioBtn**/
        individualRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Individual')]");
        orgRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Organization')]");

        billingAgencyLegalBusinessName = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.legalBusinessName");
        billingAgencyFirstName = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.name.first");
        billingAgencyMiddleInitial = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.name.mi");
        billingAgencyLastName = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.name.last");
        billingAgencyDOB = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.birthDate");
        billingAgencyBusinessName = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.businessAs");
        billingAgencySSN = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.ssn");
        billingAgencyState = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.agencyState");
        billingAgencyAddress1 = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.mailingAddress.address1");
        billingAgencyAddress2 = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.mailingAddress.address2");
        billingAgencyCity = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.mailingAddress.city");
        billingAgencyMailState = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.mailingAddress.state");
        billingAgencyZip = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.mailingAddress.zipCode");
        billingAgencyCountry = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.mailingAddress.country");
        billingAgencyPhone = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.phoneNumber");
        billingAgencyPhoneExt = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.phoneExt");
        billingAgencyFax = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.phoneExt");
        billingAgencyEmail = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.email");
        billingAgencyEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.effectiveDate");
        billingAgencyEndDate = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.endDate");
        billingAgencyTIN = app.newElement(Locator.NAME, "sections.forms.855I.BILLING_AGENCY.billingAgencies.0.tin");

        saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");
        backBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Back')]");


        this.app = app;
    }

    private final App app;

    public void addbillingAgencybtn() {
        app.waitFor().textPresent("Billing Agency");
        addbillingAgencybtn.click();
    }

    public void setIndividualbillingAgency() {

        app.waitFor().textPresent("Billing Agency Information");
        billingAgencyFirstName.type("Jack");
        billingAgencyMiddleInitial.type("M");
        billingAgencyLastName.type("Ryan");
        billingAgencyDOB.type("12/12/1978");
        billingAgencyBusinessName.type("Legal Business");
        billingAgencySSN.type("123456789");
        billingAgencyState.selectOption("Alaska");
        billingAgencyAddress1.type("123, Washington street");
        billingAgencyAddress2.type("16th cross");
        billingAgencyCity.type("Fairfield");
        billingAgencyMailState.selectOption("Alaska");
        billingAgencyZip.type("90890");
        billingAgencyCountry.selectOption("United States");
        billingAgencyPhone.type("800-907-9090");
        billingAgencyPhoneExt.type("1234");
        billingAgencyFax.type("800-907-9010");
        billingAgencyEmail.type("jackryan@legalbusiness.com");
        billingAgencyEffectiveDate.type("12/12/2003");
        billingAgencyEndDate.type("12/12/2025");
    }

    public void setOrgbillingAgency() {

        app.waitFor().textPresent("Billing Agency Information");
        orgRadioBtn.click();

        billingAgencyLegalBusinessName.type("HealthCare Options");
        billingAgencyBusinessName.type("Legal Business");
        billingAgencyTIN.type("123456789");
        billingAgencyState.selectOption("Alaska");
        billingAgencyAddress1.type("123, Washington street");
        billingAgencyAddress2.type("16th cross");
        billingAgencyCity.type("Fairfield");
        billingAgencyMailState.selectOption("Alaska");
        billingAgencyZip.type("90890");
        billingAgencyCountry.selectOption("United States");
        billingAgencyPhone.type("800-907-9090");
        billingAgencyPhoneExt.type("1234");
        billingAgencyFax.type("800-907-9010");
        billingAgencyEmail.type("jackryan@legalbusiness.com");
        billingAgencyEffectiveDate.type("12/12/2003");
        billingAgencyEndDate.type("12/12/2025");
    }
    public boolean billingAgencyAdded() {
        app.wait(2d);
        app.azzert().textPresent("There are no Billing Agency(s) currently saved for this applicant. To add a Billing Agency, select the Add Billing Agency button.");
        return false;
    }
}