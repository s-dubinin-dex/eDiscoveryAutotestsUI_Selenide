package eDiscovery.pages.searchQuery;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchQueryPage {

    public static String
            HEADER = "Поисковые запросы";

    SelenideElement
            pageHeader = $("h2");


    public void pageHeaderDisplayed(){
        pageHeader.shouldBe(visible);
    }

    public void pageHeaderContainsText(){
        pageHeader.shouldHave(exactText(HEADER));
    }
}
