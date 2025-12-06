package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderMenuComponent {

    private final String menuItem = "header a[href='%s']";
    private final String subMenuItem = "header a[href='%s']";

    public void openMenuItem(String name) {

        // Привязываем текст к URL (это намного надежнее, чем byText)
        String href = switch (name) {
            case "Продукты" -> "/products/";
            case "Компания" -> "/company/";
            case "Карьера" -> "/career/";
            case "Контакты" -> "/contacts/";
            default -> throw new IllegalArgumentException("Неизвестный пункт меню: " + name);
        };

        $(String.format(menuItem, href)).shouldBe(visible).click();
    }

    public void openSubMenu(String main, String sub) {

        openMenuItem(main);
        String href = switch (sub) {
            case "О нас" -> "/company/about/";
            case "Наша история" -> "/company/history/";
            case "Команда" -> "/company/team/";
            default -> throw new IllegalArgumentException("Неизвестный подпункт: " + sub);
        };

        $(String.format(subMenuItem, href)).shouldBe(visible).click();
    }
}
