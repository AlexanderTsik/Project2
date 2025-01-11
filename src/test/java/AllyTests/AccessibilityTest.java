package AllyTests;

import AllyTests.base.BaseTest;
import ge.tbc.testautomation.steps.allytest.AllySteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Accessibility")
@Feature("UI Accessibility")
public class AccessibilityTest extends BaseTest {

    @Test(description = "Check Accessibility Issues on Home Page",
            groups = "accessibility")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify Home Page Accessibility")
    public void homePageAccessibilityTest() {
        new AllySteps()
                .openPage()
                .analyzeAccessibility()
                .logViolations()
                .assertNoViolations();
    }
}
