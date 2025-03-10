package eDiscovery.tests.deal.metadataFilter;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.deal.metadataFilter.MetadataFilterCreationEditingPage;
import eDiscovery.pages.deal.metadataFilter.MetadataFilterListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Проверка страницы создания фильтров по метаданным")
public class MetadataFilterCreationPageStaticTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final MetadataFilterListPage metadataFilterListPage = page(MetadataFilterListPage.class);
    private static final MetadataFilterCreationEditingPage metadataFilterCreationEditingPage = page(MetadataFilterCreationEditingPage.class);

    @BeforeAll
    static void beforeAll() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_METADATA_FILTERS_LIST);

        metadataFilterListPage
                .clickNewMetadataFilterButton();
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Страница создания фильтра по метаданным содержит заголовок")
    @Description("Тест проверяет заголовок на странице создания фильтра по метаданным")
    @Severity(SeverityLevel.NORMAL)
    public void metadataFilterCreationPageContainsHeader() {
        metadataFilterCreationEditingPage
                .pageHeaderContainsText(MetadataFilterCreationEditingPage.HEADER_CREATION_TEXT);
    }

}
