package eDiscovery.tests.deal.searchPlaceGroup;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.entityActionResult.EntityActionResultWindow;
import eDiscovery.pages.deal.searchPlaceGroup.SearchPlaceGroupCreationEditingPage;
import eDiscovery.pages.deal.searchPlaceGroup.SearchPlaceGroupListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static eDiscovery.dataGenerator.DataGeneratorCommon.getRandomName;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Создание групп мест поиска")
public class SearchPlaceGroupCreationTests extends TestBase {

    private static final AuthorizationPage authorizationPage = new AuthorizationPage();
    private static final EntityActionResultWindow entityActionResultWindow = page(EntityActionResultWindow.class);

    SearchPlaceGroupListPage searchPlaceGroupListPage = page(SearchPlaceGroupListPage.class);
    SearchPlaceGroupCreationEditingPage searchPlaceGroupCreationEditingPage = page(SearchPlaceGroupCreationEditingPage.class);

    String searchPlaceGroupName;

    @BeforeEach
    void setUp() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_SEARCH_PLACE_GROUP_LIST);

        searchPlaceGroupName = getRandomName();
    }

    @Test
    @Tag("smoke")
    @Feature("Группы мест поиска")
    @Story("Создание группы мест поиска")
    @DisplayName("Создание группы мест поиска с 1 местом поиска")
    @Description("Тест проверяет возможность создания группы мест поиска с 1 местом поиска")
    @Severity(SeverityLevel.CRITICAL)
    public void searchPlaceGroupWith2SearchPlacesCreationPositiveTest() throws InterruptedException {
        searchPlaceGroupListPage
                .clickNewSearchPlaceGroupButton();

        searchPlaceGroupCreationEditingPage
                .pageHeaderContainsText(SearchPlaceGroupCreationEditingPage.HEADER_CREATION_TEXT)
                .inputName(searchPlaceGroupName)
                .inputDescription(getRandomName())
                .selectSearchPlaceByIndex(0)
                .clickCreateNewSearchPlaceGroup();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Группа мест поиска «%s» успешно добавлена", searchPlaceGroupName));
    }

}
