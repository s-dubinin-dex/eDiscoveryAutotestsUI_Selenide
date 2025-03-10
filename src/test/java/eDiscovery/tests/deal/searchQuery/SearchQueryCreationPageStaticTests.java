package eDiscovery.tests.deal.searchQuery;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.searchQuery.SearchQueryCreationEditingPage;
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
public class SearchQueryCreationPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final SearchQueryListPage searchQueryListPage = page(SearchQueryListPage.class);
    private static final SearchQueryCreationEditingPage searchQueryCreationEditingPage = page(SearchQueryCreationEditingPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_QUERY_LIST);

        searchQueryListPage
                .clickNewSearchQueryButton();
    }

    @Test
    @Tag("smoke")
    @Feature("Поисковые запросы")
    @Story("Создание поискового запроса")
    @DisplayName("Страница созданиям поискового запроса содержит заголовок")
    @Description("Тест проверяет заголовок на странице создания поискового запроса")
    @Severity(SeverityLevel.NORMAL)
    public void searchQueryCreationPageContainsHeader() {
        searchQueryCreationEditingPage
                .pageHeaderContainsText(SearchQueryCreationEditingPage.HEADER_CREATION_TEXT);
    }

}
