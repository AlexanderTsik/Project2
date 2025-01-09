package ge.tbc.testautomation.pages.saucedemo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement usernameField = $("#user-name"),
            passwordField = $("#password"),
            loginButton = $("#login-button"),
            errorMessageContainer = $(".error-message-container"),
            errorIcon = $(".error_icon");
}