package ge.tbc.testautomation.utils;
import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HelperMethods {

    /**
     * Validates the labels on a webpage based on the expected labels.
     *
     * @param expectedLabels List of expected labels for the selected language.
     * @param language       Current language being validated.
     * @param softAssert     SoftAssert instance for handling multiple assertions.
     */
    public static void validateLabels(List<String> expectedLabels, String language, SoftAssert softAssert) {
        for (int i = 0; i < expectedLabels.size(); i++) {
            String expectedText = expectedLabels.get(i);

            // Validate the label text matches the expected value
            String actualText = $("div.flex > a:nth-of-type(" + (i + 1) + ") > p")
                    .shouldHave(text(expectedText))
                    .getText();

            softAssert.assertEquals(
                    actualText,
                    expectedText,
                    String.format("Label mismatch in %s language at index %d: Expected [%s] but found [%s]",
                            language, i, expectedText, actualText)
            );
        }
    }
}
