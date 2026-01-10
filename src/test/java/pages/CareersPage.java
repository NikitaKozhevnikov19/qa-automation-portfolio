package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareersPage {

    private final SelenideElement
            vacanciesLink = $$("a.link").findBy(Condition.text("Вакансии")),
            vacanciesContainer = $(".vcnc-container-fluid");

    private final ElementsCollection vacancyItems = $$(".vcnc-item");

    @Step("Открыть список вакансий")
    public CareersPage openVacancies() {
        vacanciesLink.click();
        return this;
    }

    @Step("Проверить, что вакансии загрузились")
    public CareersPage checkVacanciesLoaded() {
        vacanciesContainer.shouldBe(Condition.visible);
        vacancyItems.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }
}
