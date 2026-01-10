package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    private final SelenideElement productsBlock = $(".about__products");

    @Step("Проверить, что продукты загрузились")
    public ProductsPage checkProductsLoaded() {
        productsBlock.shouldBe(Condition.visible);
        return this;
    }
}
