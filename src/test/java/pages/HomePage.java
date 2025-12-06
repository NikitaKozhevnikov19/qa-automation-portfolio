package pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public HomePage openPage() {
        open("/");
        closeCookiesIfPresent();
        $("a.logo").shouldBe(visible);
        return this;
    }

    public HomePage checkLogo() {
        $("a.logo").shouldBe(visible)
                .shouldHave(attribute("href", "/"));
        return this;
    }

    public HomePage closeCookiesIfPresent() {
        if ($("button.cookie-policy__accept").exists()) {
            $("button.cookie-policy__accept").shouldBe(visible).click();
        }
        return this;
    }
}
