package eDiscovery.pages.deal.metadataFilter;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MetadataFilterListPage {

    public static final String
            HEADER_LIST_TEXT                    = "Фильтры по метаданным";

    private final SelenideElement
            pageHeader                          = $("h2"),
            newMetadataFilterButton             = $(byText("Новый"));


    @Step("Заголовок страницы отображает текст")
    public MetadataFilterListPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Нажать кнопку создания нового фильтра по метаданным")
    public MetadataFilterListPage clickNewMetadataFilterButton(){
        newMetadataFilterButton.click();
        return this;
    }
}
