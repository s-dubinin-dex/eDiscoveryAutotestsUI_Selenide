package eDiscovery.tests.deal.searchPlace;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.entityActionResult.EntityActionResultWindow;
import eDiscovery.pages.deal.searchPlace.SearchPlaceCreationEditingPage;
import eDiscovery.pages.deal.searchPlace.SearchPlaceListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.dataGenerator.DataGeneratorCommon.getRandomName;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Создание мест поиска")
public class SearchPlaceCreationTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    SearchPlaceListPage searchPlaceListPage = page(SearchPlaceListPage.class);
    SearchPlaceCreationEditingPage searchPlaceCreationEditingPage = page(SearchPlaceCreationEditingPage.class);
    EntityActionResultWindow entityActionResultWindow = page(EntityActionResultWindow.class);

    String searchPlaceName;

    @BeforeEach
    void setUp() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_PLACES_LIST);

        searchPlaceListPage
                .clickNewSearchPlaceButton();

        searchPlaceName = getRandomName();
    }

    @Test
    @Tag("smoke")
    @Feature("Места поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска FileShare - SMB")
    @Description("Тест проверяет возможность создания места поиска FileShare - SMB")
    @Severity(SeverityLevel.CRITICAL)
    public void searchPlaceFileShareSMBCreationPositiveTest() {
        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(searchPlaceName)
                .selectCategory("FileShare")
                .selectType("SMB")
                .inputUri("10.5.0.1")
                .inputLogin("l0g1n")
                .inputPassword("p@ssw0rd")
                .inputExcludes("C:\\\\")
                .clickCreateNewSearchPlace();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Место поиска «%s» успешно добавлено", searchPlaceName));
    }

    @Test
    @Tag("smoke")
    @Feature("Места поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска FileShare - FTP без порта")
    @Description("Тест проверяет возможность создания места поиска FileShare - FTP без порта")
    @Severity(SeverityLevel.CRITICAL)
    public void searchPlaceFileShareFTPWithoutPortCreationPositiveTest() {
        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(searchPlaceName)
                .selectCategory("FileShare")
                .selectType("FTP")
                .inputUri("10.5.0.1")
                .inputLogin("l0g1n")
                .inputPassword("p@ssw0rd")
                .inputExcludes("\\data\\")
                .clickCreateNewSearchPlace();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Место поиска «%s» успешно добавлено", searchPlaceName));
    }

    @Test
    @Tag("smoke")
    @Feature("Места поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска FileShare - FTP с портом")
    @Description("Тест проверяет возможность создания места поиска FileShare - FTP с портом")
    @Severity(SeverityLevel.CRITICAL)
    public void searchPlaceFileShareFTPWithPortCreationPositiveTest() {
        searchPlaceCreationEditingPage
                .pageHeaderContainsText(SearchPlaceCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(searchPlaceName)
                .selectCategory("FileShare")
                .selectType("FTP")
                .inputUri("10.5.0.1")
                .inputPort("21211")
                .inputLogin("l0g1n")
                .inputPassword("p@ssw0rd")
                .inputExcludes("\\data\\")
                .clickCreateNewSearchPlace();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Место поиска «%s» успешно добавлено", searchPlaceName));
    }

}
