package eDiscovery.tests.deal.searchPlace;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;

import eDiscovery.pages.deal.searchPlace.SearchPlaceListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы списка мест поиска")
public class SearchPlaceListPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final SearchPlaceListPage searchPlaceListPage = page(SearchPlaceListPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_PLACES_LIST);
    }

    @Test
    @Tag("smoke")
    @Feature("Места поиска")
    @Story("Список мест поиска")
    @DisplayName("Список мест поиска содержит заголовок")
    @Description("Тест проверяет заголовок на странице списка мест поиска")
    @Severity(SeverityLevel.NORMAL)
    public void searchPlaceListPageContainsHeader() {
        searchPlaceListPage
                .pageHeaderContainsText(SearchPlaceListPage.HEADER_LIST_TEXT);
    }
}
