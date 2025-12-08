package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    @Step("Открыть главную страницу")
    public HomePage openPage() {
        open("/");
        closeCookiesIfPresent();
        $("a.logo").shouldBe(Condition.visible);
        return this;
    }

    @Step("Закрыть окно с cookies, если присутствует")
    public HomePage closeCookiesIfPresent() {
        if ($("button.cookie-policy__accept").exists()) {
            $("button.cookie-policy__accept").click();
        }
        return this;
    }

    @Step("Проверить, что домашняя страница открылась")
    public HomePage checkHomePageIsOpened() {
        $("a.logo").shouldHave(Condition.attribute("href", "https://www.naumen.ru/"));
        return this;
    }
}
