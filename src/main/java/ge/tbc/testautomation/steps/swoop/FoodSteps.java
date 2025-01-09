package ge.tbc.testautomation.steps.swoop;

import ge.tbc.testautomation.pages.swoop.FoodPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.testautomation.data.Constants.SWOOP_BASE_URL;

public class FoodSteps {
    FoodPage page = new FoodPage();
    private int minGuests;
    private int maxGuests;


    @Step("Navigate to the Eat and Drink category")
    public FoodSteps navigateToFood(){
        open(SWOOP_BASE_URL);
        page.eatAndDrinkCategory.shouldBe(Condition.visible).click();
        return this;
    }
    @Step("Open the Number of Guests filter")
    public FoodSteps openNumberOfGuestsFilter() {
        page.numberOfGuestsFilterButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Select filter option at index {optionIndex}")
    public FoodSteps selectFilterOption(int optionIndex) {
        page.filterOptions.get(optionIndex).shouldBe(Condition.visible).click();
        String filterText = page.filterOptions.get(optionIndex).getText(); // Get the filter text (e.g., "2-5 სტუმარი")
        extractMinAndMaxGuests(filterText); // Extract numeric range
        return this;
    }

    private void extractMinAndMaxGuests(String filterText) {
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+)"); // Regex to find min and max (e.g., "2-5")
        Matcher matcher = pattern.matcher(filterText);
        if (matcher.find()) {
            minGuests = Integer.parseInt(matcher.group(1));
            maxGuests = Integer.parseInt(matcher.group(2));
        } else {
            throw new IllegalArgumentException("Invalid filter text format: " + filterText);
        }
    }

    @Step("Validate that all offers match the selected filter criteria")
    public FoodSteps validateOffersMatchFilter() {
        List<String> offers = page.offerTitles.texts(); // Get all offer titles
        Pattern pattern = Pattern.compile("(\\d+)-?(\\d+)?"); // Regex to extract guest numbers from offer titles

        for (String offer : offers) {
            Matcher matcher = pattern.matcher(offer);
            if (matcher.find()) {
                int offerGuests = Integer.parseInt(matcher.group(1)); // Parse the guest number
                if (offerGuests < minGuests || offerGuests > maxGuests) {
                    throw new AssertionError("Offer does not match filter criteria: " + offer);
                }
            } else {
                throw new AssertionError("Offer does not contain guest number: " + offer);
            }
        }
        return this;
    }
}
