package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class HeaderMenuComponent {

    private SelenideElement mainMenu(String href) {
        return $("header a[href='" + href + "']");
    }

    private SelenideElement subMenu(String href) {
        return $("header li.opened").$$("a")
                .findBy(Condition.attribute("href", href));
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
            case "Контакты" -> "/company/contacts/";
            case "История" -> "/company/history/";
            case "Команда" -> "/company/team/";
            default -> throw new IllegalArgumentException("Неизвестный подпункт меню: " + name);
        };
    }

    @Step("Навести курсор на верхний пункт меню '{main}'")
    public HeaderMenuComponent hoverMainMenu(String main) {
        String href = getMainHref(main);
        actions().moveToElement(mainMenu(href)).perform();
        return this;
    }

    @Step("Открыть верхний пункт меню '{main}'")
    public void openMain(String main) {
        String href = getMainHref(main);
        mainMenu(href).shouldBe(Condition.visible).click();
    }

    @Step("Открыть подпункт меню '{sub}' из верхнего пункта '{main}'")
    public void openSubMenu(String main, String sub) {
        hoverMainMenu(main);
        String subHref = getSubHref(sub);
        subMenu(subHref)
                .shouldBe(Condition.visible, Duration.ofSeconds(5))
                .click();
    }
}
