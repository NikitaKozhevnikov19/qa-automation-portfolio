package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CompanyPage {

    private final SelenideElement companyLink = $("a[href='/company/']");
    private final SelenideElement header = $("h1");
    private final SelenideElement aboutBlock = $(".about");


    public CompanyPage openAboutPage() {
        actions().moveToElement(companyLink).perform();
        companyLink.shouldBe(visible).click();
        return this;
    }


    public CompanyPage checkAboutPage() {
        header.shouldHave(text("О компании"));
        aboutBlock.shouldBe(visible);
        return this;
    }
}

