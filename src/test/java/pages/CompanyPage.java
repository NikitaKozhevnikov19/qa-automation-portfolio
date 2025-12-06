package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CompanyPage {

    private final SelenideElement companyLink = $("a[href='/company/']");
    private final SelenideElement sliderHeader = $(".slider_block__item__title");
    private final SelenideElement aboutBlock = $(".about");

    public CompanyPage openAboutPage() {
        actions().moveToElement(companyLink).perform();
        companyLink.shouldBe(visible).click();
        return this;
    }

    public CompanyPage checkAboutPage() {
        sliderHeader.shouldHave(text("О компании"));
        aboutBlock.shouldBe(visible);
        return this;
    }
}
