package ge.tbc.testautomation.steps.allytest;

import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.results.Rule;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;
import java.util.List;

import static ge.tbc.testautomation.data.Constants.ALLY_TESTING_URL;
import static org.testng.Assert.assertTrue;
public class AllySteps {
    private List<Rule> violations;


    @Step("Open the home page")
    public AllySteps openPage() {
        open(ALLY_TESTING_URL);
        return this; // Fluent interface chaining
    }

    @Step("Analyze accessibility of the page")
    public AllySteps analyzeAccessibility() {
        this.violations = new AxeBuilder()
                .analyze(Selenide.webdriver().driver().getWebDriver())
                .getViolations();
        return this; // Fluent interface chaining
    }

    @Step("Log all accessibility violations")
    public AllySteps logViolations() {
        if (!violations.isEmpty()) {
            System.out.println("Accessibility Issues Found:");
            for (Rule violation : violations) {
                System.out.println("Violation: " + violation.getDescription());
                System.out.println("Help URL: " + violation.getHelpUrl());
                System.out.println("Impact: " + violation.getImpact());
                System.out.println("Tags: " + String.join(", ", violation.getTags()));
            }
        }
        return this; // Fluent interface chaining
    }

    @Step("Assert no accessibility violations are found")
    public AllySteps assertNoViolations() {
        assertTrue(violations.isEmpty(), "Accessibility issues found on the page.");
        return this; // Fluent interface chaining
    }
}
