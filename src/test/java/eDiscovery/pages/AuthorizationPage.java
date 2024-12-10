package eDiscovery.pages;


import com.codeborne.selenide.SelenideElement;
import eDiscovery.pages.searchQuery.SearchQueryPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    SelenideElement
            loginInput = $(byId("username")),
            passwordInput = $("input[type='password']"),
            loginButton = $(byText("Авторизоваться"));

    @Step("Открываем сайт")
    public AuthorizationPage openPage(){
        open("/");
        return this;
    }

    @Step("Ввод логина")
    public AuthorizationPage typeLogin(String value){
        loginInput.setValue(value);
        return this;
    }

    @Step("Ввод пароля")
    public AuthorizationPage typePassword(String value){
        passwordInput.setValue(value);
        return this;
    }

    @Step("Нажатие на кнопку \"Авторизоваться\"")
    public SearchQueryPage clickLoginButton(){
        loginButton.click();
        return page(SearchQueryPage.class);
    }

    @Step("Авторизация")
    public SearchQueryPage login(String login, String password){
        return this
                .typeLogin(login)
                .typePassword(password)
                .clickLoginButton();
    }

}
