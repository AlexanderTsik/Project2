package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.pages.swoop.SwoopBasePage;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.data.Constants.SWOOP_BASE_URL;

public class SwoopBaseSteps {

    SwoopBasePage basePage = new SwoopBasePage();
    SearchSteps searchSteps = new SearchSteps();

    @Step("Open the Swoop base page")
    public SwoopBaseSteps openBasePage(){
        open(SWOOP_BASE_URL);
        return this;
    }
    @Step("Perform search with query: {query}")
    public SwoopBaseSteps performSearch(String query) {

        basePage.searchInput.setValue(query);
        basePage.searchButton.click();

        return this;
    }
    @Step("Validate search results for query: {query}")
    public SwoopBaseSteps validateSearchResults(String query) {
        searchSteps.validateSearchResults(query);
        return this;
    }
}
