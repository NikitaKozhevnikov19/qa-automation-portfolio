package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public HomePage openPage() {
        open("/");
        $("[data-test='main-slider']").shouldBe(visible);
        return this;
    }

    public HomePage checkMainTitle() {
        $("h1").shouldHave(text("NAUMEN"));
        return this;
    }
}
