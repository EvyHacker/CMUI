package functional;

import com.coveros.selenified.Selenified;
import framework.pages.Login;
import framework.pages.Logout;
import framework.pages.Redirect_Login;
import framework.pages.RoleBasedAuthorization_Workqueue;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Jona Q
 * Test Case for Logins for MAC as well as Provider.
 */

public class LoginIT extends Selenified {

  private final ThreadLocal<Login> login = new ThreadLocal<>();

  @BeforeMethod(alwaysRun = true)
  public void setLogIn() {
    Login loginPage = new Login(this.apps.get());
    loginPage.navigateToLoginPage();
    login.set(loginPage);
  }

  @BeforeClass(alwaysRun = true)
  public void beforeClass(ITestContext test) {
    // set the base URL for the tests here
    setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
  }

  @DataProvider(name = "users", parallel = true)
  public Object[][] UserOptions() throws IOException {
    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
    prop.load(ip);
    String[] users = prop.getProperty("users").split(",");
    Object[][] usersData = new Object[users.length][];
    for (int i = 0; i < users.length; i++) {
      String username = prop.getProperty(users[i] + ".user");
      String password = prop.getProperty(users[i] + ".password");
      Object[] userData = new Object[]{username, password};
      usersData[i] = userData;
    }
    return usersData;
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyAccessibilityLinkLoginPage() {
    this.login.get().verifyAccessibilityLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyCmsLinkLoginPage() {
    this.login.get().verifyCmsLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyForgotPasswordLinkLoginPage() {
    this.login.get().verifyForgotPwdLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyHhsLinkLoginPage() {
    this.login.get().verifyHhsLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyLearnMoreLinkLoginPage() {
    this.login.get().verifyLearnMoreLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyManageProfileLinkLoginPage() {
    this.login.get().verifyManageProfileLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyForgotUserIdLinkLoginPage() {
    this.login.get().verifyForgotUserIdLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyRegisterForNPILinkLoginPage() {
    this.login.get().verifyRegisterForNPILink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyRegisterLinkLoginPage() {
    this.login.get().verifyRegisterLink();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyLoginPageElementLoginPage() {
    this.login.get().verifyOnLoginPage();
  }

  @Test(dataProvider = "users", groups = {"positive"}, description = "Login with all users in config file and verify a successful login")
  public void verifyElementOnLoginPage(String username, String password) {
    Login loginPage = this.login.get();
    loginPage.login(username, password);
    loginPage.waitForLoggedIn();
    loginPage.verifyDashboardTitle();
  }


  @Test(dataProvider = "users", groups = {"positive"}, description = "Login with all users in config file and verify a successful login")
  public void positiveLoginTest(String username, String password) {
    Login loginPage = this.login.get();
    loginPage.login(username, password);
    loginPage.waitForLoggedIn();
    loginPage.verifyOnDashboardPage();
    finish();
  }

//	@Test
//	public void ProviderloginTest() {
//		loginPage.VerifyLoginPage();
//		loginPage.Login(prop.getProperty("Provider"), prop.getProperty("ProviderPassword"));
//		loginPage.PecosPage();
//		loginPage.VerifyDashboardPage();
//		driver.quit();
//		System.out.println("User successfully logged in as Provider");
//	}

  @Test(groups = {"negative"}, description = "Login using wrong Username and Password")
  public void negativeLoginTest() {

    Login loginPage = this.login.get();
    loginPage.login("SomeUser", "SomePass");
    loginPage.verifyFalseLogin();
    loginPage.verifyOnLoginPage();
    finish();
  }

  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyUserNavigateToOtherPage() {
    Logout logoutpage = new Logout(this.apps.get());
    Redirect_Login redirect_loginPage = new Redirect_Login(this.apps.get());
    Login loginPage = this.login.get();
    loginPage.login("anna", "password");
    redirect_loginPage.verifyUserNavigateToOtherPage();
    logoutpage.verifyUserSuccessfullyLoggedOut();
    redirect_loginPage.userAttemptsRedirectsWithoutAuth();
    loginPage.login("anna", "password");
    redirect_loginPage.verifyUserRedirectToIntendedPage();
    finish();
  }


  @Test(groups = {"positive"}, description = "Verify elements on login page")
  public void verifyMacsNavigateToWorkQue() {
    Logout logoutpage = new Logout(this.apps.get());
    RoleBasedAuthorization_Workqueue roleBasedAuthorization_workQueue = new RoleBasedAuthorization_Workqueue(this.apps.get());
    Login loginPage = this.login.get();
    loginPage.login("anna", "password");
    roleBasedAuthorization_workQueue.verifyMacsCanAccessWorkQueue();
    finish();
  }
    @Test(groups = {"positive"}, description = "Verify elements on login page")
    public void verifyNonMacsCantNavigateToWorkQue() {
      Logout logoutpage = new Logout(this.apps.get());
      RoleBasedAuthorization_Workqueue roleBasedAuthorization_workQueue = new RoleBasedAuthorization_Workqueue(this.apps.get());
      Login loginPage = this.login.get();
      loginPage.login("FFWD", "password");
      roleBasedAuthorization_workQueue.verifyNonMacsCantAccessWorkQueue();
      finish();
  }


}

