package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ContactsPage {

    public ContactsPage fillContactForm(String name, String email, String text) {
        $("#contact-name").setValue(name);
        $("#contact-email").setValue(email);
        $("#contact-message").setValue(text);
        return this;
    }

    public ContactsPage submitForm() {
        $("#contact-submit").click();
        return this;
    }

    // Проверка успешной отправки (позитивный тест)
    public ContactsPage checkValidation() {
        $(".form-success").shouldBe(visible);
        return this;
    }

    // Проверка ошибок валидации (негативный тест)
    public ContactsPage checkValidationErrors() {
        $$(".error").shouldHave(sizeGreaterThan(0)); // хотя бы один элемент ошибки
        return this;
    }
}
