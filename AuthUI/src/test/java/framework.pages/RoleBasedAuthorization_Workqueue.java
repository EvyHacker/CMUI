package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class RoleBasedAuthorization_Workqueue {


  /**
   * @author Sindhu Bhupathiraju
   */

  private final Element verifyUserLoggedIn;
  private final Element WorkQueueLink;
  private final Element WorkQueueWidget;
  private final Element WelcomeAnna;
  //private final Element MyWorkQueue;
  private final App app;


  public RoleBasedAuthorization_Workqueue(App app) {

    this.app = app;
    verifyUserLoggedIn = app.newElement(Locator.XPATH, "//span[@class='ds-u-font-size--small']");
    WorkQueueLink = app.newElement(Locator.PARTIALLINKTEXT, "Work Queue");
    WorkQueueWidget = app.newElement(Locator.ID, "case_management_ui-work-queue-widget");
    WelcomeAnna = app.newElement(Locator.XPATH, "//h1[contains(text(),'<Welcome Anna>')]");
    //MyWorkQueue = app.newElement(Locator.XPATH, "//h1[contains(text(),'My Work Queue')]");
  }

  // Verify Macs can access work-queue and WorkQueue widget and navigate to work Queue

  public void verifyMacsCanAccessWorkQueue() {
    app.wait(3d);
    verifyUserLoggedIn.waitForState().enabled(30);
    app.waitFor().textPresent("Work Queue");
    WorkQueueLink.click();
    app.waitFor().textPresent("My Work Queue");
    app.goBack();
    app.waitFor().textPresent("Welcome Anna");
    WorkQueueWidget.verifyState().present();
  }

  // Verify Non Macs can't access Work_Queue and Work_Queue widget

  public void verifyNonMacsCantAccessWorkQueue () {
    verifyUserLoggedIn.waitForState().enabled(5);
    String baseURL = app.get().url();
    String newUrl = baseURL.replace("dashboard", "work-queue/#/");
    app.goToURL(newUrl);
    WorkQueueLink.verifyState().notPresent();
    app.azzert().textPresent("Dashboard");
  }

}

