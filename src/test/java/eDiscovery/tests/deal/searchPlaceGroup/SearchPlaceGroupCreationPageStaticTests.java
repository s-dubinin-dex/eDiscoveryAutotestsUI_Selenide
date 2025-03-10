package eDiscovery.tests.deal.searchPlaceGroup;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.searchPlaceGroup.SearchPlaceGroupCreationEditingPage;
import eDiscovery.pages.deal.searchPlaceGroup.SearchPlaceGroupListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы списка мест поиска")
public class SearchPlaceGroupCreationPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final SearchPlaceGroupListPage searchPlaceGroupListPage = page(SearchPlaceGroupListPage.class);
    private static final SearchPlaceGroupCreationEditingPage searchPlaceGroupCreationEditingPage = page(SearchPlaceGroupCreationEditingPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_PLACE_GROUP_LIST);

        searchPlaceGroupListPage
                .clickNewSearchPlaceGroupButton();
    }

    @Test
    @Tag("smoke")
    @Feature("Группы мест поиска")
    @Story("Создание группы мест поиска")
    @DisplayName("Страница создания группы мест поиска содержит заголовок")
    @Description("Тест проверяет заголовок на странице создания группы мест поиска")
    @Severity(SeverityLevel.NORMAL)
    public void searchPlaceGroupCreationPageContainsHeader() {
        searchPlaceGroupCreationEditingPage
                .pageHeaderContainsText(SearchPlaceGroupCreationEditingPage.HEADER_CREATION_TEXT);
    }
}
