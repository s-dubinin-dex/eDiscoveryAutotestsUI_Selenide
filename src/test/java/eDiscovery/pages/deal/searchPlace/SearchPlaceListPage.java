package eDiscovery.pages.deal.searchPlace;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPlaceListPage {

    public static final String
            HEADER_LIST_TEXT                    = "Места поиска";

    private final SelenideElement
            pageHeader                          = $("h2"),
            newSearchPlaceButton                 = $(byText("Новое"));

    @Step("Заголовок страницы отображает текст")
    public SearchPlaceListPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Нажать кнопку создания нового места поиска")
    public SearchPlaceListPage clickNewSearchPlaceButton(){
        newSearchPlaceButton.click();
        return this;
    }

}
