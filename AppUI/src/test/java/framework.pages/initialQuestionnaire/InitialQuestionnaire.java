package framework.pages.initialQuestionnaire;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;


public class InitialQuestionnaire {

    private final Element visitSectionBtn;
    private final Element createAppBtn;
    private final Element reviewAppBtn;
    private final Element formTypeSelect;
    private final Element submissionReason;
    private final Element reassignmentSelectYes;
    private final Element reassignmentSelectNo;
    private final Element eftCheckbox;
    private final Element section;
    private final Element saveBtn;
    private final Element backBtn;


    public InitialQuestionnaire(App app) {
        visitSectionBtn = app.newElement(Locator.XPATH, "//a[contains(text(),'Visit Section')]");
        createAppBtn = app.newElement(Locator.XPATH, "/html/body/div/main/div/div/div/ul[2]/li[1]/button");
        formTypeSelect = app.newElement(Locator.NAME, "formType");
        submissionReason = app.newElement(Locator.NAME, "submissionReason");
        section = app.newElement(Locator.CLASSNAME, "section-container");
        reassignmentSelectYes = app.newElement(Locator.XPATH, "//span[contains(text(),'Yes')]");
        reassignmentSelectNo = app.newElement(Locator.XPATH, "//span[contains(text(),'No')]");
        eftCheckbox = app.newElement(Locator.XPATH, "//span[contains(text(),'Electronic Funds Transfer (EFT) Authorization Agr')]");
        Element appFormBtns = app.newElement(Locator.CLASSNAME, "app-form-buttons");
        saveBtn = appFormBtns.findChild(app.newElement(Locator.TAGNAME, "button", 1));
        backBtn = appFormBtns.findChild(app.newElement(Locator.TAGNAME, "button", 0));
        reviewAppBtn = app.newElement(Locator.XPATH,"//a[contains(text(),'Review Application')]");

        this.app = app;
    }

    private final App app;

    //Click the visit section button
    public void clickVisitSection() {
        visitSectionBtn.waitForState().enabled(30);
        visitSectionBtn.click();
    }

    //Click Create app btn
    public void ClickCreateApp() {
        createAppBtn.click();
    }


    public void findSection(int section) {
        this.section.setMatch(section);
    }

    public void goToSection(int section) {
        reviewAppBtn.waitForState().enabled(60);
        Element visitSection = this.section.findChild(app.newElement(Locator.LINKTEXT, "Visit Section"));
        visitSection.waitForState().displayed(60);
        findSection(section);
        visitSection.click();

    }

    public void clickReassignmentYes(){
        reassignmentSelectYes.click();
    }

    public void clickReassignmentNo(){
        reassignmentSelectNo.click();
    }
    public void selectEftCheckBox(){
        eftCheckbox.click();
    }

    public void selectFormType(String s){
        app.waitFor().textPresent("Select an Enrollment Application");
        formTypeSelect.selectValue(s);
    }

    public void saveAndContinue(){
        saveBtn.waitForEquals().changeDefaultWait(60);
        saveBtn.waitForState().enabled(60);
        saveBtn.click();
        app.azzert().titleEquals("PECOS");

    }

    /**** Enrollment Reason *****/

    public void selectSubmissionReason(int submissionReason){
        this.submissionReason.setMatch(submissionReason);
        String submissionReasonId = this.submissionReason.get().attribute("id");
        Element submissionReasonLabel = app.newElement(Locator.CSS, "label[for='"+submissionReasonId+"']");
        submissionReasonLabel.click();
    }


    public void startSubmission(){
        reviewAppBtn.waitForState().enabled(60);
        reviewAppBtn.click();

    }

}