package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CompanyPage {

    @Step("Проверить, что заголовок содержит текст: {expected}")
    public CompanyPage checkHeaderContains(String expected) {
        $(".slider_block__item__title").shouldHave(Condition.text(expected));
        return this;
    }

    @Step("Проверить, что блок 'О компании' отображается")
    public CompanyPage checkAboutBlockVisible() {
        $(".about").shouldBe(Condition.visible);
        return this;
    }
}
