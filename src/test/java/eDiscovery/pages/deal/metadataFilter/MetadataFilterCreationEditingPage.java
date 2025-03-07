package eDiscovery.pages.deal.metadataFilter;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class MetadataFilterCreationEditingPage {

    public static final String
            HEADER_CREATION_TEXT                        = "Фильтр по метаданным";

    private final SelenideElement
            pageHeader                                  = $("h2"),
            nameInputField                              = $("[placeholder='Введите название фильтра по метаданным']"),
            attributesDropdownTrigger                   = $(byText("Выберите набор атрибутов")),
            attributesCloseDropdownButton               = $("button.p-multiselect-close"),
            attributeFileSizeFromField                  = $x("//span[text()='Размер файла']/parent::label/parent::div//p-inputnumber[@id='minInput']//input"),
            attributeFileSizeToField                    = $x("//span[text()='Размер файла']/parent::label/parent::div//p-inputnumber[@id='maxInput']//input"),
            attributeFileCreationDateFromField          = $x("//span[text()='Дата создания файла']/parent::label/parent::div//p-calendar[@id='fromInput']//input"),
            attributeFileCreationDateToField            = $x("//span[text()='Дата создания файла']/parent::label/parent::div//p-calendar[@id='toInput']//input"),
            attributeFileLocationField                  = $x("//span[text()='Расположение файла']/parent::label/parent::div//textarea"),
            attributeLastFileEditingDateFromField       = $x("//span[text()='Дата последнего редактирования файла']/parent::label/parent::div//p-calendar[@id='fromInput']//input"),
            attributeLastFileEditingDateToField         = $x("//span[text()='Дата последнего редактирования файла']/parent::label/parent::div//p-calendar[@id='toInput']//input"),
            attributeFileName                           = $x("//span[text()='Название файла']/parent::label/parent::div//input"),
            attributeFileTypeDropDownTrigger            = $(byText("Выберите тип данных")),
            attributeFileTypeCloseDropdownButton        = $("button.p-multiselect-close"),
            attributeFileHash                           = $x("//span[text()='Хэш файла']/parent::label/parent::div//textarea"),

            createNewButton                             = $(byText("Создать фильтр по метаданным"));

    private final ElementsCollection
            attributeValues                             = $$("li[pripple]"),
            fileTypeValues                              = $$x("//div[text()='Выберите тип данных']/parent::div/parent::div/p-overlay//ul//li");



    @Step("Заголовок страницы отображает текст")
    public MetadataFilterCreationEditingPage pageHeaderContainsText(String text){
        pageHeader.shouldHave(exactText(text));
        return this;
    }

    @Step("Ввод названия фильтра по метаданным")
    public MetadataFilterCreationEditingPage inputName(String name){
        nameInputField.setValue(name);
        return this;
    }

    @Step("Выбор аттрибута")
    public MetadataFilterCreationEditingPage selectAttribute(String value){
        attributesDropdownTrigger.click();
        attributeValues.findBy(text(value)).click();
        attributesCloseDropdownButton.click();
        return this;
    }

    @Step("Ввод значения Размер файла - От")
    public MetadataFilterCreationEditingPage inputFileSizeFrom(Integer value){
        attributeFileSizeFromField.setValue(String.valueOf(value));
        return this;
    }

    @Step("Ввод значения Размер файла - До")
    public MetadataFilterCreationEditingPage inputFileSizeTo(Integer value){
        attributeFileSizeToField.setValue(String.valueOf(value));
        return this;
    }

    @Step("Ввод значения Дата создания файла - От")
    public MetadataFilterCreationEditingPage inputFileCreationDateFrom(String value){
        attributeFileCreationDateFromField.setValue(value);
        attributeFileCreationDateFromField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Ввод значения Размер файла - От")
    public MetadataFilterCreationEditingPage inputFileCreationDateTo(String value){
        attributeFileCreationDateToField.setValue(value);
        attributeFileCreationDateToField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Ввод значения Расположение файла")
    public MetadataFilterCreationEditingPage inputFileLocation(String value){
        attributeFileLocationField.setValue(value);
        return this;
    }

    @Step("Ввод значения Дата последнего редактирования файла - От")
    public MetadataFilterCreationEditingPage inputLastFileEditingDateFrom(String value){
        attributeLastFileEditingDateFromField.setValue(value);
        attributeLastFileEditingDateFromField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Ввод значения Дата последнего редактирования файла - От")
    public MetadataFilterCreationEditingPage inputLastFileEditingDateTo(String value){
        attributeLastFileEditingDateToField.setValue(value);
        attributeLastFileEditingDateToField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Ввод значения Название файла")
    public MetadataFilterCreationEditingPage inputFileName(String value){
        attributeFileName.setValue(value);
        return this;
    }

    @Step("Выбор значения Тип файла")
    public MetadataFilterCreationEditingPage selectFileType(String value){
        attributeFileTypeDropDownTrigger.click();
        fileTypeValues.findBy(exactText(value)).click();
        attributeFileTypeCloseDropdownButton.click();
        return this;
    }

    @Step("Ввод значения Хэш файла")
    public MetadataFilterCreationEditingPage inputFileHash(String value){
        attributeFileHash.setValue(value);
        return this;
    }

    @Step("нажать на кнопку \"Создать фильтр по метаданным\"")
    public MetadataFilterCreationEditingPage clickCreateNewMetadataFilter(){
        createNewButton.click();
        return this;
    }

}
