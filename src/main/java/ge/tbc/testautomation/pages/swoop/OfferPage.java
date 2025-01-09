package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
public class OfferPage {
    public SelenideElement locationButton = $("button[data-testid='tertiary-button'] img[src='/icons/location.svg']")
            .closest("button"),
            mapContainer = $(".leaflet-container");
}
