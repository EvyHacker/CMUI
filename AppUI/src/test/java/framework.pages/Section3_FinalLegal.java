package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section3_FinalLegal {
    //**Specialities
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
    private final Element saveAndContinueBtn;


    public Section3_FinalLegal(App app) {

        yesRadio = app.newElement(Locator.XPATH, "//span[contains(text(),'Yes')]");
        addFinalALABtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Final ALA')]");
        saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");
        alaCategory = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.category");
        alaOption = app.newElement(Locator.XPATH, "//option[contains(text(),'FELONY CONVICTION WITHIN 10 YEARS')]");
        alaDate = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.actionDate");
        alaActionBy = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.actionBy");
        alaDescription = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.description");
        alaResolution = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.resolution");
        effectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.effectiveDate");
        endDate = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.expirationDate");
        reportedDate = app.newElement(Locator.NAME, "sections.forms.855I.FINAL_ADVERSE_LEGAL_ACTIONS.legal.legalActions.0.reportedDate");
        this.app = app;
    }
    private final App app;

    public void addALAAndAssert (){
        app.wait(1d);
        yesRadio.waitForState().displayed(5);
        yesRadio.click();
        addFinalALABtn.waitForState().enabled(5);
        addFinalALABtn.click();
        app.azzert().textPresent("Final Adverse Legal Actions");
    }

    public void addALAInfo () {
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

    public void alaSaveAndContinue(){
        app.wait(2d);
        saveAndContinueBtn.click();
        app.azzert().textPresent("Application Summary");
    }
}