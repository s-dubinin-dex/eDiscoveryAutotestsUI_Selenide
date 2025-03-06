package eDiscovery.tests.deal.searchQuery;

import eDiscovery.TestBase;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.entityActionResult.EntityActionResultWindow;
import eDiscovery.pages.deal.searchQuery.SearchQueryCreationEditingPage;
import eDiscovery.pages.deal.searchQuery.SearchQueryListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.dataGenerator.DataGeneratorCommon.getRandomName;
import static eDiscovery.testData.AdminPanelUsers.Admin;

public class SearchQueryCreationTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    SearchQueryListPage searchQueryListPage = page(SearchQueryListPage.class);
    SearchQueryCreationEditingPage searchQueryCreationPage = page(SearchQueryCreationEditingPage.class);
    EntityActionResultWindow entityActionResultWindow = page(EntityActionResultWindow.class);

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
    void searchQueryWithTextCreationPositiveTest(String searchQueryType, String searchQueryValue){
        String searchQueryName = getRandomName();

        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password);

        searchQueryListPage
                .clickNewSearchQueryButton();

        searchQueryCreationPage
                .pageHeaderContainsText(SearchQueryCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(searchQueryName)
                .selectType(searchQueryType)
                .inputValue(searchQueryValue)
                .clickCreateNewSearchQuery();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Поисковый запрос «%s» успешно добавлен", searchQueryName));

        searchQueryListPage
                .pageHeaderContainsText(SearchQueryListPage.HEADER_LIST_TEXT);
    }

}
