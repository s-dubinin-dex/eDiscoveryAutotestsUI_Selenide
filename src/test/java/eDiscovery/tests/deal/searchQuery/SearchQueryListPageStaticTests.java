package eDiscovery.tests.deal.searchQuery;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.searchQuery.SearchQueryListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы списка поисковых запросов")
public class SearchQueryListPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final SearchQueryListPage searchQueryListPage = page(SearchQueryListPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_QUERY_LIST);
    }

    @Test
    @Tag("smoke")
    @Feature("Поисковые запросы")
    @Story("Список поисковых запросов")
    @DisplayName("Список поисковых запросов содержит заголовок")
    @Description("Тест проверяет заголовок на странице списка поисковых запросов")
    @Severity(SeverityLevel.NORMAL)
    public void searchQueryListPageContainsHeader() {
        searchQueryListPage
                .pageHeaderContainsText(SearchQueryListPage.HEADER_LIST_TEXT);
    }

}
