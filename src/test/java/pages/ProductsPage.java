package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    public ProductsPage checkProductsLoaded() {
        $(".about__products").shouldBe(visible);
        return this;
    }
}
