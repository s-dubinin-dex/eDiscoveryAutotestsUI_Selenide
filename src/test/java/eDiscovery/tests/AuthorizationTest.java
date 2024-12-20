package eDiscovery.tests;


import eDiscovery.TestBase;
import eDiscovery.pages.AuthorizationPage;
import eDiscovery.pages.searchQuery.SearchQueryListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Авторизация")
class AuthorizationTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    String login = "test@gmail.com";
    String password = "005";

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    void authorizationPositiveTest() {

        SearchQueryListPage searchQueryListPage = authorizationPage.openPage().login(login, password);

        searchQueryListPage.pageHeaderDisplayed().pageHeaderContainsText();
    }

}
