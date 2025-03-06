package eDiscovery.pages.authorization;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    private final SelenideElement
            loginInput      = $(byId("username")),
            passwordInput   = $("input[type='password']"),
            loginButton     = $(byText("Авторизоваться"));

    @Step("Открываем сайт")
    public AuthorizationPage openPage(){
        open("/");
        return this;
    }

    @Step("Ввод логина")
    public AuthorizationPage inputLogin(String value){
        loginInput.setValue(value);
        return this;
    }

    @Step("Ввод пароля")
    public AuthorizationPage inputPassword(String value){
        passwordInput.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку \"Авторизоваться\"")
    public AuthorizationPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    @Step("Авторизация")
    public AuthorizationPage login(String login, String password){
        return this
                .inputLogin(login)
                .inputPassword(password)
                .clickLoginButton();
    }

}
