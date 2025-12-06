package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CareersPage {

    public CareersPage checkVacanciesLoaded() {
        $(".vcnc-container-fluid").shouldBe(visible);
        $$(".vcnc-vacancy-item").shouldHave(sizeGreaterThan(0));
        return this;
    }
}