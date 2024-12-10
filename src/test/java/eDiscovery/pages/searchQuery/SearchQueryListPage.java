package eDiscovery.pages.searchQuery;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SearchQueryListPage {

    public static String
            HEADER = "Поисковые запросы";

    SelenideElement
            pageHeader = $("h2"),
            newSearchQueryButton = $(byText("Новый"));

    @Step("Нажать кнопку создания нового поискового запроса")
    public SearchQueryCreationEditingPage clickNewSearchQueryButton(){
        newSearchQueryButton.click();
        return page(SearchQueryCreationEditingPage.class);
    }

    @Step("Заголовок страницы отображается")
    public SearchQueryListPage pageHeaderDisplayed(){
        pageHeader.shouldBe(visible);
        return this;
    }

    @Step("Заголовок страницы отображает текст")
    public SearchQueryListPage pageHeaderContainsText(){
        pageHeader.shouldHave(exactText(HEADER));
        return this;
    }
}
