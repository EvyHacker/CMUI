
package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section5_PracticeLocation {

  //links
  private final Element addPracticeLocationBtn;
  private final Element firstLocationName;
  private final Element firstLocationLine1;
  private final Element firstLocationLine2;
  private final Element firstLocationCity;
  private final Element firstLocationState;
  private final Element firstLocationZip;
  private final Element firstLocationCountry;
  private final Element firstLocationPhone;
  private final Element firstLocationPhoneExt;
  private final Element firstLocationFax;
  private final Element firstLocationEmail;
  private final Element secondLocationName;
  private final Element secondLocationLine1;
  private final Element secondLocationLine2;
  private final Element secondLocationCity;
  private final Element secondLocationState;
  private final Element secondLocationZip;
  private final Element secondLocationCountry;
  private final Element secondLocationPhone;
  private final Element secondLocationPhoneExt;
  private final Element secondLocationFax;
  private final Element secondLocationEmail;
  private final Element firstLocation855BName;
  private final Element firstLocation855BLine1;
  private final Element firstLocation855BLine2;
  private final Element firstLocation855BCity;
  private final Element firstLocation855BState;
  private final Element firstLocation855BZip;
  private final Element firstLocation855BCountry;
  private final Element firstLocation855BPhone;
  private final Element firstLocation855BPhoneExt;
  private final Element firstLocation855BFax;
  private final Element firstLocation855BEmail;
  private final Element saveAndContinueBtn;
  private final Element locationTable;
  private final Element deleteLocationBtn;
  private final Element editLocationBtn;


  public Section5_PracticeLocation(App app) {

    addPracticeLocationBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Practice Location')]");
    //855I address Info

    firstLocationName = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.locationName");
    firstLocationLine1 = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.address1");
    firstLocationLine2 = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.address2");
    firstLocationCity = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.city");
    firstLocationState = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.state");
    firstLocationZip = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.zipCode");
    firstLocationCountry = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.country");
    firstLocationPhone = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.phoneNumber");
    firstLocationPhoneExt = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.phoneExt");
    firstLocationFax = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.faxNumber");
    firstLocationEmail = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.email");
    //855I second address Info

    secondLocationName = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.locationName");
    secondLocationLine1 = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.mailingAddress.address1");
    secondLocationLine2 = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.mailingAddress.address2");
    secondLocationCity = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.mailingAddress.city");
    secondLocationState = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.mailingAddress.state");
    secondLocationZip = app.newElement(Locator.NAME,"sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.mailingAddress.zipCode");
    secondLocationCountry = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.mailingAddress.country");
    secondLocationPhone = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.contact.phoneNumber");
    secondLocationPhoneExt = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.contact.phoneExt");
    secondLocationFax = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.contact.faxNumber");
    secondLocationEmail = app.newElement(Locator.NAME, "sections.forms.855I.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.1.contact.email");

    //855B address Info
    firstLocation855BName = app.newElement(Locator.NAME,"sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.locationName");
    firstLocation855BLine1 = app.newElement(Locator.NAME, "sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.address1");
    firstLocation855BLine2 = app.newElement(Locator.NAME,"sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.address2");
    firstLocation855BCity = app.newElement(Locator.NAME,"sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.city");
    firstLocation855BState = app.newElement(Locator.NAME,"sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.state");
    firstLocation855BZip = app.newElement(Locator.NAME,"sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.zipCode");
    firstLocation855BCountry = app.newElement(Locator.NAME, "sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.mailingAddress.country");
    firstLocation855BPhone = app.newElement(Locator.NAME, "sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.phoneNumber");
    firstLocation855BPhoneExt = app.newElement(Locator.NAME, "sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.phoneExt");
    firstLocation855BFax = app.newElement(Locator.NAME, "sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.faxNumber");
    firstLocation855BEmail = app.newElement(Locator.NAME, "sections.forms.855B.PRACTICE_LOCATION_INFORMATION.practiceLocation.locations.0.contact.email");

    //location edition
    locationTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
    deleteLocationBtn = app.newElement(Locator.XPATH, "(//button[@class='ds-c-button ds-c-button--text'])[1]");
    editLocationBtn = app.newElement(Locator.XPATH, "//a[contains(text(),'Practice Location Information')]");

    saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");


    this.app = app;
  }

  private final App app;

  public void addLocation(){
    addPracticeLocationBtn.waitForState().displayed(30);
    addPracticeLocationBtn.click();
  }

  public void locationInfoAddition(String locationstate1){
    firstLocationName.type("Doctors");
    firstLocationLine1.type("123 Lauiki Street");
    firstLocationLine2.type("Suite 100");
    firstLocationCity.type("Baltimore");
    firstLocationState.selectOption(locationstate1);
    firstLocationZip.type("22034");
    firstLocationCountry.selectOption("United States");
    firstLocationPhone.type("202-232-2323");
    firstLocationPhoneExt.type("1000");
    firstLocationFax.type("202-232-2322");
    firstLocationEmail.type("greys@doctor.com");
    saveAndContinueBtn.waitForState().present();
    app.wait(2d);
    saveAndContinueBtn.click();
    app.azzert().textPresent("Practice Location Information");
  }

  public void locationInfoAddition2(String locationstate2){
    secondLocationName.type("Doctors");
    secondLocationLine1.type("123 Lauiki Street");
    secondLocationLine2.type("Suite 100");
    secondLocationCity.type("Dover");
    secondLocationState.selectOption(locationstate2);
    secondLocationZip.type("32034");
    secondLocationCountry.selectOption("United States");
    secondLocationPhone.type("602-232-2323");
    secondLocationPhoneExt.type("1000");
    secondLocationFax.type("602-232-2322");
    secondLocationEmail.type("greys@doctor.com");
    saveAndContinueBtn.waitForState().present();
    app.wait(2d);
    saveAndContinueBtn.click();
    app.azzert().textPresent("Practice Location Information");
  }

  public void locationInfoAddition855B(String locationstate3){
    firstLocation855BName.type("Doctors");
    firstLocation855BLine1.type("123 Lauiki Street");
    firstLocation855BLine2.type("Suite 100");
    firstLocation855BCity.type("Baltimore");
    firstLocation855BState.selectOption(locationstate3);
    firstLocation855BZip.type("22034");
    firstLocation855BCountry.selectOption("United States");
    firstLocation855BPhone.type("202-232-2323");
    firstLocation855BPhoneExt.type("1000");
    firstLocation855BFax.type("202-232-2322");
    firstLocation855BEmail.type("greys@doctor.com");
    saveAndContinueBtn.waitForState().present();
    app.wait(2d);
    saveAndContinueBtn.click();
    app.azzert().textPresent("Practice Location Information");
  }


  public void mainSaveAndContinue(){
    app.wait(2d);
    saveAndContinueBtn.waitForState().present();
    saveAndContinueBtn.click();
  }

  public void deleteAllLocations() {
    int locationRowCount = locationTable.get().numOfTableRows();
    if (locationRowCount > 1) {
      for (int currentRow = 0; currentRow < locationRowCount; currentRow++) {
        deleteLocationBtn.click();}
    }
  }

  public int rowCountLocations(){
    int locationRowCount = locationTable.get().numOfTableRows();
    System.out.println(locationRowCount);
    return locationRowCount;
  }

  public void editLocation(String state) {
    int locationRowCount = locationTable.get().numOfTableRows();
    if (locationRowCount > 1) {
      for (int currentRow = 0; currentRow == locationRowCount; currentRow++) {
        deleteLocationBtn.click();
        editLocationBtn.click();
        app.waitFor().textPresent("Practice Location Information");
        firstLocationState.selectOption(state);
      }
    }
  }

  public void addNewLocation(String state) {
    int locationRowCount = locationTable.get().numOfTableRows();
    if (locationRowCount == 1) {
      addLocation();
      locationInfoAddition(state);
    }
  }



}