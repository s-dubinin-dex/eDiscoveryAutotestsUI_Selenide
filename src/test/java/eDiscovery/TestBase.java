package eDiscovery;

import com.codeborne.selenide.Configuration;
import eDiscovery.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = System.getProperty("BASE_URL");

        // Конфигурация для удаленного запуска
        Configuration.remote = System.getProperty("url");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "ru");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        options.setExperimentalOption("prefs", prefs);

//        Configuration.browser = System.getProperty("browser");
//        Configuration.browserVersion = System.getProperty("version");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        Configuration.browserCapabilities = capabilities;
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
    }
}
