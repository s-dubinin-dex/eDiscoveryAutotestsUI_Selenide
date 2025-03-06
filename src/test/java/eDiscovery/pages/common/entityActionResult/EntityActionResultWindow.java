package eDiscovery.pages.common.entityActionResult;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class EntityActionResultWindow {

    private final SelenideElement entityActionResultText = $("div[data-pc-section='detail']");

    public EntityActionResultWindow entityActionResultTextHaveExactText(String text){
        entityActionResultText.shouldHave(exactText(text));
        return this;
    }

}
