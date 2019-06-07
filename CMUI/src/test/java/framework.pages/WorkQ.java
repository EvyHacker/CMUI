package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;


/*
 * @author Sukanya/Evy
 * WorkQ page
 */

public class WorkQ {

  private final Element linkDev;
  private final Element linkWorkQueue;
  private final Element verifyTableWorkQueue;
  private final Element receivedColumn;
  private final Element keywordString;
  private final Element quickFilters;
  private final Element noFilters;
  private final Element unassignedFilters;
  private final Element assignedToMeFilters;
  private final Element allTasksFilters;
  private final Element closedFilters;
  private final Element openFilters;
  private final Element advancedFilters;
  private final Element closedStatusCheck;
  private final Element modalClearAll;
  private final Element clearAll;
  private final Element cancelFilterModal;
  private final Element buttonSearch;
  private final Element verifySelectAll;
  private final Element select855B;
  private final Element select855I;
  private final Element select855R;
  private final Element statusRouted;
  private final Element statusInReview;
  private final Element statusInProgress;
  private final Element statusCloned;
  private final Element statusClosed;
  private final Element statusDispositioned;
  private final Element applyFilter;
  private final Element assigneeButton;
  private final Element assigneeSearchString;
  private final Element assigneeSearch;
  private final Element assigneeCancel;
  private final Element assigneeSelect;
  private final Element selectRow;
  private final Element checkStatusColumn;
  private final Element casePreview;
  private final Element openAppOverview;
  private final Element resultsReturned;
  private final Element assignedToTask;
  private final Element statusAssigned;
  private final Element alertElement;
  private final Element reasonInitialEnrollment;
  private final Element reasonEnrollingWithAnotherPractice;
  private final Element reasonReactivatingEnrollment;
  private final Element reasonRevalidatingEnrollment;
  private final Element reasonWithdroawal;
  private final Element reasonChangingInformation;
  private final Element badgeRow;
  private final Element assigneeBadge;
  private final App app;

  public WorkQ(App app) {

    this.app = app;

    //workQ link from navigation page
    linkDev = app.newElement(Locator.XPATH, "//a[@href='/dev-links']");
    linkWorkQueue = app.newElement(Locator.XPATH, "//i[contains(@class,'work')]");
    //WorkQ table elements
    verifyTableWorkQueue = app.newElement(Locator.XPATH, "//table[1]");
    receivedColumn = app.newElement(Locator.XPATH, "//th[contains(text(),'Received')]");
    verifySelectAll = verifyTableWorkQueue.findChild(app.newElement(Locator.NAME, "dt-toggle-select-all"));
    buttonSearch = app.newElement(Locator.ID, "wq-search-btn");
    clearAll = app.newElement(Locator.XPATH, "//button[contains(text(),'Clear Filters')]");
    selectRow = app.newElement(Locator.XPATH, "//tr[1]//td[1]//div[1]");
    assigneeButton = app.newElement(Locator.XPATH, "//button[contains(text(),'Assignee')]");
    assigneeSearchString = app.newElement(Locator.NAME, "assigneeName");
    assigneeSearch = app.newElement(Locator.ID, "wq-assignment-btn");
    assigneeSelect = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[3]/div/div/div/div[2]/div/div[1]/label");
    assigneeCancel = app.newElement(Locator.XPATH, "//button[contains(text(),'Cancel')]");
    casePreview = app.newElement(Locator.ID, "wq-preview-btn");
    openAppOverview = app.newElement(Locator.LINKTEXT, "Application Overview");
    checkStatusColumn = app.newElement(Locator.XPATH, "//tr[1]//td[5]//span[1]");
    resultsReturned = app.newElement(Locator.XPATH, "//caption[@class='ds-c-datatable__details']");
    assignedToTask = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[3]/div/div/div/div[3]/button[2]");
    //quick Filters elements
    quickFilters = app.newElement(Locator.CLASSNAME, "quickFilters");
    noFilters = app.newElement(Locator.XPATH, "(//button[@type='button'])", 0);
    unassignedFilters = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[1]/div/ul/li[1]/button", 1);
    assignedToMeFilters = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[1]/div/ul/li[2]/button", 2);
    allTasksFilters = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[1]/div/ul/li[3]/button", 3);
    closedFilters = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[1]/div/ul/li[4]/button", 4);
    openFilters = app.newElement(Locator.XPATH, "//*[@id=\"case_management_ui-work-queue\"]/div/div[1]/div/ul/li[5]/button", 5);
    //advanced Filters elements
    advancedFilters = app.newElement(Locator.XPATH, "//button[starts-with(text(), 'Filters')]");
    modalClearAll = app.newElement(Locator.XPATH, "//button[contains(text(),'<Clear All Filters>')]");
    applyFilter = app.newElement(Locator.ID, "applyFilterBtn");
    cancelFilterModal = app.newElement(Locator.XPATH, "//button[contains(text(),'Cancel')]");
    //keyword search
    keywordString = app.newElement(Locator.XPATH, "(//input[@name='keyword'])[2]");
    //Status
    closedStatusCheck = app.newElement(Locator.XPATH, "//input[@value='CLOSED']");
    statusRouted = app.newElement(Locator.XPATH, "//span[contains(text(),'Routed')]");
    statusInReview = app.newElement(Locator.XPATH, "//span[contains(text(),'In Review')]");
    statusInProgress = app.newElement(Locator.XPATH, "//span[contains(text(),'In Progress')]");
    statusCloned = app.newElement(Locator.XPATH, "//span[contains(text(),'Cloned')]");
    statusClosed = app.newElement(Locator.XPATH, "//span[contains(text(),'Closed')]");
    statusAssigned = app.newElement(Locator.XPATH, "//span[contains(text(),'Assigned')]");
    statusDispositioned = app.newElement(Locator.XPATH, "//span[contains(text(),'Dispositioned')]");
    //form type
    select855I = app.newElement(Locator.XPATH, "//span[contains(text(),'Form CMS-855I')]");
    select855B = app.newElement(Locator.XPATH, "//span[contains(text(),'Form CMS-855B')]");
    select855R = app.newElement(Locator.XPATH, "//span[contains(text(),'Form CMS-855R')]");
    //alerts
    alertElement = app.newElement(Locator.XPATH, "//div[@class='ds-c-alert ds-c-alert--success ds-c-alert--dismissable ds-c-alert--window']");
    //Submission Reasons
    reasonInitialEnrollment = app.newElement(Locator.XPATH, "(//span[contains(text(),'New enrollee')])[1]");
    reasonEnrollingWithAnotherPractice = app.newElement(Locator.XPATH, "//span[contains(text(),'Enrolling with another Medicare Administrative Con')]");
    reasonReactivatingEnrollment = app.newElement(Locator.XPATH, "//span[contains(text(),'Reactivating Enrollment')]");
    reasonRevalidatingEnrollment = app.newElement(Locator.XPATH, "//span[contains(text(),'Revalidating Enrollment')]");
    reasonWithdroawal = app.newElement(Locator.XPATH, "//span[contains(text(),'Voluntarily withdrawing from enrollment')]");
    reasonChangingInformation = app.newElement(Locator.XPATH, "(//span[contains(text(),'Changing enrollment information')])[1]");

    //Badges
    badgeRow = app.newElement(Locator.XPATH, "//div[@class='ds-c-card__row']");
    assigneeBadge = app.newElement(Locator.XPATH, "//span[@class='filter-badge-value'][contains(text(),'Anna')]");
  }

  public void navigateToWorkQueue() {
    linkDev.waitForState().enabled(30);
    linkDev.click();
    linkWorkQueue.waitForState().enabled(30);
    linkWorkQueue.click();
  }

  public void verifyWorkQueuePage() {
    linkWorkQueue.waitForState().enabled(30);
    verifyTableWorkQueue.waitForState().enabled(60);
    verifySelectAll.assertState().enabled();
    verifyTableWorkQueue.assertEquals().text(0, 1, "Work Type");
    verifyTableWorkQueue.assertEquals().text(0, 2, "Assignee");
    verifyTableWorkQueue.assertEquals().text(0, 3, "Providers/Organizations");
    verifyTableWorkQueue.assertEquals().text(0, 4, "Status");
    verifyTableWorkQueue.assertEquals().text(0, 5, "Received");
    verifyTableWorkQueue.assertEquals().text(0, 6, "Action");

  }

  public void clickOnQuickFilters() {
    linkWorkQueue.waitForState().enabled(30);
    quickFilters.waitForState().enabled(60);
    quickFilters.click();
  }

  public void selectNoFiltersAndAssertURL(String baseURL) {
    linkWorkQueue.waitForState().enabled(30);
    noFilters.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/");
  }

  public void selectUnassignedFiltersAndAssertURL(String baseURL, int contractCodes) {
    linkWorkQueue.waitForState().enabled(30);
    unassignedFilters.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?contractCodes=" + contractCodes + "&assignedToUserIds=null");

  }

  public void selectAssignedToMeFiltersAndAssertURL(String baseURL, String userId) {
    linkWorkQueue.waitForState().enabled(30);
    assignedToMeFilters.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?assignedToUserIds=" + userId);
  }

  public void selectAllTasksFiltersAndAssertURL(String baseURL, int contractCodes) {
    linkWorkQueue.waitForState().enabled(30);
    allTasksFilters.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?contractCodes=" + contractCodes);

  }

  public void selectClosedFiltersAndAssertURL(String baseURL, int contractCodes) {
    closedFilters.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?contractCodes=" + contractCodes + "&statuses=CLOSED");
    advancedFilters.click();
    cancelFilterModal.waitForState().enabled(60);
    closedStatusCheck.assertState().checked();
    cancelFilterModal.click();
  }

  public void selectOpenFiltersAndAssertURL(String baseURL, int contractCodes) {
    linkWorkQueue.waitForState().enabled(30);
    openFilters.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?contractCodes=" + contractCodes + "&statuses=IN_PROGRESS,ROUTED,RECEIVED,ASSIGNED,IN_REVIEW");
    advancedFilters.click();
    cancelFilterModal.waitForState().enabled(60);
    closedStatusCheck.assertState().notChecked();
    cancelFilterModal.click();
    clearAll.click();
  }
//assignedToUserIds=anna&keyword=Anna
// <Click to see difference>
  public void setKeywordStringAndAssertURL(String baseURL, String keyword) {
    linkWorkQueue.waitForState().enabled(30);
    assigneeBadge.click();
    keywordString.type(keyword);
    buttonSearch.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?keyword=" + keyword);
  }

  public void setFormType855B(String baseURL) {
    linkWorkQueue.waitForState().enabled(30);
    advancedFilters.click();
    select855B.waitForState().present(30);
    select855B.assertState().notChecked();
    select855B.click();
    applyFilter.click();
    assigneeBadge.click();
  }

  public void setFormType855IAndAssert(String baseURL, String keyword, String formtType) {
    linkWorkQueue.waitForState().enabled(30);
    advancedFilters.click();
    select855I.waitForState().present(30);
    select855I.assertState().notChecked();
    select855I.click();
    applyFilter.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?types=" + formtType);
  }

  public void setStatusInProgressAndAssert(String baseURL) {
    linkWorkQueue.waitForState().enabled(30);
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusInProgress.waitForState().present(30);
    statusInProgress.assertState().notChecked();
    statusInProgress.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=IN_PROGRESS");
  }

  public void setStatusRoutedAndAssert(String baseURL) {
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusRouted.waitForState().present(30);
    statusRouted.assertState().notChecked();
    statusRouted.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=ROUTED");
  }

  public void setStatusInReviewAndAssert(String baseURL) {
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusInReview.waitForState().present(30);
    statusInReview.assertState().notChecked();
    statusInReview.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=IN_REVIEW");
  }

  public void setStatusCloned(String baseURL) {
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusCloned.waitForState().present(30);
    statusCloned.assertState().notChecked();
    statusCloned.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=CLONED");

  }

  public void setStatusAssigned(String baseURL) {
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusAssigned.waitForState().present(30);
    statusAssigned.assertState().notChecked();
    statusAssigned.click();
    applyFilter.click();
    assigneeBadge.click();
    verifyTableWorkQueue.waitForState().displayed(15);
    receivedColumn.click();
    receivedColumn.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=ASSIGNED");

  }

  public void setStatusClosed(String baseURL) {
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusClosed.waitForState().present(30);
    statusClosed.assertState().notChecked();
    statusClosed.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=CLOSED");
  }

  public void setStatusDispositioned(String baseURL){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusDispositioned.waitForState().present(30);
    statusDispositioned.assertState().notChecked();
    statusDispositioned.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?statuses=CLOSEOUT_INITIATED");
  }

  public void statusKeywordSearchAndAssertURL(String baseURL, String status) {
    advancedFilters.waitForState().displayed(60);
    keywordString.type(status);
    buttonSearch.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?keyword=" + status);
  }

  public int isRowReturned() {
    verifyTableWorkQueue.waitForState().enabled(30);
    return verifyTableWorkQueue.get().numOfTableRows();
  }

  public void columnStatusAssert(String status) {
    checkStatusColumn.waitForState().displayed(60);
    checkStatusColumn.assertContains().text(status);
  }

  public void casePreviewToAppOverview() {
    verifyTableWorkQueue.waitForState().enabled(60);
    casePreview.waitForState().displayed(60);
    casePreview.click();
    openAppOverview.waitForState().enabled(60);
    openAppOverview.click();
  }

  public void clearAllFilters(String status) {
    verifyTableWorkQueue.waitForState().enabled(60);
    clearAll.click();
  }

  public void setInitialEnrollment(String baseURL, String submittalReason){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    reasonInitialEnrollment.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?submittalReasons=" + submittalReason);
  }

  public void setInitialEnrollingWithAnotherPractice(String baseURL, String submittalReason){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    reasonEnrollingWithAnotherPractice.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?submittalReasons=" + submittalReason);
  }

  public void setReasonReactivatingEnrollment(String baseURL, String submittalReason){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    reasonReactivatingEnrollment.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?submittalReasons=" + submittalReason);
  }

  public void setReasonRevalidatingEnrollmentEnrollment(String baseURL, String submittalReason){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    reasonRevalidatingEnrollment.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?submittalReasons=" + submittalReason);
  }

  public void setReasonWithdrawal(String baseURL, String submittalReason){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    reasonWithdroawal.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?submittalReasons=" + submittalReason);
  }

  public void setReasonChangingOfInformation(String baseURL, String submittalReason){
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    reasonChangingInformation.click();
    applyFilter.click();
    assigneeBadge.click();
    app.azzert().urlEquals(baseURL + "work-queue/#/?submittalReasons=" + submittalReason);
  }

  public void setManualAssignmentAndAssert(String assignee) {
    verifyTableWorkQueue.waitForState().enabled(60);
    advancedFilters.click();
    statusRouted.click();
    applyFilter.click();
    assigneeBadge.click();
    int rowReturned = verifyTableWorkQueue.get().numOfTableRows();
    if (rowReturned>1) {
      receivedColumn.click();
      receivedColumn.click();
      selectRow.click();
      assigneeButton.waitForState().present();
      assigneeButton.click();
      assigneeSearchString.type(assignee);
      assigneeSearch.click();
      assigneeSelect.waitForState().present();
      assigneeSelect.click();
      assignedToTask.click();
      alertElement.waitForState().present(30);
      alertElement.assertContains().text("The Assignee has been successfully updated");
    }
  }

  public void setVerificationCombo855IAndAssert() {
    linkWorkQueue.waitForState().enabled(30);
    advancedFilters.click();
    select855I.waitForState().present(10);
    select855I.assertState().notChecked();
    select855I.click();
    reasonInitialEnrollment.click();
    statusInReview.click();
    applyFilter.click();
    linkWorkQueue.waitForState().enabled(15);
    receivedColumn.click();
    receivedColumn.click();
    assigneeBadge.click();
    app.waitFor().textPresent("Viewing");
    badgeRow.assertContains().text("855I");
    badgeRow.assertContains().text("In Review");
    badgeRow.assertContains().text("New enrollee");

  }

  public void setVerificationCombo855BAndAssert() {
    linkWorkQueue.waitForState().enabled(30);
    advancedFilters.click();
    select855B .waitForState().present(10);
    select855B.assertState().notChecked();
    select855B.click();
    reasonInitialEnrollment.click();
    statusInReview.click();
    applyFilter.click();
    linkWorkQueue.waitForState().enabled(15);
    receivedColumn.click();
    receivedColumn.click();
    assigneeBadge.click();
    app.waitFor().textPresent("Viewing");
    badgeRow.assertContains().text("855B");
    badgeRow.assertContains().text("In Review");
    badgeRow.assertContains().text("New enrollee");
  }
}
