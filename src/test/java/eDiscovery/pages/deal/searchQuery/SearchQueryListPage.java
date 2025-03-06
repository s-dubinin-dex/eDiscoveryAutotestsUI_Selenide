package eDiscovery.pages.deal.searchQuery;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchQueryListPage {

    public static final String
            HEADER_LIST_TEXT                = "Поисковые запросы";

    private final SelenideElement
            pageHeader                      = $("h2"),
            newSearchQueryButton            = $(byText("Новый"));

    @Step("Заголовок страницы отображает текст")
    public SearchQueryListPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Нажать кнопку создания нового поискового запроса")
    public SearchQueryListPage clickNewSearchQueryButton(){
        newSearchQueryButton.click();
        return this;
    }

}
