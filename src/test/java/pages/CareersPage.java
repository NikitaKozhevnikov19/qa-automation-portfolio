package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareersPage {

    public CareersPage openVacancies() {
        // Нажимаем на ссылку "Вакансии"
        $$("a.link").findBy(text("Вакансии")).click();
        return this;
    }

    public CareersPage checkVacanciesLoaded() {
        // Ждём контейнер блока вакансий
        $(".vcnc-container-fluid").shouldBe(visible);
        // Ждём видимости хотя бы первой вакансии
        $$(".vcnc-item").first().shouldBe(visible);
        // Проверяем, что есть хотя бы одна вакансия
        $$(".vcnc-item").shouldHave(sizeGreaterThan(0));
        return this;
    }
}
