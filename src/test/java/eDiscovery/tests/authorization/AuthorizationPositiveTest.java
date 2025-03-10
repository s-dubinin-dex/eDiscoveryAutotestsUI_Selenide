package eDiscovery.tests.authorization;


import eDiscovery.TestBase;
import eDiscovery.pages.authorization.AuthorizationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Авторизация")
class AuthorizationPositiveTest extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @Tag("smoke")
    @Feature("Авторизация")
    @Story("Авторизация")
    @DisplayName("Авторизация с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    public void authorizationPositiveTest() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();
    }

}
