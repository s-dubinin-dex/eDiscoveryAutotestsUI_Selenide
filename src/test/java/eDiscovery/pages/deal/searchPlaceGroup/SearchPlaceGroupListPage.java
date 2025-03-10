package eDiscovery.pages.deal.searchPlaceGroup;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPlaceGroupListPage {

    public static final String
            HEADER_LIST_TEXT                    = "Группы мест поиска";

    private final SelenideElement
            pageHeader                          = $("h2"),
            newSearchPlaceGroupButton           = $(byText("Новая"));


    @Step("Заголовок страницы отображает текст")
    public SearchPlaceGroupListPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Нажать кнопку создания нового места поиска")
    public SearchPlaceGroupListPage clickNewSearchPlaceGroupButton(){
        newSearchPlaceGroupButton.click();
        return this;
    }

}
