package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section4_BusinessInfo {
    private final Element businessName;
    private final Element businessTaxId;
    private final Element ptanId;
    private final Element npiId;
    private final Element incorpDate;
    private final Element incorpState;
    private final Element practiceType;
    private final Element specifyOtherText;
    private final Element inhsYes;
    private final Element inhsNo;
    private final Element proprietaryRadioBtn;
    private final Element nonprofitRadioBtn;
    private final Element disregardEntityRadioBtn;
    private final Element otherRadioBtn;
    private final Element saveAndContinueBtn;

    private final App app;

    public Section4_BusinessInfo(App app) {

        businessName = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.businessName");
        businessTaxId = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.taxID");
        ptanId = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.medicareID");
        npiId = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.providerID");
        incorpDate = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.incorporationDate");
        incorpState = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.incorporatedState");
        practiceType = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.practiceType");
        specifyOtherText = app.newElement(Locator.NAME, "sections.forms.855I.BUSINESS_INFORMATION.practiceTypeDesc");

        /**InHS**/
        inhsYes = app.newElement(Locator.XPATH, "(//span[contains(text(),'Yes')])[1]");
        inhsNo = app.newElement(Locator.XPATH, "(//span[contains(text(),'No')])[1]");

        /**Business type**/
        proprietaryRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Proprietary')]");
        nonprofitRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Non-Profit (IRS Form 501(c)(3) was submitted)')]");
        disregardEntityRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Disregarded Entity (IRS Form 8832 was submitted)')]");
        otherRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Other')]");

        saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");
        this.app = app;

    }

    public void enterBusinessInfo() {
        businessName.type("LegalOne Business");
        businessTaxId.type("123456789");
        ptanId.type("12345");
        npiId.type("1234567890");
        incorpDate.type("12/12/2017");
        incorpState.selectOption("Hawaii");
        practiceType.selectOption("Corporation");
    }

    public void clickINHSYes() {
        inhsYes.waitForState().enabled();
        inhsYes.click();
        app.wait(1d);
        saveAndContinueBtn.click();
    }

    public void clickINHSNo() {
        inhsNo.waitForState().enabled();
        inhsNo.click();
        app.wait(1d);
        saveAndContinueBtn.click();
    }
}

