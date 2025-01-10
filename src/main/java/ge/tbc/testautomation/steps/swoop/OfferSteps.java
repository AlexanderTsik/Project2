package ge.tbc.testautomation.steps.swoop;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.swoop.OfferPage;
import ge.tbc.testautomation.pages.swoop.SearchPage;
import io.qameta.allure.Step;

public class OfferSteps {
    OfferPage page = new OfferPage();
    SearchPage searchPage = new SearchPage();

    @Step("Click on the first offer")
    public OfferSteps clickFirstOffer() {
        searchPage.firstOffer.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Click the location button on the offer page")
    public OfferSteps clickLocationButton() {
        page.locationButton.shouldBe(Condition.visible).scrollIntoCenter().click();
        return this;
    }
    @Step("Validate that the map is displayed")
    public OfferSteps validateMapDisplayed() {
        page.mapContainer.shouldBe(Condition.visible);
        return this;
    }
}
