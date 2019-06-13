package functional;

import com.coveros.selenified.Selenified;
import framework.pages.Login;
import framework.pages.Logout;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutIT extends Selenified {

  private final ThreadLocal<Logout> logOut = new ThreadLocal<>();

  @BeforeMethod(alwaysRun = true)

  public void setLogIn() {
    Login loginPage = new Login(this.apps.get());
    logOut.set(new Logout(this.apps.get()));
    Login login =new Login (this.apps.get());
    loginPage.navigateToLoginPage();
    login.login ("anna", "password");

  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass(ITestContext test) {
    // set the base URL for the tests here
    setTestSite(this, test, "http://page-service-staging.apps.pecos-staging" +
      ".cpi.cmscloud.local");
  }

  @Test
  public void verifyUserSuccessfullyLoggedOut(){
    Logout logOut_Page = this.logOut.get();
    logOut_Page.verifyUserSuccessfullyLoggedOut();
    finish();
  }

  @Test
  public void verifyUserIsBlockedWithoutAuth(){
    Logout logOut_Page = this.logOut.get();
    logOut_Page.verifyUserCantNavigateWithoutAuthentication();

    finish();
  }
}




