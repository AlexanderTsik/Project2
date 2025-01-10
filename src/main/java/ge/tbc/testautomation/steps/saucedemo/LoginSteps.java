package ge.tbc.testautomation.steps.saucedemo;

import ge.tbc.testautomation.pages.saucedemo.InventoryPage;
import ge.tbc.testautomation.pages.saucedemo.LoginPage;
import ge.tbc.testautomation.steps.DatabaseSteps;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static ge.tbc.testautomation.data.Constants.*;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();
    private final DatabaseSteps databaseSteps = new DatabaseSteps();

    @Step("Open the SauceDemo login page")
    public LoginSteps openLoginPage() {
        open(SAUCE_BASE_URL);
        return this;
    }

    @Step("Enter credentials for user ID: {id} from the database")
    public LoginSteps enterCredentialsFromDatabaseById(int id) {
        String[] credentials = databaseSteps.getCredentialsById(id);

        if (credentials[0] == null || credentials[1] == null) {
            throw new RuntimeException("Credentials not found for user with ID: " + id);
        }

        loginPage.usernameField.setValue(credentials[0]);
        loginPage.passwordField.setValue(credentials[1]);
        return this;
    }

    @Step("Click the login button")
    public LoginSteps clickLogin() {
        loginPage.loginButton.click();
        return this;
    }

    @Step("Validate that all product images are loaded")
    public LoginSteps validateImagesLoaded() {
        inventoryPage.inventoryImages.forEach(img -> img.shouldBe(visible));
        return this;
    }

    @Step("Validate locked-out user error message")
    public LoginSteps validateLockedOutUserMessage() {
        loginPage.errorMessageContainer.shouldHave(text(ERROR_MESSAGE));
        loginPage.errorIcon.shouldBe(visible);
        return this;
    }

    @Step("Open the menu")
    public LoginSteps openMenu() {
        inventoryPage.menuButton.click();
        return this;
    }

    @Step("Click the logout button")
    public LoginSteps clickLogout() {
        inventoryPage.logoutLink.click();
        return this;
    }

    @Step("Validate that the login form fields are empty")
    public LoginSteps validateLoggedOutState() {
        // Validate that username and password fields are empty
        loginPage.usernameField.shouldBe(empty);
        loginPage.passwordField.shouldBe(empty);
        return this;
    }
}

