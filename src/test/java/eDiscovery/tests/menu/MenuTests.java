package eDiscovery.tests.menu;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.menu.Menu;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static eDiscovery.helpers.RelativeURL.getFullUrl;
import static eDiscovery.testData.AdminPanelUsers.Admin;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка перехода по страницам из меню")
public class MenuTests extends TestBase {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    Menu menu = page(Menu.class);

    @BeforeEach
    void setUp() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Поисковые запросы")
    @Story("Поисковые запросы")
    @DisplayName("Переход на страницу поисковых запросов из меню")
    @Description("Тест проверяет переход на страницу поисковых запросов из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenSearchPlaceListTest() {
        menu
                .openSearchQueryListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_SEARCH_QUERY_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Фильтры по метаданным")
    @Story("Фильтры по метаданным")
    @DisplayName("Переход на страницу фильтров метаданных из меню")
    @Description("Тест проверяет переход на страницу фильтров метаданных из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenMetadataFiltersListTest() {
        menu
                .openMetadataFiltersListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_METADATA_FILTERS_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Места поиска")
    @Story("Места поиска")
    @DisplayName("Переход на страницу мест поиска из меню")
    @Description("Тест проверяет переход на страницу мест поиска из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenSearchPlacesListTest() {
        menu
                .openSearchPlaceListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_SEARCH_PLACES_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Места поиска")
    @Story("Группы мест поиска")
    @DisplayName("Переход на страницу групп мест поиска из меню")
    @Description("Тест проверяет переход на страницу групп мест поиска из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenSearchPlaceGroupsListTest() {
        menu
                .openSearchPlaceGroupListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_SEARCH_PLACE_GROUP_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Дела")
    @Story("Дела")
    @DisplayName("Переход на страницу дел из меню")
    @Description("Тест проверяет переход на страницу дел из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenDealListTest() {
        menu
                .openDealListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_DEAL_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Категоризация")
    @Story("Справочник меток")
    @DisplayName("Переход на страницу справочника меток из меню")
    @Description("Тест проверяет переход на страницу справочника меток из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenClassifierMarkerListTest() {
        menu
                .openClassifierMarkerListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_CLASSIFIER_MARKER_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Категоризация")
    @Story("Справочник политик шифрования")
    @DisplayName("Переход на страницу справочника политик шифрования из меню")
    @Description("Тест проверяет переход на страницу справочника политик шифрования из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenClassifierEncryptionPermissionListTest() {
        menu
                .openClassifierEncryptionPermissionListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_CLASSIFIER_ENCRYPTION_PERMISSION_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Категоризация")
    @Story("Поисковые запросы")
    @DisplayName("Переход на страницу категоризация - поисковые запросы из меню")
    @Description("Тест проверяет переход на страницу категоризация - поисковые запросы из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenClassifierSearchQueryListTest() {
        menu
                .openClassifierSearchQueryListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_CLASSIFIER_SEARCH_QUERY_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Категоризация")
    @Story("Правила категоризации")
    @DisplayName("Переход на страницу правила категоризации из меню")
    @Description("Тест проверяет переход на страницу правила категоризации из меню")
    @Severity(SeverityLevel.NORMAL)
    public void menuOpenClassifierRulesListTest() {
        menu
                .openClassifierRulesListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_CLASSIFIER_RULES_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Категоризация")
    @Story("Профили категоризации")
    @DisplayName("Переход на страницу профили категоризации из меню")
    @Description("Тест проверяет переход на страницу профили категоризации из меню")
    public void menuOpenClassifierProfilesListTest() {
        menu
                .openClassifierProfilesListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_CLASSIFIER_PROFILES_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Категоризация")
    @Story("Итоги категоризации")
    @DisplayName("Переход на страницу итоги категоризации из меню")
    @Description("Тест проверяет переход на страницу итоги категоризации из меню")
    public void menuOpenClassifierMarkerResultListTest() {
        menu
                .openClassifierMarkerResultListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_CLASSIFIER_MARKER_RESULT_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Агенты")
    @Story("Агенты")
    @DisplayName("Переход на страницу агенты из меню")
    @Description("Тест проверяет переход на страницу агенты из меню")
    public void menuOpenAgentsListTest() {
        menu
                .openAgentsListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_AGENTS_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Администрирование")
    @Story("Системные события")
    @DisplayName("Переход на страницу системные события из меню")
    @Description("Тест проверяет переход на страницу системные события из меню")
    public void menuOpenSystemEventsListTest() {
        menu
                .openSystemEventsListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_SYSTEM_EVENTS_LIST));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Настройки")
    @Story("Системные")
    @DisplayName("Переход на страницу настройки - системные из меню")
    @Description("Тест проверяет переход на страницу настройки - системные из меню")
    public void menuOpenSystemSettingsTest() {
        menu
                .openSystemSettingsPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_SYSTEM_SETTINGS));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Настройки")
    @Story("Типы файлов")
    @DisplayName("Переход на страницу типы файлов из меню")
    @Description("Тест проверяет переход на страницу типы файлов из меню")
    public void menuOpenFileTypesListTest() {
        menu
                .openFileTypesListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_FILE_TYPES));
    }

    @Test
    @Tag("smoke")
    @Epic("Меню")
    @Feature("Настройки")
    @Story("Расширения файлов")
    @DisplayName("Переход на страницу расширения файлов из меню")
    @Description("Тест проверяет переход на страницу расширения файлов из меню")
    public void menuOpenFileExtensionsListTest() {
        menu
                .openFileExtensionsListPage();

        assertThat(url()).isEqualTo(getFullUrl(RelativeURL.URL_FILE_EXTENSIONS));
    }

}
