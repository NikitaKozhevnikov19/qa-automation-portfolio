package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CareersPage {

    public CareersPage checkVacanciesLoaded() {
        $(".vacancies-list").shouldBe(visible);
        return this;
    }
}
