package eDiscovery;

import com.codeborne.selenide.Configuration;
import eDiscovery.helpers.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriverManager.chromedriver().setup();

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = System.getProperty("BASE_URL");

        String remoteUrl = System.getProperty("REMOTE_URL");

        if (remoteUrl != null){
            Configuration.remote = remoteUrl;
        }

        ChromeOptions options = new ChromeOptions();
        options.setCapability("se:options", Map.of(
                "enableVNC", true,
                "enableVideo", false
        ));

        options.setExperimentalOption("prefs", Map.of("intl.accept_languages", "ru"));

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
