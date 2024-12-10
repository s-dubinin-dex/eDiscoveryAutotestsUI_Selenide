package eDiscovery.pages.searchQuery;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import eDiscovery.data.enums.SearchQueryType;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchQueryCreationEditingPage {

    public static String
            HEADER = "Новый поисковый запрос";

    SelenideElement
            pageHeader = $("h2"),
            nameInput = $("[placeholder='Введите название поискового запроса']"),
            searchQueryTypeDropdown = $(".p-dropdown-trigger"),
            searchQueryValueInput = $("[placeholder='Введите значение поискового запроса']"),
            searchQueryCreateNewButton = $(byText("Создать поисковый запрос"));

    ElementsCollection
            searchQueryValues = $$(".p-dropdown-item");

    @Step("Ввод названия поискового запроса")
    public SearchQueryCreationEditingPage typeName(String value){
        nameInput.setValue(value);
        return this;
    }

    @Step("Выбор типа поискового запроса")
    public SearchQueryCreationEditingPage selectType(SearchQueryType value){
        searchQueryTypeDropdown.click();
        searchQueryValues.findBy(text(value.name())).click();
        return this;
    }

    @Step("Ввод значения поискового запроса")
    public SearchQueryCreationEditingPage typeValue(String value){
        searchQueryValueInput.setValue(value);
        return this;
    }

    @Step("Нажать на кнопку\"Создать поисковый запрос\"")
    public SearchQueryListPage clickCreateNewSearchQuery(){
        searchQueryCreateNewButton.click();
        return page(SearchQueryListPage.class);
    }

    @Step("Заголовок страницы отображается")
    public SearchQueryCreationEditingPage pageHeaderDisplayed(){
        pageHeader.shouldBe(visible);
        return this;
    }

    @Step("Заголовок страницы отображает текст")
    public SearchQueryCreationEditingPage pageHeaderContainsText(){
        pageHeader.shouldHave(exactText(HEADER));
        return this;
    }

}
