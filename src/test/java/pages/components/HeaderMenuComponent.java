package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderMenuComponent {

    public void openMenuItem(String name) {
        $("[data-test='main-menu']").$(byText(name)).click();
    }

    public void openSubMenu(String menu, String sub) {
        $("[data-test='main-menu']").$(byText(menu)).hover();
        $(byText(sub)).click();
    }
}
