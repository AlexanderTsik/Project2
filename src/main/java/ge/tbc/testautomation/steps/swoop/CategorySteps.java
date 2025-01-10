package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.swoop.SearchPage;
import ge.tbc.testautomation.pages.swoop.SwoopBasePage;
import io.qameta.allure.Step;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.data.Constants.SWOOP_BASE_URL;


public class CategorySteps {

    private final SwoopBasePage swoopBasePage = new SwoopBasePage();
    private final SearchPage searchPage = new SearchPage();

    private List<String> collectedOffers = new ArrayList<>();

    @Step("Navigate to 'დასვენება' category and select 'კახეთი' subcategory")
    public CategorySteps navigateToCategory() {
        open(SWOOP_BASE_URL);
        swoopBasePage.categoriesButton.click();
        swoopBasePage.relaxationCategory.hover(); // Hover over "დასვენება" category
        swoopBasePage.kakhetiSubcategory.click(); // Click "კახეთი" subcategory
        return this;
    }

    @Step("Collect offers from the current page")
    public CategorySteps collectOffers() {
        List<String> offers = searchPage.offerTitles.texts(); // Get all offer titles
        collectedOffers.addAll(offers);
        return this;
    }

    @Step("Navigate to the next page of offers")
    public CategorySteps goToNextPage() {
        searchPage.nextButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Validate that there are no duplicate offers across pages")
    public CategorySteps validateNoDuplicates() {
        List<String> currentPageOffers = searchPage.offerTitles.texts(); // Get current page offers
        for (String offer : currentPageOffers) {
            if (collectedOffers.contains(offer)) {
                throw new AssertionError("Duplicate offer found: " + offer);
            }
        }
        collectedOffers.addAll(currentPageOffers);
        return this;
    }

    @Step("Navigate to the previous page of offers")
    public CategorySteps goToPreviousPage() {
        searchPage.previousButton.shouldBe(Condition.visible).click();


        return this;
    }

}
