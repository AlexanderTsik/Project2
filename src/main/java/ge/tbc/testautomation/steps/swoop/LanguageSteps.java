package ge.tbc.testautomation.steps.swoop;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.utils.HelperMethods;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import ge.tbc.testautomation.pages.swoop.SwoopBasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ge.tbc.testautomation.data.Constants.*;

import java.util.List;


import static com.codeborne.selenide.Selenide.open;


public class LanguageSteps {
    private final SwoopBasePage page = new SwoopBasePage();
    private final SoftAssert softAssert = new SoftAssert();

    @Step("Open the Swoop website")
    public LanguageSteps openSwoopWebsite() {
        open(SWOOP_BASE_URL);
        return this;
    }

    @Step("Click on the language button")
    public LanguageSteps clickLanguageButton() {
        page.languageButton.click();
        return this;
    }

    @Step("Select Georgian language")
    public LanguageSteps selectGeorgianLanguage() {
        page.georgianButton.click();
        return this;
    }

    @Step("Select English language")
    public LanguageSteps selectEnglishLanguage() {
        page.englishButton.click();
        System.out.println("Changing to english");

        return this;
    }
    @Step("Validate navigation labels for Georgian language")
    public LanguageSteps validateGeorgianLabels() {
        HelperMethods.validateLabels(GEORGIAN_LABELS, "Georgian", softAssert);
        softAssert.assertAll();
        return this;
    }

    @Step("Validate navigation labels for English language")
    public LanguageSteps validateEnglishLabels() {
        HelperMethods.validateLabels(ENGLISH_LABELS, "English", softAssert);
        softAssert.assertAll();
        return this;
    }
}
