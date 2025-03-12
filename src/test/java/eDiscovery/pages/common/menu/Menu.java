package eDiscovery.pages.common.menu;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class  Menu{
    private final SelenideElement
            searchQueryMenuLink             = $(byText("Поисковые запросы")),

            metadataFilterMenuLink          = $(byText("Фильтры по метаданным")),

            searchPlaceMenuFolder           = $x("//span[text()='Места поиска']"),
            searchPlaceMenuLink             = $x("//a[contains(text(), 'Места поиска')]"),
            searchPlaceGroupMenuLink        = $x("//a[contains(text(), 'Группы')]"),

            dealMenuLink                    = $(byText("Дела")),

            categorizationMenuFolder        = $x("//span[text()='Категоризация']"),
            markersMenuLink                 = $x("//a[contains(text(), 'Справочник меток')]"),
            encryptionPermissionMenuLink    = $x("//a[contains(text(), 'Справочник политик шифрования')]"),
            classifierSearchQueryMenuLink   = $x("//a[contains(text(), 'Поисковые запросы')]"),
            rulesMenuLink                   = $x("//a[contains(text(), 'Правила категоризации')]"),
            profilesMenuLink                = $x("//a[contains(text(), 'Профили категоризации')]"),
            markerResultMenuLink            = $x("//a[contains(text(), 'Итоги категоризации')]"),

            agentsMenuLink                  = $(byText("Агенты")),

            administrationMenuFolder        = $x("//span[text()='Администрирование']"),
            systemEventsMenuLink            = $x("//a[contains(text(), 'Системные события')]"),

            settingsMenuFolder              = $x("//span[text()='Настройки']"),
            systemSettingsMenuLink          = $x("//a[contains(text(), 'Системные') and not(contains(text(), 'события'))]"),
            fileTypesMenuLink               = $x("//a[contains(text(), 'Типы файлов')]"),
            fileExtensionsMenuLink          = $x("//a[contains(text(), 'Расширения файлов')]")
            ;

    private Menu unfoldGroup(SelenideElement group){
        SelenideElement rootGroup = group.closest("div[contains(@class,'menu-item')]");
        if (!rootGroup.has(Condition.cssClass("active"))){
            rootGroup.click();
        }
        return this;
    }

    public Menu openSearchQueryListPage(){
        searchQueryMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openMetadataFiltersListPage() {
        metadataFilterMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openSearchPlaceListPage(){
        unfoldGroup(searchPlaceMenuFolder);
        searchPlaceMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openSearchPlaceGroupListPage(){
        unfoldGroup(searchPlaceMenuFolder);
        searchPlaceGroupMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openDealListPage(){
        dealMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openClassifierMarkerListPage(){
        unfoldGroup(categorizationMenuFolder);
        markersMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openClassifierEncryptionPermissionListPage(){
        unfoldGroup(categorizationMenuFolder);
        encryptionPermissionMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openClassifierSearchQueryListPage(){
        unfoldGroup(categorizationMenuFolder);
        classifierSearchQueryMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openClassifierRulesListPage(){
        unfoldGroup(categorizationMenuFolder);
        rulesMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openClassifierProfilesListPage(){
        unfoldGroup(categorizationMenuFolder);
        profilesMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openClassifierMarkerResultListPage(){
        unfoldGroup(categorizationMenuFolder);
        markerResultMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openAgentsListPage(){
        agentsMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openSystemEventsListPage(){
        unfoldGroup(administrationMenuFolder);
        systemEventsMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openSystemSettingsPage(){
        unfoldGroup(settingsMenuFolder);
        systemSettingsMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openFileTypesListPage(){
        unfoldGroup(settingsMenuFolder);
        fileTypesMenuLink.click();
        sleep(500);
        return this;
    }

    public Menu openFileExtensionsListPage(){
        unfoldGroup(settingsMenuFolder);
        fileExtensionsMenuLink.click();
        sleep(500);
        return this;
    }

}
