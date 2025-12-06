package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ContactsPage {

    private final SelenideElement nameInput = $("input[placeholder='Фамилия, Имя']");
    private final SelenideElement emailInput = $("input[placeholder='E-mail']");
    private final SelenideElement phoneInput = $("input[data-name='phone']");
    private final SelenideElement companyNameInput = $("input[placeholder='Название компании']");
    private final SelenideElement messageInput = $("textarea[placeholder='Ваш вопрос']");
    private final SelenideElement topicDropdown = $(".dropdown-box");
    private final SelenideElement agreeCheckbox = $("#form_checkbox_agree_59_6238");
    private final SelenideElement reklamaCheckbox = $("#form_checkbox_reklama_agree_59_6239");
    private final SelenideElement submitButton = $("input[type='submit'][value='Отправить']");
    private final SelenideElement successMessage = $(".form-success");

    public ContactsPage openContactsPage() {
        open("/company/contacts/");
        return this;
    }

    public ContactsPage setName(String name) {
        nameInput.setValue(name);
        return this;
    }

    public ContactsPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public ContactsPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public ContactsPage setCompany(String company) {
        companyNameInput.setValue(company);
        return this;
    }

    public ContactsPage setMessage(String message) {
        messageInput.setValue(message);
        return this;
    }

    public ContactsPage selectTopic(String topic) {
        topicDropdown.$$("span a").findBy(text(topic)).click();
        return this;
    }

    public ContactsPage checkAgree(boolean value) {
        if (value) agreeCheckbox.setSelected(true);
        return this;
    }

    public ContactsPage checkReklama(boolean value) {
        if (value) reklamaCheckbox.setSelected(true);
        return this;
    }

    public ContactsPage submitForm() {
        submitButton.click();
        return this;
    }

    public ContactsPage checkValidation() {
        successMessage.shouldBe(visible);
        return this;
    }

    public ContactsPage checkValidationErrors() {
        $$(".error").shouldHave(sizeGreaterThan(0));
        return this;
    }
}
