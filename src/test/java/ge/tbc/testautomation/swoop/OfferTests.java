package ge.tbc.testautomation.swoop;

import com.codeborne.selenide.Configuration;
import ge.tbc.testautomation.data.DataProviders;
import ge.tbc.testautomation.steps.swoop.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static ge.tbc.testautomation.data.Constants.FILTER_OPTION;

@Epic("Swoop Tests")
@Feature("Search Functionality")
public class OfferTests {
    private final SwoopBaseSteps swoopBaseSteps = new SwoopBaseSteps();
    private final CategorySteps categorySteps = new CategorySteps();
    private final OfferSteps offerSteps = new OfferSteps();
    private final FoodSteps foodSteps = new FoodSteps();
    private final LanguageSteps languageSteps = new LanguageSteps();


    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void tearDown() {
        com.codeborne.selenide.Selenide.closeWebDriver();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Perform search and validate results")
    @Test(description = "Validate search functionality with valid and invalid keywords.",
            groups = {"SwoopRegression"},
            dataProviderClass = DataProviders.class, dataProvider = "searchData")
    public void searchTest(String query) {
        swoopBaseSteps.openBasePage()
                .performSearch(query)
                .validateSearchResults(query);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Validate pagination offers are unique across pages",
            groups = {"SwoopRegression"})
    public void validateUniqueOffersAcrossPages() {
        categorySteps.navigateToCategory()
                .collectOffers()
                .goToNextPage()
                .validateNoDuplicates()
                .goToNextPage()
                .validateNoDuplicates()
                .goToPreviousPage()
                .validateNoDuplicates();
    }

    @Test(description = "Validate map is displayed after clicking location",
            groups = {"SwoopRegression"})
    @Severity(SeverityLevel.CRITICAL)
    public void offerLocationTest() {
        categorySteps.navigateToCategory();
        offerSteps.clickFirstOffer()
                .clickLocationButton()
                .validateMapDisplayed();
    }

    @Test(description = "Validate number of guests filter works correctly",
            groups = {"SwoopRegression"})
    @Severity(SeverityLevel.CRITICAL)
    public void numberOfGuestsTest() {
        foodSteps.navigateToFood()
                .openNumberOfGuestsFilter()
                .selectFilterOption(FILTER_OPTION) // Select the first filter option dynamically
                .validateOffersMatchFilter(); // Automatically validates based on numeric range
    }



    @Test(description = "Validate navigation labels change with language",
            groups = {"SwoopRegression"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify navigation labels update correctly when switching languages")
    public void validateLanguageChangeTest() {
        languageSteps.openSwoopWebsite()
                .clickLanguageButton()
                .selectGeorgianLanguage()
                .validateGeorgianLabels()
                .clickLanguageButton()
                .selectEnglishLanguage()
                .validateEnglishLabels();
    }
}

