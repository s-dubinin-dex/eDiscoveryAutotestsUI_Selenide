package eDiscovery.tests.deal.metadataFilter;

import eDiscovery.TestBase;
import eDiscovery.helpers.RelativeURL;
import eDiscovery.pages.authorization.AuthorizationPage;
import eDiscovery.pages.common.entityActionResult.EntityActionResultWindow;
import eDiscovery.pages.deal.metadataFilter.MetadataFilterCreationEditingPage;
import eDiscovery.pages.deal.metadataFilter.MetadataFilterListPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static eDiscovery.dataGenerator.DataGeneratorCommon.getRandomName;
import static eDiscovery.testData.AdminPanelUsers.Admin;

@DisplayName("Создание фильтров по метаданным")
public class MetadataFilterCreationTests extends TestBase {

    AuthorizationPage authorizationPage = new AuthorizationPage();
    MetadataFilterListPage metadataFilterListPage = page(MetadataFilterListPage.class);
    MetadataFilterCreationEditingPage metadataFilterCreationEditingPage = page(MetadataFilterCreationEditingPage.class);
    EntityActionResultWindow entityActionResultWindow = page(EntityActionResultWindow.class);

    String metadataFilterName;

    @BeforeEach
    void setUp() {
        authorizationPage
                .openPage()
                .login(Admin.username, Admin.password)
                .authorizationPageDisappear();

        open(RelativeURL.URL_METADATA_FILTERS_LIST);

        metadataFilterListPage
                .clickNewMetadataFilterButton();

        metadataFilterName = getRandomName();
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Размер файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Размер файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithFileSizeAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Размер файла")
                .inputFileSizeFrom(10)
                .inputFileSizeTo(150)
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Дата создания файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Дата создания файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithFileCreationDateAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Дата создания файла")
                .inputFileCreationDateFrom("01.03.2025")
                .inputFileCreationDateTo("05.03.2025")
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Расположение файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Расположение файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithFileLocationAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Расположение файла")
                .inputFileLocation("C:\\\\Windows")
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Дата последнего редактирования файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Дата последнего редактирования файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithLastFileEditingDateAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Дата последнего редактирования файла")
                .inputLastFileEditingDateFrom("01.03.2025")
                .inputLastFileEditingDateTo("05.03.2025")
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Название файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Название файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithFileNameAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Название файла")
                .inputFileName(".*квартальный отчёт.*")
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Тип файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Тип файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithFileTypeAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Тип файла")
                .selectFileType("Presentation")
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

    @Test
    @Tag("smoke")
    @Feature("Фильтры по метаданным")
    @Story("Создание фильтра по метаданным")
    @DisplayName("Создание фильтра по метаданным с аттрибутом Хэш файла")
    @Description("Тест проверяет возможность создания фильтра по метаданным с аттрибутом Хэш файла")
    @Severity(SeverityLevel.CRITICAL)
    public void metadataFilterWithFileHashAttributeCreationPositiveTest() {
        metadataFilterCreationEditingPage
                .inputName(metadataFilterName)
                .selectAttribute("Хэш файла")
                .inputFileHash("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3")
                .clickCreateNewMetadataFilter();

        entityActionResultWindow
                .entityActionResultTextHaveExactText(String.format("Фильтр по метаданным «%s» успешно добавлен", metadataFilterName));
    }

}
