package eDiscovery.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import eDiscovery.pages.searchPlace.SearchPlaceListPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SidebarPage {
    SelenideElement
            searchQueryLink = $(byText("Поисковые запросы")),

            searchPlaceMenuGroupLink = $(byXpath("//span[text()='Места поиска']")),
            searchPlaceLink = $(byLinkText("Места поиска")),
            searchPlaceGroupLink = $(byLinkText("Группы мест поиска"))

            ;

    public SearchPlaceListPage openSearchPlaceListPage(){
        searchPlaceMenuGroupLink.click();
        searchPlaceLink.shouldBe(Condition.visible).click();
        return page(SearchPlaceListPage.class);
    }
}
