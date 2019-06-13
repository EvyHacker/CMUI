package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section6_ManagingControl {

    private final Element addAssociationBtn;
    private final Element ssnInput;
    private final Element npiInput;
    private final Element findBtn;
    private final Element saveAndContinueBtn;
    private final Element firstName;
    private final Element lastName;
    private final Element ptanInput;
    private final Element npiData;
    private final Element ssnData;
    private final Element dob;
    private final Element employeeCheckBox;
    private final Element employeeAccordian;
    private final Element employeeEffectiveDate;
    private final Element employeeEndDate;

    //ala
    private final Element yesRadio;
    private final Element addFinalALABtn;
    private final Element alaCategory;
    private final Element alaOption;
    private final Element alaDate;
    private final Element alaActionBy;
    private final Element alaDescription;
    private final Element alaResolution;
    private final Element effectiveDate;
    private final Element endDate;
    private final Element reportedDate;

    private final App app;

    public Section6_ManagingControl(App app) {

        addAssociationBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Association')]");
        ssnInput = app.newElement(Locator.NAME, "ssnSearch");
        npiInput = app.newElement(Locator.NAME, "npiSearch");
        findBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Find')]");
        saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");
        firstName = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.name.first");
        lastName = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.name.last");
        ptanInput = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.ptan");
        npiData = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.npi");
        ssnData = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.ssn");
        dob = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.birthDate");
        employeeCheckBox = app.newElement(Locator.XPATH, "//span[contains(text(),'Managing Employee')]");
        employeeAccordian = app.newElement(Locator.XPATH, "//i[contains(text(),'keyboard_arrow_down')]");
        employeeEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.associationTypes.managingEmployee.effectiveDate");
        employeeEndDate = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.associationTypes.managingEmployee.endDate");

        //ala
        yesRadio = app.newElement(Locator.XPATH, "//span[contains(text(),'Yes')]");
        addFinalALABtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Final ALA')]");
        alaCategory = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.category");
        alaOption = app.newElement(Locator.XPATH, "//option[contains(text(),'FELONY CONVICTION WITHIN 10 YEARS')]");
        alaDate = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.actionDate");
        alaActionBy = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.actionBy");
        alaDescription = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.description");
        alaResolution = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.resolution");
        effectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.effectiveDate");
        endDate = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.expirationDate");
        reportedDate = app.newElement(Locator.NAME, "sections.forms.855I.OWNERSHIP_INTEREST_MANAGING_CONTROL.managers.0.legal.legalActions.0.reportedDate");

        this.app = app;
    }

    public void addAssociation() {
        app.wait(3d);
        app.azzert().textPresent("Individuals with Managing Control");
        addAssociationBtn.click();
        ssnInput.waitForState().enabled(15);
        ssnInput.type("123456789");
        npiInput.type("1234567899");
        findBtn.click();
        app.wait(3d);
        app.azzert().textPresent("0 results found");
        app.azzert().textPresent("No individual was found with this SSN and NPI combination");
        firstName.type("Jack");
        lastName.type("Ryan");
        ptanInput.type("12345");
        npiData.type("1234567899");
        ssnData.type("123456789");
        dob.type("09/09/1990");
        saveAndContinueBtn.click();
        app.wait(3d);
        employeeCheckBox.click();
        employeeAccordian.click();
        employeeEffectiveDate.waitForState().enabled(10);
        employeeEffectiveDate.type("09/09/2003");
        employeeEndDate.type("09/09/2030");
        saveAndContinueBtn.click();
        app.wait(3d);
    }
    public void addOwnershipALA (){
        yesRadio.waitForState().displayed(5);
        yesRadio.click();
        addFinalALABtn.waitForState().enabled(5);
        addFinalALABtn.click();
        alaCategory.waitForState().enabled(10);
        alaOption.click();
        alaDate.type("01/02/2004");
        alaActionBy.type("Anna Marie");
        alaDescription.type("Adding ALA for Closeout");
        alaResolution.type("Resolved");
        effectiveDate.type("01/02/2004");
        endDate.type("01/02/2014");
        reportedDate.type("01/02/2009");
        saveAndContinueBtn.waitForState().enabled(10);
        saveAndContinueBtn.click();
    }

    public void ownershipMainSaveAndContinue(){
        saveAndContinueBtn.waitForState().enabled(10);
        app.wait(2d);
        saveAndContinueBtn.click();
        app.wait(1d);
        saveAndContinueBtn.click();
    }
}