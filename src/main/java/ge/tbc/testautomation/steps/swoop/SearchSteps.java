package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbc.testautomation.pages.swoop.SearchPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    @Step("Validate search results contain the query: {query}")
    public SearchSteps validateSearchResults(String query) {
        SoftAssert softAssert = new SoftAssert();

        try {// Validate that at least one subtitle element contains the query
            searchPage.subtitleElements
                    .findBy(Condition.text(query))
                    .shouldBe(Condition.visible, Duration.ofSeconds(10));
        } catch (ElementNotFound e) {// Handle the case where no results are found
            searchPage.noResultsMessage.shouldBe(Condition.visible);
            String noResultsText = searchPage.noResultsMessage.getText();
            softAssert.assertEquals(noResultsText, "შეთავაზება არ მოიძებნა",
                    "Unexpected no results message: " + noResultsText);
            softAssert.assertAll();
            return this;
        }
        // Iterate through subtitle elements to ensure each contains the query
        for (SelenideElement element : searchPage.subtitleElements) {
            String elementText = element.getText();
            softAssert.assertTrue(elementText.toLowerCase().contains(query.toLowerCase()),
                    "The subtitle text does not contain the keyword: " + query);
        }

        softAssert.assertAll();
        return this;
    }

}
