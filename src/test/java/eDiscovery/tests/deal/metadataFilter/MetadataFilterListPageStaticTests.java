package eDiscovery.tests.deal.metadataFilter;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.metadataFilter.MetadataFilterListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы списка фильтров по метаданным")
public class MetadataFilterListPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final MetadataFilterListPage metadataFilterListPage = page(MetadataFilterListPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_METADATA_FILTERS_LIST);
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Список фильтров по метаданным")
    @DisplayName("Список фильтров по метаданным содержит заголовок")
    @Description("Тест проверяет заголовок на странице списка фильтров метаданных")
    @Severity(SeverityLevel.NORMAL)
    public void metadataFilterListPageContainsHeader() {
        metadataFilterListPage
                .pageHeaderContainsText(MetadataFilterListPage.HEADER_LIST_TEXT);
    }

}
