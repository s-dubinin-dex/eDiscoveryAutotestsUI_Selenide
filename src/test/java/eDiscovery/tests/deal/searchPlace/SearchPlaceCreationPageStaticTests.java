package eDiscovery.tests.deal.searchPlace;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.searchPlace.SearchPlaceCreationEditingPage;
import eDiscovery.pages.deal.searchPlace.SearchPlaceListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы создания мест поиска")
public class SearchPlaceCreationPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final SearchPlaceListPage searchPlaceListPage = page(SearchPlaceListPage.class);
    private static final SearchPlaceCreationEditingPage searchPlaceCreationEditingPage = page(SearchPlaceCreationEditingPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_PLACES_LIST);

        searchPlaceListPage
                .clickNewSearchPlaceButton();
    }

    @Test
    @Tag("smoke")
    @Feature("Места поиска")
    @Story("Создание места поиска")
    @DisplayName("Страница создания места поиска содержит заголовок")
    @Description("Тест проверяет заголовок на странице создания места поиска")
    @Severity(SeverityLevel.NORMAL)
    public void searchPlaceCreationPageContainsHeader() {
        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT);
    }

}
