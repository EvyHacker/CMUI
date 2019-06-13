//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section8_ContactInfo {

    private final Element addContactPersonBtn;
    private final Element contactFirstname;
    private final Element contactLastname;
    private final Element contactAddressLine;
    private final Element contactAddressCity;
    private final Element contactAddressState;
    private final Element contactZipCode;
    private final Element contactCountry;
    private final Element contactEmail;
    private final Element saveAndContinueBtn;
    private final Element deleteContactInfo;
    private final Element deleteContactInfo2;
    private final Element editContact;
    private final Element filterBtn;
    private final Element locationTable;
    private final App app;

    public Section8_ContactInfo(App app) {
        this.addContactPersonBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Contact Person')]");
        this.saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");
        this.filterBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Filter')]");
        this.deleteContactInfo = app.newElement(Locator.XPATH, "//tr[1]//td[9]//button[1]");
        this.deleteContactInfo2 = app.newElement(Locator.XPATH, "//tr[2]//td[9]//button[1]");
        this.editContact = app.newElement(Locator.XPATH, " //tr[1]//a");
        this.contactFirstname = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.name.first");
        this.contactLastname = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.name.last");
        this.contactAddressLine = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.mailingAddress.address1");
        this.contactAddressCity = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.mailingAddress.city");
        this.contactAddressState = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.mailingAddress.state");
        this.contactZipCode = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.mailingAddress.zipCode");
        this.contactCountry = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.mailingAddress.country");
        this.contactEmail = app.newElement(Locator.NAME, "sections.forms.855I.CONTACT_PERSON_INFORMATION.contactInformation.0.email");
        this.app = app;
        this.locationTable = app.newElement(Locator.XPATH, "(//table[@class='ds-c-datatable'])[1]");
    }

    public void removeExistingContactInfo() {
        int locationRowCount = locationTable.get().numOfTableRows();
        System.out.println(locationRowCount);
        if (locationRowCount > 1) {
            for (int currentRow = 1; currentRow < locationRowCount; currentRow++) {
                deleteContactInfo.click();}
            //app.wait(2d);
            app.waitFor().textPresent("There are no contacts currently saved for this applicant.");

        }
    }

    public void addContact(){
        addContactPersonBtn.waitForState().displayed(30);
        addContactPersonBtn.click();
    }

    public void addNewContact(String state) {
        int locationRowCount = locationTable.get().numOfTableRows();
        if (locationRowCount == 1) {
            addContact();
            contactInfoAddition(state);
        }
    }

    public void contactInfoAddition(String locationstate1) {
        this.contactFirstname.type("Doctor");
        this.contactLastname.type("Medicine");
        this.contactAddressLine.type("123 Lauiki Street");
        this.contactAddressCity.type("Baltimore");
        this.contactAddressState.selectOption(locationstate1);
        this.contactZipCode.type("22102");
        this.contactCountry.selectOption("United States");
        this.contactEmail.type("greys@doctor.com");
        saveAndContinueBtn.waitForState().present();
        app.wait(2d);
        saveAndContinueBtn.click();
        app.azzert().textPresent("Contact Person Information");
    }


    public void editContactInfo(String contactState) {
        this.contactAddressState.selectOption(contactState);
        this.saveAndContinueBtn.click();
        this.saveAndContinueBtn.click();
    }

    public void changeContactInfo() {
        this.editContact.click();
        this.contactAddressState.click();
    }
}
