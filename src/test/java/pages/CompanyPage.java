package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CompanyPage {

    public CompanyPage checkAboutPage() {
        $("h1").shouldHave(text("О компании"));
        $(".company-mission").shouldBe(visible);
        return this;
    }
}
