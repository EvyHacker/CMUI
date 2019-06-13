package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;
import org.testng.annotations.Test;

public class Section9_reassignmentData {

  private final Element saveAndContinueBtn;
  private final Element addReassignmentDataButton;
  private final Element addNPIButton;
  private final Element searchNPIButton;
  private final Element selectNPIButton;
  private final Element selectNPILocationbutton;

  //private final Element selectNPI;
  private final Element selectNextStepBtn;


  private final App app;
  public Section9_reassignmentData(App app) {

    /**links**/
    saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");
    addReassignmentDataButton = app.newElement(Locator.XPATH, " //button[contains(text(),'Add Reassignment/Employment Relationship')]");
    addNPIButton = app.newElement(Locator.XPATH, "//input[@class='ds-c-field app-employment-relationship-search--query']");
    searchNPIButton = app.newElement(Locator.XPATH, "//button[@class='ds-c-button ds-c-button--flat ds-u-margin-left--2']");
    //selectNPI = app.newElement(Locator.CLASSNAME, "//button[contains(text(),'Search')]");
    selectNPIButton = app.newElement(Locator.XPATH, "//button[contains(text(),'Select')]");
    selectNPILocationbutton = app.newElement(Locator.XPATH, "//span[contains(text(),'MD')]");
    selectNextStepBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Next Step »')]");

    this.app = app;
  }

  @Test
  public void addReassignmentData() {
    addReassignmentDataButton.click();
    addNPIButton.type("1123456789");
    searchNPIButton.click();
    searchNPIButton.waitForState().displayed();
    //selectNPI.click();
    selectNPIButton.click();
    selectNPILocationbutton.click();
    selectNextStepBtn.click();
    app.waitFor().textPresent("Select Appointment Location(s)");
    selectNPILocationbutton.click();
    app.wait(2d);
    saveAndContinueBtn.click();
    app.wait(2d);
    saveAndContinueBtn.click();
  }

}
