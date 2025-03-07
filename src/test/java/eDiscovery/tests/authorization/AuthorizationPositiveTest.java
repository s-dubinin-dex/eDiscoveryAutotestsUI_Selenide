package eDiscovery.tests.authorization;


import eDiscovery.TestBase;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.searchQuery.SearchQueryListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Авторизация")
class AuthorizationPositiveTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    SearchQueryListPage searchQueryListPage = page(SearchQueryListPage.class);

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    public void authorizationPositiveTest() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password);

        searchQueryListPage.pageHeaderContainsText(SearchQueryListPage.HEADER_LIST_TEXT);
    }

}
