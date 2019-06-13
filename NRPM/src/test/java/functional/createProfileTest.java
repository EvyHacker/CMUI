package functional;

import com.coveros.selenified.Selenified;
import framework.pages.Dashboard;
import framework.pages.Login;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createProfileTest extends Selenified {


    @BeforeMethod(alwaysRun = true)
    public void setLogin() {
        Login loginPage = new Login(this.apps.get());
        loginPage.navigateToLoginPage();
        loginPage.login("R9VR", "password");

        Dashboard dashboard = new Dashboard(this.apps.get());
        dashboard.clickDevLinks();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext test) {
        //sets the base URL for tests
        setTestSite(this, test, "http://page-service-staging.apps.pecos-staging.cpi.cmscloud.local/");
    }

    @Test
    public void createSimpleProfileAndAssert() {
        Dashboard dashboard = new Dashboard(this.apps.get());
        dashboard.clickDevLinks();
        dashboard.createSimpleProfile("Archie Windsor", "112332123", "05/05/1980", "1010101022");
        dashboard.simpleProfileAppCreation();
        finish();
    }
}
