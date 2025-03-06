package eDiscovery.tests.deal.searchPlace;

import eDiscovery.TestBase;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.menu.Menu;
import eDiscovery.pages.deal.searchPlace.SearchPlaceCreationEditingPage;
import eDiscovery.pages.deal.searchPlace.SearchPlaceListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.dataGenerator.DataGeneratorCommon.getRandomName;
import static eDiscovery.testData.AdminPanelUsers.Admin;

public class SearchPlaceCreationTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    Menu menu = page(Menu.class);
    SearchPlaceListPage searchPlaceListPage = page(SearchPlaceListPage.class);
    SearchPlaceCreationEditingPage searchPlaceCreationEditingPage = page(SearchPlaceCreationEditingPage.class);

    @Test
    @Tag("smoke")
    @Feature("Место поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска FileShare - SMB")
    @Description("Тест проверяет возможность создания места поиска FileShare - SMB")
    @Severity(SeverityLevel.BLOCKER)
    void searchPlaceFileShareSMBCreationPositiveTest() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password);

        menu
                .openSearchPlaceListPage();

        searchPlaceListPage
                .clickNewSearchPlaceButton();

        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(String.format("Test from Selenide %s", getRandomName()))
                .selectCategory("FileShare")
                .selectType("SMB")
                .inputUri("10.5.0.1")
                .inputLogin("l0g1n")
                .inputPassword("p@ssw0rd")
                .inputExcludes("C:\\\\")
                .clickCreateNewSearchPlace();

        searchPlaceListPage.pageHeaderContainsText(SearchPlaceListPage.HEADER_LIST_TEXT);
    }

    @Test
    @Tag("smoke")
    @Feature("Место поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска FileShare - FTP без порта")
    @Description("Тест проверяет возможность создания места поиска FileShare - FTP без порта")
    @Severity(SeverityLevel.BLOCKER)
    void searchPlaceFileShareFTPWithoutPortCreationPositiveTest() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password);

        menu
                .openSearchPlaceListPage();

        searchPlaceListPage
                .clickNewSearchPlaceButton();

        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(String.format("Test from Selenide %s", getRandomName()))
                .selectCategory("FileShare")
                .selectType("FTP")
                .inputUri("10.5.0.1")
                .inputLogin("l0g1n")
                .inputPassword("p@ssw0rd")
                .inputExcludes("\\data\\")
                .clickCreateNewSearchPlace();

        searchPlaceListPage.pageHeaderContainsText(SearchPlaceListPage.HEADER_LIST_TEXT);
    }

    @Test
    @Tag("smoke")
    @Feature("Место поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска FileShare - FTP с портом")
    @Description("Тест проверяет возможность создания места поиска FileShare - FTP с портом")
    @Severity(SeverityLevel.BLOCKER)
    void searchPlaceFileShareFTPWithPortCreationPositiveTest() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password);

        menu
                .openSearchPlaceListPage();

        searchPlaceListPage
                .clickNewSearchPlaceButton();

        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(String.format("Test from Selenide %s", getRandomName()))
                .selectCategory("FileShare")
                .selectType("FTP")
                .inputUri("10.5.0.1")
                .inputPort("21211")
                .inputLogin("l0g1n")
                .inputPassword("p@ssw0rd")
                .inputExcludes("\\data\\")
                .clickCreateNewSearchPlace();

        searchPlaceListPage.pageHeaderContainsText(SearchPlaceListPage.HEADER_LIST_TEXT);
    }

}
