package eDiscovery.pages.deal.searchPlace;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchPlaceCreationEditingPage {

    public static final String
            HEADER_CREATION_TEXT                = "Новое место поиска";

    private final SelenideElement
            pageHeader                          = $("h2"),
            searchPlaceNameInput                = $("[placeholder='Введите название места поиска']"),
            searchPlaceCategoryDropdownTrigger  = $(byText("Выберите категорию")),
            searchPlaceTypeDropDownTrigger      = $(byText("Выберите тип")),
            parameterURI                        = $("input[placeholder='URI']"),
            parameterPort                       = $("input[placeholder='Порт']"),
            parameterLogin                      = $("input[placeholder='Логин']"),
            parameterPassword                   = $("input[placeholder='Пароль']"),
            searchPlaceExcludes                 = $("textarea[placeholder='Введите директорию или имя файла']"),
            searchPlaceCreateNewButton          = $(byText("Создать место поиска"));

    private final ElementsCollection
            searchPlaceCategoryValues           = $$("li[role='option']"),
            searchPlaceTypeValues               = $$("li[role='option']");

    @Step("Заголовок страницы отображает текст")
    public SearchPlaceCreationEditingPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Ввод названия места поиска")
    public SearchPlaceCreationEditingPage inputName(String name){
        searchPlaceNameInput.setValue(name);
        return this;
    }

    @Step("Выбор категории места поиска")
    public SearchPlaceCreationEditingPage selectCategory(String value){
        searchPlaceCategoryDropdownTrigger.click();
        searchPlaceCategoryValues.findBy(text(value)).click();
        return this;
    }

    @Step("Выбор типа места поиска")
    public SearchPlaceCreationEditingPage selectType(String value){
        searchPlaceTypeDropDownTrigger.click();
        searchPlaceTypeValues.findBy(text(value)).click();
        return this;
    }

    @Step("Ввод Параметры - URI")
    public SearchPlaceCreationEditingPage inputUri(String value){
        parameterURI.setValue(value);
        return this;
    }

    @Step("Ввод Параметры - Порт")
    public SearchPlaceCreationEditingPage inputPort(String value){
        parameterPort.setValue(value);
        parameterPort.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Ввод Параметры - Логин")
    public SearchPlaceCreationEditingPage inputLogin(String value){
        parameterLogin.setValue(value);
        return this;
    }

    @Step("Ввод Параметры - Пароль")
    public SearchPlaceCreationEditingPage inputPassword(String value){
        parameterPassword.setValue(value);
        return this;
    }

    @Step("Ввод исключений")
    public SearchPlaceCreationEditingPage inputExcludes(String value){
        searchPlaceExcludes.setValue(value);
        return this;
    }

    @Step("Нажать на кнопку\"Создать место поиска\"")
    public SearchPlaceCreationEditingPage clickCreateNewSearchPlace(){
        searchPlaceCreateNewButton.click();
        return this;
    }

}
