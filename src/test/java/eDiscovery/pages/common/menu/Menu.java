package eDiscovery.pages.common.menu;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class  Menu{
    private final SelenideElement
            searchQueryLink                 = $(byText("Поисковые запросы")),

            metadataFilterMenuLink          = $(byText("Фильтры по метаданным")),

            searchPlaceMenuFolder           = $x("//span[text()='Места поиска']"),
            searchPlaceMenuLink             = $x("//a[contains(text(), 'Места поиска')]"),
            searchPlaceGroupMenuLink        = $(byLinkText("Группы мест поиска"))

            ;

    public Menu openSearchQueryListPage(){
        searchQueryLink.click();
        return this;
    }

    public Menu openMetadataFiltersListPage() {
        metadataFilterMenuLink.click();
        return this;
    }

    public Menu openSearchPlaceListPage(){
        searchPlaceMenuFolder.click();
        searchPlaceMenuLink.click();
        return this;
    }

}
