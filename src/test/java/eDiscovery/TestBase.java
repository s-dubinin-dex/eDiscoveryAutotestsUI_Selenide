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

        String remoteUrl = System.getProperty("url");
        System.out.println(remoteUrl);

        String browser = System.getProperty("browser");
        System.out.println(browser);

        String version = System.getProperty("version");
        System.out.println(version);

        // Конфигурация для удаленного запуска
        Configuration.remote = remoteUrl;

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "ru");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=ru");
        options.setExperimentalOption("prefs", prefs);

        Configuration.browser = browser;
        Configuration.browserVersion = version;

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
