package framework.pages;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

public class Redirect_Login {


  /**
   * @author Sindhu Bhupathiraju
   */

  private final Element verifyUserLoggedIn;
  private final Element devLink;
  private final App app;


  public Redirect_Login(App app) {

    this.app = app;
    verifyUserLoggedIn = app.newElement(Locator.XPATH, "//span[@class='ds-u-font-size--small']");
    devLink = app.newElement(Locator.XPATH, "//ul[2]//li[1]//a[1]");

  }

  // Verify user redirect to Original destination

  public void verifyUserNavigateToOtherPage() {
    app.wait(3d);
    devLink.click();
    app.waitFor().textPresent("Developer Links");
  }

  // Verify user Attempts Redirects Without Authentication

  public void userAttemptsRedirectsWithoutAuth() {
    app.goToURL("http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/providers/#/");
    app.azzert().textPresent("Welcome to the Medicare Provider Enrollment, Chain, and Ownership System (PECOS)");

  }

  // Verify user redirect to intended page

  public void verifyUserRedirectToIntendedPage() {
    verifyUserLoggedIn.waitForState().enabled(30);
    app.wait(5d);
    app.azzert().textPresent("Providers");
    app.wait(2d);
    app.azzert().urlEquals("http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/providers/#/");
  }


}




