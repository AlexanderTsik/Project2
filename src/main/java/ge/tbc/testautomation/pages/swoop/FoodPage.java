package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FoodPage {
    public SelenideElement eatAndDrinkCategory = $("a[href='/category/15/kveba/']"),
            numberOfGuestsFilterButton = $(
                    "button[aria-controls*='headlessui-disclosure-panel'][aria-expanded='true']");
    public ElementsCollection filterOptions = $$("label[for^='radio-სტუმრების რაოდენობა-']"),
            offerTitles = $$(".grid-flow-row h4");
}
