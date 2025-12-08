package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    @Step("Проверить, что продукты загрузились")
    public ProductsPage checkProductsLoaded() {
        $(".about__products").shouldBe(Condition.visible);
        return this;
    }
}
