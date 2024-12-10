package eDiscovery.tests;

import eDiscovery.TestBase;
import eDiscovery.data.enums.SearchQueryType;
import eDiscovery.pages.AuthorizationPage;
import eDiscovery.pages.searchQuery.SearchQueryCreationEditingPage;
import eDiscovery.pages.searchQuery.SearchQueryListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static eDiscovery.data.enums.DataGeneratorCommon.getRandomName;

public class SearchQueryPageTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    String login = "test@gmail.com";
    String password = "005";

    @Test
    @Tag("smoke")
    @Feature("Место поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска")
    @Description("Тест проверяет возможность создания места поиска")
    @Severity(SeverityLevel.BLOCKER)
    void searchPlaceWithTextCreationPositiveTest(){
        SearchQueryListPage searchQueryListPage = authorizationPage.openPage().login(login, password);

        SearchQueryCreationEditingPage searchQueryCreationPage = searchQueryListPage
                .clickNewSearchQueryButton();

        searchQueryCreationPage.pageHeaderDisplayed().pageHeaderContainsText();

        searchQueryListPage = searchQueryCreationPage
                .typeName(String.format("Test from Selenide %s", getRandomName()))
                .selectType(SearchQueryType.Text)
                .typeValue("selenide")
                .clickCreateNewSearchQuery();

        searchQueryListPage.pageHeaderDisplayed().pageHeaderContainsText();
    }
}
