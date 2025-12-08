package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareersPage {

    @Step("Открыть список вакансий")
    public CareersPage openVacancies() {
        $$("a.link").findBy(Condition.text("Вакансии")).click();
        return this;
    }

    @Step("Проверить, что вакансии загрузились")
    public CareersPage checkVacanciesLoaded() {
        $(".vcnc-container-fluid").shouldBe(Condition.visible);
        $$(".vcnc-item").shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }
}
