package eDiscovery.pages.deal.searchQuery;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchQueryCreationEditingPage {

    public static final String
            HEADER_CREATION_TEXT                = "Новый поисковый запрос";

    private final SelenideElement
            pageHeader                          = $("h2"),
            searchQueryNameInput                = $("[placeholder='Введите название поискового запроса']"),
            searchQueryTypeDropdownTrigger      = $(".p-dropdown-trigger"),
            searchQueryValueInput               = $("[placeholder='Введите значение поискового запроса']"),
            searchQueryCreateNewButton          = $(byText("Создать поисковый запрос"));

    private final ElementsCollection
            searchQueryTypeValues               = $$("p-dropdownitem");

    @Step("Заголовок страницы отображает текст")
    public SearchQueryCreationEditingPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Ввод названия поискового запроса")
    public SearchQueryCreationEditingPage inputName(String value){
        searchQueryNameInput.setValue(value);
        return this;
    }

    @Step("Выбор типа поискового запроса")
    public SearchQueryCreationEditingPage selectType(String value){
        searchQueryTypeDropdownTrigger.click();
        searchQueryTypeValues.findBy(text(value)).click();
        return this;
    }

    @Step("Ввод значения поискового запроса")
    public SearchQueryCreationEditingPage inputValue(String value){
        searchQueryValueInput.setValue(value);
        return this;
    }

    @Step("Нажать на кнопку\"Создать поисковый запрос\"")
    public SearchQueryCreationEditingPage clickCreateNewSearchQuery(){
        searchQueryCreateNewButton.click();
        return this;
    }

}
