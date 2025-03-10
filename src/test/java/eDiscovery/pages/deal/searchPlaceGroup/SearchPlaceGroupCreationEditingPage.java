package eDiscovery.pages.deal.searchPlaceGroup;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchPlaceGroupCreationEditingPage {

    public static final String
            HEADER_CREATION_TEXT                = "Новая группа";

    private final SelenideElement
            pageHeader                          = $("h2"),
            nameInput                           = $("input[placeholder='Введите название группы']"),
            descriptionInput                    = $("textarea[placeholder='Введите описание группы мест поиска"),
            createNewButton                     = $(byText("Создать группу")),
            searchPlaceDropDownTrigger          = $x("//div[contains(text(), 'Выберите места поиска')]"),
            searchPlaceSearchInput              = $("input[role='textbox']"),
            searchPlaceCloseSearchButton        = $("p-multiselect[formcontrolname='searchPlaces'] button[class*='p-multiselect-close']");

    private final ElementsCollection
            searchPlacesList                    = $$x("//ul[@role='listbox']//li");

    @Step("Заголовок страницы отображает текст")
    public SearchPlaceGroupCreationEditingPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Ввод название группы мест поиска")
    public SearchPlaceGroupCreationEditingPage inputName(String value){
        nameInput.setValue(value);
        return this;
    }

    @Step("Ввод описания группы мест поиска")
    public SearchPlaceGroupCreationEditingPage inputDescription(String value){
        descriptionInput.setValue(value);
        return this;
    }

    @Step("Выбрать место поиска")
    public SearchPlaceGroupCreationEditingPage selectSearchPlaceByIndex(Integer index) {
        searchPlaceDropDownTrigger.shouldBe(clickable).click();
        searchPlacesList.get(index).click();
        searchPlaceCloseSearchButton.shouldBe(clickable).click();
        return this;
    }

    @Step("Выбрать место поиска")
    public SearchPlaceGroupCreationEditingPage selectSearchPlace(String value){
        searchPlaceDropDownTrigger.shouldBe(clickable).click();
        searchPlacesList.findBy(exactText(value)).click();
        searchPlaceCloseSearchButton.shouldBe(clickable).click();
        return this;
    }

    @Step("Нажать на кнопку\"Создать группу\"")
    public SearchPlaceGroupCreationEditingPage clickCreateNewSearchPlaceGroup(){
        createNewButton.click();
        return this;
    }

}
