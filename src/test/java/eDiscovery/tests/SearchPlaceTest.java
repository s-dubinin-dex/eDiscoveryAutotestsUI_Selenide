package eDiscovery.tests;

import eDiscovery.TestBase;
import eDiscovery.pages.AuthorizationPage;
import eDiscovery.pages.SidebarPage;
import eDiscovery.pages.searchPlace.SearchPlaceListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static eDiscovery.data.enums.DataGeneratorCommon.getRandomName;

public class SearchPlaceTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    String login = "test@gmail.com";
    String password = "005";

    @Test
    @Tag("smoke")
    @Feature("Место поиска")
    @Story("Создание места поиска")
    @DisplayName("Создание места поиска")
    @Description("Тест проверяет возможность создания места поиска")
    @Severity(SeverityLevel.BLOCKER)
    void searchPlaceCreationPositiveTest(){
        authorizationPage.openPage().login(login, password);

        SidebarPage sidebarPage = new SidebarPage();

        SearchPlaceListPage searchPlaceListPage = sidebarPage.openSearchPlaceListPage();
    }
}
