package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private SelenideElement yearPicker = $(".react-datepicker__year-select"),
            monthPicker = $(".react-datepicker__month-select");

    public void setDate(String day, String month, String year) {
        yearPicker.selectOption(year);
        monthPicker.selectOption(month);


        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .shouldBe(sizeGreaterThan(0));

        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(Condition.text(String.valueOf(Integer.parseInt(day))))
                .shouldBe(Condition.visible)
                .click();
    }
}
