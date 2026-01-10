package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private final SelenideElement
            logo = $("a.logo"),
            cookieAcceptButton = $("button.cookie-policy__accept");

    @Step("Открыть главную страницу")
    public HomePage openPage() {
        open("/");
        closeCookiesIfPresent();
        logo.shouldBe(Condition.visible);
        return this;
    }

    @Step("Закрыть окно с cookies, если присутствует")
    public HomePage closeCookiesIfPresent() {
        if (cookieAcceptButton.exists()) {
            cookieAcceptButton.click();
        }
        return this;
    }

    @Step("Проверить, что домашняя страница открылась")
    public HomePage checkHomePageIsOpened() {
        logo.shouldHave(Condition.attribute("href", "https://www.naumen.ru/"));
        return this;
    }
}
