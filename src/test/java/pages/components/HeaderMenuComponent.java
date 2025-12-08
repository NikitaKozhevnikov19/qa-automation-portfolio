package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class HeaderMenuComponent {

    private SelenideElement mainMenu(String href) {
        return $(String.format("header a[href='%s']", href));
    }

    private SelenideElement subMenu(String href) {
        return $(String.format("header a[href='%s']", href));
    }

    private String getMainHref(String name) {
        return switch (name) {
            case "О нас" -> "/company/";
            case "Продукты" -> "/products/";
            case "Карьера" -> "/career/";
            case "Новости" -> "/company/news/";
            case "Контакты" -> "/company/contacts/";
            default -> throw new IllegalArgumentException("Неизвестный пункт верхнего меню: " + name);
        };
    }

    private String getSubHref(String name) {
        return switch (name) {
            case "О компании" -> "/company/";
            case "История" -> "/company/history/";
            case "Команда" -> "/company/team/";
            default -> throw new IllegalArgumentException("Неизвестный подпункт: " + name);
        };
    }

    @Step("Открыть пункт верхнего меню '{main}'")
    public void openMainMenu(String main) {
        String mainHref = getMainHref(main);
        mainMenu(mainHref)
                .shouldBe(Condition.visible)
                .click();
    }

    @Step("Навести на пункт верхнего меню '{main}' и открыть подпункт '{sub}'")
    public void openSubMenu(String main, String sub) {
        String mainHref = getMainHref(main);
        String subHref = getSubHref(sub);
        actions().moveToElement(mainMenu(mainHref)).perform();
        subMenu(subHref)
                .shouldBe(Condition.visible)
                .click();
    }
}
