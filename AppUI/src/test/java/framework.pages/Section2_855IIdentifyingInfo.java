package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Section2_855IIdentifyingInfo {

  //personal info
  private final Element firstName;
  private final Element lastName;
  private final Element otherNamesYes;
  private final Element otherNameType;
  private final Element OtherFirstName;
  private final Element OtherLastName;
  private final Element dob;
  private final Element state;
  private final Element country;
  private final Element genderRadioBtn;
  private final Element ssnInput;
  private final Element ptanInput;
  private final Element npiInput;
  private final Element schoolSelection;
  private final Element graduationYear;

  //Drug Enforcement Agency (DEA) Information
  private final Element deaNumber;
  private final Element deaState;
  private final Element deaEffectiveDate;
  private final Element deaExpirationDate;

  //License Information
  private final Element licenseNumber;
  private final Element licenseState;
  private final Element licenseEffectiveDate;
  private final Element licenseExpirationDate;

  //Cert Information
  private final Element certAddBtn;
  private final Element certNumber;
  private final Element certState;
  private final Element certEffectiveDate;
  private final Element certExpirationDate;
  private final Element certAddNumber;
  private final Element certAddState;
  private final Element certAddEffectiveDate;
  private final Element certAddExpirationDate;

  //Correspondence info
  private final Element addressLine1;
  private final Element addressLine2;
  private final Element addressCity;
  private final Element addressState;
  private final Element addressZip;
  private final Element addressCountry;
  private final Element addressPhone;
  private final Element addressPhoneExt;
  private final Element addressFax;
  private final Element addressEmail;

  //**Physician
  private final Element physicianRadioBtn;
  private final Element nonPhysicianRadioBtn;

  //**Specialities
  private final Element primarySpeciality;
  private final Element secondarySpeciality;
  private final Element addSpeciality;
  private final Element saveAndContinueBtn;

  //**Specialities
  private final Element accreditingOrgYes;
  private final Element accreditingOrgNo;
  private final Element addAccreditationBtn;
  private final Element addMRIRadio;
  private final Element addCTRadio;
  private final Element addNuclearMedRadio;
  private final Element addPETRadio;
  private final Element addAccreditingName;
  private final Element addAccreditingEffectiveDate;
  private final Element addAccreditingEndDate;


  public Section2_855IIdentifyingInfo(App app) {

    /**Personal Information**/
    firstName = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.name.first");
    lastName = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.name.last");
    otherNamesYes = app.newElement(Locator.XPATH, "//span[contains(text(),'Yes')]");
    otherNameType = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.otherNames.0.type");
    OtherFirstName = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.otherNames.0.name.first");
    OtherLastName = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.otherNames.0.name.last");
    dob = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.birthDate");
    state = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.birthState");
    country = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.birthCountry");
    genderRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Male')]");
    ssnInput = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.ssn");
    ptanInput = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.ptanNumber");
    npiInput = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.npiNumber");
    schoolSelection = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.medicalProfessionalSchool");
    graduationYear = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.personal.graduationYear");


/**Drug Enforcement Agency (DEA) Information**/
    deaNumber = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.dea.deaNumbers.0.number");
    deaState = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.dea.deaNumbers.0.stateIssued");
    deaEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.dea.deaNumbers.0.effectiveDate");
    deaExpirationDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.dea.deaNumbers.0.expirationDate");

/**License Information**/
    licenseNumber = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.license.licenseNumbers.0.number");
    licenseState = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.license.licenseNumbers.0.stateIssued");
    licenseEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.license.licenseNumbers.0.effectiveDate");
    licenseExpirationDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.license.licenseNumbers.0.expirationDate");

/**Certification Information**/
    certAddBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Another Certification')]");
    certNumber = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.0.number");
    certState = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.0.stateIssued");
    certEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.0.effectiveDate");
    certExpirationDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.0.expirationDate");
    certAddNumber = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.1.number");
    certAddState = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.1.stateIssued");
    certAddEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.1.effectiveDate");
    certAddExpirationDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.licenseAndCertification.certification.certificationNumbers.1.expirationDate");


/**Correspondence Info**/
    addressLine1 = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.mailingAddress.address1");
    addressLine2 = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.mailingAddress.address2");
    addressCity = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.mailingAddress.city");
    addressState = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.mailingAddress.state");
    addressZip = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.mailingAddress.zipCode");
    addressCountry = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.mailingAddress.country");
    addressPhone = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.phoneNumber");
    addressPhoneExt = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.phoneExt");
    addressFax = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.faxNumber");
    addressEmail = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.correspondence.email");

/**Physician/Non-Physician Specialties info**/
    physicianRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Physician')]");
    nonPhysicianRadioBtn = app.newElement(Locator.XPATH, "//span[contains(text(),'Non-Physician Practitioner')]");

/**Specialities**/
    primarySpeciality = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.specialty.physician.primarySpecialty");
    secondarySpeciality = app.newElement(Locator.XPATH,"//div[@class='ds-l-md-col--4']//option[contains(text(),'CARDIAC SURGERY')]");
    addSpeciality = app.newElement(Locator.XPATH, "//button[contains(text(),'Add »')]");
    saveAndContinueBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Save and Continue')]");

    /**Accrediting Org**/
    accreditingOrgYes = app.newElement(Locator.XPATH, "//fieldset[5]/section[1]//span[contains(text(),'Yes')]");
    accreditingOrgNo = app.newElement(Locator.XPATH, "(//fieldset[5]/section[1]//span[contains(text(),'No')])[1]");
    addAccreditationBtn = app.newElement(Locator.XPATH, "//button[contains(text(),'Add Accreditation')]");
    addMRIRadio = app.newElement(Locator.XPATH, "//span[contains(text(),'MAGNETIC RESONANCE IMAGING (MRI)')]");
    addCTRadio = app.newElement(Locator.XPATH, "//span[contains(text(),'COMPUTED TOMOGRAPHY (CT)')]");
    addNuclearMedRadio = app.newElement(Locator.XPATH, "//span[contains(text(),'NUCLEAR MEDICINE')]");
    addPETRadio = app.newElement(Locator.XPATH, "//span[contains(text(),'POSITRON EMISSION TOMOGRAPHY (PET)')]");
    addAccreditingName = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.accrediting.items.0.name");
    addAccreditingEffectiveDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.accrediting.items.0.effectiveDate");
    addAccreditingEndDate = app.newElement(Locator.NAME, "sections.forms.855I.IDENTIFYING_INFORMATION.accrediting.items.0.expirationDate");

    this.app = app;
  }

  private final App app;

  public void addAccreditingOrg () {
    accreditingOrgYes.click();
    addAccreditationBtn.waitForState().enabled();
    addAccreditationBtn.click();
    app.waitFor().textPresent("Identifying Information");
    addMRIRadio.click();
    addAccreditingName.type("AMERICAN COLLEGE OF RADIOLOGY (ACR)");
    addAccreditingEffectiveDate.type("09/09/2015");
    addAccreditingEndDate.type("09/09/2030");
    saveAndContinueBtn.click();
  }
  public void enterPersonalInfo(){
   /* firstName.clear();
    firstName.type("King");
    lastName.clear();
    lastName.type("Jones");*/
    otherNamesYes.click();

    OtherFirstName.type("King");
    OtherLastName.type("Jonez");
    otherNameType.selectOption("Professional Name");
   /* dob.clear();
    dob.type("09/09/1990");*/
    state.selectOption("Hawaii");
    country.selectOption("United States");
    genderRadioBtn.click();
   /* ssnInput.clear();
    ssnInput.type("123456789");*/
    schoolSelection.selectOption("BALTIMORE MEDICAL COLLEGE");
    graduationYear.type("2004");
  }

  public void enterDEAInfo(){
    deaNumber.type("HA1234567");
    deaState.selectOption("Hawaii");
    deaEffectiveDate.type("01/02/2004");
    deaExpirationDate.type("01/02/2024");
  }
  public void enterLicenseInfo(){
    licenseNumber.type("123456789");
    licenseState.selectOption("Hawaii");
    licenseEffectiveDate.type("01/02/2004");
    licenseExpirationDate.type("01/02/2024");
  }

  public void certAddition(){
    certAddBtn.click();
    certAddNumber.type("C444444");
    certAddState.selectOption("Maryland");
    certAddEffectiveDate.type("09/09/2000");
    certAddExpirationDate.type("09/09/2030");
  }
  public void enterCertInfo(){
    certNumber.type("123456");
    certState.selectOption("Hawaii");
    certEffectiveDate.type("01/02/2004");
    certExpirationDate.type("01/02/2024");
  }
  public void enterAddressInfo(){
    addressLine1.type("123 Lauiki Street");
    addressLine2.type("Suite 100");
    addressCity.type("Baltimore");
    addressState.selectOption("Maryland");
    addressZip.type("22034");
    addressCountry.selectOption("United States");
    addressPhone.type("202-232-2323");
    addressPhoneExt.type("1000");
    addressFax.type("202-232-2322");
    addressEmail.type("Greys@doctor.com");
  }

  public void selectPhysician() {
    physicianRadioBtn.click();
    primarySpeciality.waitForState().enabled(30);
    primarySpeciality.selectOption("FAMILY PRACTICE");
    secondarySpeciality.waitForState().enabled(30);
    secondarySpeciality.click();
    addSpeciality.click();
  }

  public void saveAndContinue(){
    app.wait(2d);
    saveAndContinueBtn.click();
    app.azzert().textPresent("Application Summary");
  }
}
