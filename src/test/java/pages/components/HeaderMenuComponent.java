package pages.components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HeaderMenuComponent {

    private final String selector = "header a[href='%s']";

    @Step("Открыть пункт меню '{name}'")
    public void openMenuItem(String name) {

        String href = switch (name) {
            case "Продукты" -> "/products/";
            case "Компания" -> "/company/";
            case "Карьера" -> "/career/";
            case "Контакты" -> "/company/contacts/";
            default -> throw new IllegalArgumentException("Неизвестный пункт меню: " + name);
        };

        $(String.format(selector, href)).shouldBe(Condition.visible).click();
    }

    @Step("Открыть подпункт '{sub}' в меню '{main}'")
    public void openSubMenu(String main, String sub) {

        openMenuItem(main);

        String href = switch (sub) {
            case "О нас" -> "/company/about/";
            case "Наша история" -> "/company/history/";
            case "Команда" -> "/company/team/";
            default -> throw new IllegalArgumentException("Неизвестный подпункт: " + sub);
        };

        $(String.format(selector, href)).shouldBe(Condition.visible).click();
    }
}
