package eDiscovery.tests.deal.searchPlaceGroup;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.searchPlaceGroup.SearchPlaceGroupListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы списка групп мест поиска")
public class SearchPlaceGroupListPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final SearchPlaceGroupListPage searchPlaceGroupListPage = page(SearchPlaceGroupListPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_PLACE_GROUP_LIST);
    }

    @Test
    @Tag("smoke")
    @Feature("Группы мест поиска")
    @Story("Список групп мест поиска")
    @DisplayName("Список групп мест поиска содержит заголовок")
    @Description("Тест проверяет заголовок на странице списка групп мест поиска")
    @Severity(SeverityLevel.NORMAL)
    public void searchPlaceGroupListPageContainsHeader() {
        searchPlaceGroupListPage
                .pageHeaderContainsText(SearchPlaceGroupListPage.HEADER_LIST_TEXT);
    }

}

