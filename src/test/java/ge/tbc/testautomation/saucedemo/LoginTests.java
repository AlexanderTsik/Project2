package ge.tbc.testautomation.saucedemo;

import com.codeborne.selenide.Configuration;
import ge.tbc.testautomation.steps.saucedemo.LoginSteps;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

@Epic("SauceDemo Login Functionality")
@Feature("User Authentication Tests")
public class LoginTests  {

    private final LoginSteps loginSteps = new LoginSteps();

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void tearDown() {
        com.codeborne.selenide.Selenide.closeWebDriver();
    }

    @Test(description = "Validate successful login using user ID",
        groups = "SauceDemoLogin")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able to login successfully with valid credentials")
    public void successfulLoginTest() {
        loginSteps
                .openLoginPage()
                .enterCredentialsFromDatabaseById(USER_ID)//ასევე შეგვიძლია დატა პროვაიდერის გამოყენება სხვადასხვა იუზერზე გასატესტად
                .clickLogin()
                .validateImagesLoaded();
    }

    @Test(description = "Validate login attempt with a banned user",
            groups = "SauceDemoLogin")
    @Severity(SeverityLevel.BLOCKER)
    @Story("User should see an error message when attempting to log in with a banned account")
    public void bannedUserLoginTest() {
        loginSteps
                .openLoginPage()
                .enterCredentialsFromDatabaseById(LOCKEDOUT_USER_ID)
                .clickLogin()
                .validateLockedOutUserMessage();
    }

    @Test(description = "Validate successful logout",
            groups = "SauceDemoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Story("User should be able to log out and see login inputs reset")
    public void logOutTest() {
        loginSteps
                .openLoginPage()
                .enterCredentialsFromDatabaseById(USER_ID)
                .clickLogin()
                .openMenu()
                .clickLogout()
                .validateLoggedOutState();
    }
}

