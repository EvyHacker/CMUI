
package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

/**
 * @author Sindhu Bhupathiraju
 */
public class Logout {

  private final Element verifyUserLoggedIn;
  //private final Element linkDev;
  private final Element buttonDropdown;
  private final Element LogOutButton;
  private final App app;


  public Logout(App app) {

    this.app = app;
    verifyUserLoggedIn = app.newElement(Locator.XPATH, "//span[@class='ds-u-font-size--small']");
    buttonDropdown = app.newElement(Locator.XPATH, "//i[@class='ds-c-icon']");
    LogOutButton = app.newElement(Locator.XPATH, "//button[@class='ds-c-button ds-c-button--outlined']");
    //linkDev = app.newElement(Locator.LINKTEXT, "linkDev Links");
  }
  // Verifying  Log Out button on Dashboard Page

  public void verifyUserSuccessfullyLoggedOut() {

    verifyUserLoggedIn.waitForState().enabled(30);
    verifyUserLoggedIn.assertContains().text("Anna");
    buttonDropdown.click();
    app.azzert().textPresent("Log Out");
    LogOutButton.click();
    app.wait(2d);
    app.azzert().textPresent("Welcome to the Medicare Provider Enrollment, Chain, and Ownership System (PECOS)");
  }

  public void verifyUserCantNavigateWithoutAuthentication() {

    verifyUserLoggedIn.waitForState().enabled(30);
    verifyUserLoggedIn.assertContains().text("Anna");
    buttonDropdown.click();
    app.azzert().textPresent("Log Out");
    LogOutButton.click();
    app.wait(1d);
    app.goToURL("http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/dashboard");
    app.azzert().textPresent("Welcome to the Medicare Provider Enrollment, Chain, and Ownership System (PECOS)");

  }

}
