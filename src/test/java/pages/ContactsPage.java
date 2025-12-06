package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

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

    public ContactsPage checkValidation() {
        $(".form-success, .error").shouldBe(visible);
        return this;
    }
}
