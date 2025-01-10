package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class SearchPage {
    // Elements
    public ElementsCollection offerTitles = $$(".grid-flow-row h4"),                 // All offer titles
            subtitleElements = $$(".text-primary_black-50-value"); // Subtitle elements
    public SelenideElement nextButton = $("img[src='/icons/ep_arrow-right-bold.svg']"),
            previousButton = $("img[src='/icons/ep_arrow-left-bold.svg']"),
            firstOffer = $(".grid-flow-row .group:first-child"),       // First offer card
            noResultsMessage = $("h2.font-tbcx-bold.text-center.text-primary_black-100-value.text-2lg");
}


