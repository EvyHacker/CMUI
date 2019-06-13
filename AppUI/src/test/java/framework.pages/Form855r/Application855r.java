package framework.pages.Form855r;

import com.coveros.selenified.Locator;
import com.coveros.selenified.application.App;
import com.coveros.selenified.element.Element;

//TODO: Update this file with proper element locations.

/**
 * This is a quick first pass to get some tests in the pipeline
 * This file will continue to update based on object map creation
 */

public class Application855r {

    private final Element beginSubmission;
    private final Element inAppReview;


    public Application855r(App app) {
        beginSubmission = app.newElement(Locator.XPATH,"//a[contains(text(),'Review Application')]");
        inAppReview = app.newElement(Locator.LINKTEXT, "Return to Application");

        this.app = app;
    }
    private final App app;

    public void clickBeginSubmission() {
        beginSubmission.waitForState().displayed(30);
        beginSubmission.assertState().displayed();
        beginSubmission.assertContains().text("Review Application");
        beginSubmission.waitForEquals().changeDefaultWait(30);
        beginSubmission.click();
        app.azzert().titleEquals("PECOS");
    }

    public void assertInAppReview(){
        inAppReview.is().displayed();
    }
}
