package eDiscovery.tests.deal.searchQuery;

import eDiscovery.TestBase;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.entityActionResult.EntityActionResultWindow;
import eDiscovery.pages.common.menu.Menu;
import eDiscovery.pages.deal.searchQuery.SearchQueryCreationEditingPage;
import eDiscovery.pages.deal.searchQuery.SearchQueryListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.dataGenerator.DataGeneratorCommon.getRandomName;
import static eDiscovery.testData.AdminPanelUsers.Admin;

public class SearchQueryCreationTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    Menu menu = page(Menu.class);
    SearchQueryListPage searchQueryListPage = page(SearchQueryListPage.class);
    SearchQueryCreationEditingPage searchQueryCreationPage = page(SearchQueryCreationEditingPage.class);
    EntityActionResultWindow entityActionResultWindow = page(EntityActionResultWindow.class);

    String searchQueryName;

    @BeforeEach
    void setUp() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password);

        menu
                .openSearchQueryListPage();

        searchQueryListPage
                .pageHeaderContainsText(SearchQueryListPage.HEADER_LIST_TEXT)
                .clickNewSearchQueryButton();

        searchQueryName = getRandomName();
    }

    @ParameterizedTest
    @Tag("smoke")
    @Feature("Поисковый запрос")
    @Story("Создание поискового запроса")
    @DisplayName("Создание поискового запроса")
    @Description("Тест проверяет возможность создания поискового запроса")
    @Severity(SeverityLevel.CRITICAL)
    @CsvSource(value = {
            "Text, selenide",
            "Regex, \\d{10}"
    })
    public void searchQueryWithTextCreationPositiveTest(String searchQueryType, String searchQueryValue){
        searchQueryCreationPage
                .pageHeaderContainsText(SearchQueryCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(searchQueryName)
                .selectType(searchQueryType)
                .inputValue(searchQueryValue)
                .clickCreateNewSearchQuery();
    }

    @AfterEach
    void tearDown() {
        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Поисковый запрос «%s» успешно добавлен", searchQueryName));

        searchQueryListPage
                .pageHeaderContainsText(SearchQueryListPage.HEADER_LIST_TEXT);
    }

}
