package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CompanyPage {

    private final SelenideElement sliderHeader = $(".slider_block__item__title");
    private final SelenideElement aboutBlock = $(".about");

    @Step("Проверить, что заголовок с текстом '{expectedTitle}' отображается")
    public CompanyPage checkSliderHeader(String expectedTitle) {
        sliderHeader.shouldHave(Condition.text(expectedTitle));
        return this;
    }

    @Step("Проверить видимость блока '{blockName}'")
    public CompanyPage checkBlockVisible(SelenideElement block, String blockName) {
        block.shouldBe(Condition.visible);
        return this;
    }

    public SelenideElement getAboutBlock() {
        return aboutBlock;
    }
}
