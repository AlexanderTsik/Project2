package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SwoopBasePage {

    // Search Elements
    public SelenideElement searchInput = $("input[placeholder='მოძებნე კომპანია ან შეთავაზება']"),
            searchButton = $("button[class*='absolute top-2.5']");
    // Category Elements
    public SelenideElement categoriesButton = $("button[data-testid='outline-button']"),

            relaxationCategory = $("a[href='/category/24/dasveneba/']"),
            kakhetiSubcategory = $("a[href='/category/1951/dasveneba/kaxeti/']");
    // Language Selection Elements
    public SelenideElement languageButton = $("[id='headlessui-menu-button-:r0:']"),
            georgianButton = $("div[id='headlessui-menu-items-:r1:']").$(byText("ქართული")),
            englishButton = $("div[id='headlessui-menu-items-:r1:']").$(byText("English"));
}
