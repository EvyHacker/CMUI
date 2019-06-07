package framework.api;

import com.coveros.selenified.services.Call;
import com.coveros.selenified.services.Request;
import com.coveros.selenified.services.Response;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Case {

    private final String BASE_URI = "api/case-management/";
    private final Call call;

    public Case(Call call) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "");
        call.addHeaders(headers);
        this.call = call;
    }

    //TODO - this needs to be moved to NRPM
    public JsonArray getProviders() {
        return call.get("api/national-record-and-profile-management/" + "providers").getArrayData();
    }

    //TODO - this needs to be moved to NRPM
    public String getProviderId(JsonObject provider) {
        return provider.get("providerProfile").getAsJsonObject().get("basicInfo").getAsJsonObject().get("providerId").getAsString();
    }

    //TODO - this needs to be moved to Application
    public void setupForm(String applicationId, String formType, String reasonType) {
        // TODO this needs to be built to be useful
        //    if null values are passed in, use defaults
        JsonArray optionalSections = new JsonArray();
        optionalSections.add(formType + "/ELECTRONICS_FUNDS_TRANSFER");
        optionalSections.add(formType + "/REASSIGNMENT_EMPLOYMENT_RELATIONSHIPS");

        JsonArray optionalSubsections = new JsonArray();
        optionalSubsections.add(formType + "/IDENTIFYING_INFORMATION/CLINICAL_PSYCHOLOGISTS");
        optionalSubsections.add(formType + "/IDENTIFYING_INFORMATION/PSYCHOLOGISTS_BILLING_INDEPENDENTLY");
        optionalSubsections.add(formType + "/IDENTIFYING_INFORMATION/PT_OT_PRIVATE_PRACTICE");
        optionalSubsections.add(formType + "/IDENTIFYING_INFORMATION/NURSE_PRACTITIONERS_CERTIFIED_SPECIALISTS");
        optionalSubsections.add(formType + "/IDENTIFYING_INFORMATION/ACCREDITING_ORGANIZATIONS");
        optionalSubsections.add(formType + "/BUSINESS_INFORMATION/PRIVATE_PRACTICE_BUSINESS_INFORMATION");
        optionalSubsections.add(formType + "/BUSINESS_INFORMATION/SOLE_PROPRIETORSHIP");
        optionalSubsections.add(formType + "/BUSINESS_INFORMATION/UNIQUE_CIRCUMSTANCES");
        optionalSubsections.add(formType + "/PRACTICE_LOCATION_INFORMATION/RENDERING_SERVICES_IN_PATIENTS_HOMES");
        optionalSubsections.add(formType + "/BILLING_AGENCY/BILLING_AGENCY_INFORMATION");

        JsonObject body = new JsonObject();
        body.addProperty("form_type", formType);
        body.addProperty("reason_type", reasonType);
        body.add("optional_sections", optionalSections);
        body.add("optional_subsections", optionalSubsections);

        Response response = call.put("api/application/" + "initialQuestionnaire/" + applicationId, new Request().setJsonPayload(body));
        response.assertEquals(200);
    }

    //TODO - this needs to be moved to Application
    public JsonObject getBusinessInformation() {
        // TODO this needs to be built to be useful
        //    if null values are passed in, use defaults
        JsonObject businessInformation = new JsonObject();
        businessInformation.addProperty("isIHFEnrollingMAC", "N");
        return businessInformation;
    }

    //TODO - this needs to be moved to Application
    public JsonArray getPracticeLocations() {
        // TODO this needs to be built to be useful
        //    if null values are passed in, use defaults
        JsonObject location = new JsonObject();
        location.addProperty("id", "b014d051-8832-4af0-bf82-1f60d7709f40");

        JsonObject ptannpi = new JsonObject();
        ptannpi.addProperty("id", "614cb615-e940-4a8d-a72c-464bf471464b");
        JsonArray ptannpiA = new JsonArray();
        ptannpiA.add(ptannpi);
        location.add("ptannpi", ptannpiA);

        JsonObject mailingAddress = new JsonObject();
        mailingAddress.addProperty("city", "Augusta");
        mailingAddress.addProperty("state", "ME");
        mailingAddress.addProperty("country", "United States");
        mailingAddress.addProperty("zipCode", "89089");
        mailingAddress.addProperty("address1", "100, Kings Lane");

        location.add("mailingAddress", mailingAddress);

        JsonArray locations = new JsonArray();
        locations.add(location);
        return locations;
    }

    //TODO - this needs to be moved to Application
    public JsonObject getLicenseAndCertification() {
        // TODO this needs to be built to be useful
        //    if null values are passed in, use defaults
        JsonObject emptyO = new JsonObject();
        JsonArray emptyA = new JsonArray();
        emptyA.add(emptyO);

        JsonObject dea = new JsonObject();
        dea.add("deaNumbers", emptyA);

        JsonObject license = new JsonObject();
        license.add("licenseNumbers", emptyA);

        JsonObject certification = new JsonObject();
        certification.add("certificationNumbers", emptyA);

        JsonObject licenseAndCertification = new JsonObject();
        licenseAndCertification.add("dea", dea);
        licenseAndCertification.add("license", license);
        licenseAndCertification.add("certification", certification);
        return licenseAndCertification;
    }

    //TODO - this needs to be moved to Application
    public JsonObject getPersonanal() {
        // TODO this needs to be built to be useful
        //    if null values are passed in, use defaults
        JsonObject name = new JsonObject();
        name.addProperty("last", "Trade");
        name.addProperty("first", "Jack");
        name.addProperty("middleInitial", "O");

        JsonObject personal = new JsonObject();
        personal.addProperty("ssn", "123456789");
        personal.add("name", name);
        personal.addProperty("gender", "MALE");
        personal.addProperty("birthDate", "09/09/1978");
        personal.addProperty("npiNumber", "123456789");
        personal.addProperty("birthState", "Georgia");
        personal.addProperty("ptanNumber", "1234567890");
        personal.addProperty("birthCountry", "United States");
        personal.addProperty("otherNamesProvided", "N");
        personal.addProperty("acceptingNewPatients", "N");
        personal.addProperty("medicalProfessionalSchool", "123456789");

        return personal;
    }

    //TODO - this needs to be moved to Application
    public JsonObject getResidency() {
        // TODO this needs to be built to be useful
        //    if null values are passed in, use defaults
        JsonObject address = new JsonObject();
        address.addProperty("city", "Atlanta");
        address.addProperty("state", "Georgia");
        address.addProperty("country", "United States");
        address.addProperty("zipCode", "89098");
        address.addProperty("address1", "123, Test lane");

        JsonObject facility = new JsonObject();
        facility.add("address", address);

        JsonObject residency = new JsonObject();
        residency.addProperty("type", "FELLOWSHIP");
        residency.add("facility", facility);

        return residency;
    }

    //TODO - this needs to be moved to Application
    public void addAppMetaData(String entityId, String applicationId, JsonObject businessInformation, JsonArray practiceLocations, JsonObject licenseAndCertification) {
        JsonObject locations = new JsonObject();
        locations.add("locations", practiceLocations);

        JsonObject applicationData = new JsonObject();
        applicationData.add("businessInformation", businessInformation);
        applicationData.add("practiceLocation", locations);
        applicationData.add("licenseAndCertification", licenseAndCertification);

        JsonObject body = new JsonObject();
        body.addProperty("entity_id", entityId);
        body.addProperty("application_id", applicationId);
        body.add("application_data", applicationData);

        Response response = call.put("api/application/" + "applications", new Request().setJsonPayload(body));
        response.assertEquals(200);
    }

    //TODO - this needs to be moved to Application
    public void submitApplication(String formType, String entityId, String applicationId, JsonObject personalInformation, JsonObject residencyInformation, JsonArray practiceLocations, JsonObject licenseAndCertification) {
        JsonObject applicationMetadata = new JsonObject();
        applicationMetadata.addProperty("application_type", formType);

        JsonObject locations = new JsonObject();
        locations.add("locations", practiceLocations);

        JsonObject applicationData = new JsonObject();
        applicationData.add("personal", personalInformation);
        applicationData.add("residency", residencyInformation);
        applicationData.add("practiceLocation", locations);
        applicationData.add("licenseAndCertification", licenseAndCertification);

        JsonObject body = new JsonObject();
        body.addProperty("application_event_type", "SUBMITTED");
        body.add("application_metadata", applicationMetadata);
        body.addProperty("event_timestamp", System.currentTimeMillis());
        body.addProperty("entity_id", entityId);
        body.addProperty("application_id", applicationId);
        body.add("application_data", applicationData);

        Response response = call.post("api/application/" + "application-events", new Request().setJsonPayload(body));
        response.assertEquals(200);
    }

    public void createCase(String providerId, String formType, String reasonType) {
        Response application = call.post(BASE_URI + "casemanagement/" + providerId, new Request());
        String applicationId = application.getObjectData().get("applicationId").getAsString();
        setupForm(applicationId, formType, reasonType);
        addAppMetaData(providerId, applicationId, getBusinessInformation(), getPracticeLocations(), getLicenseAndCertification());
        submitApplication(formType, providerId, applicationId, getPersonanal(), getResidency(), getPracticeLocations(), getLicenseAndCertification());
    }
}
