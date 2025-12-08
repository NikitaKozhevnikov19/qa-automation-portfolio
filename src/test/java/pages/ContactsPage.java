package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
    private final SelenideElement errorText = $(".errortext");

    @Step("Открыть страницу контактов")
    public ContactsPage openContactsPage() {
        open("/company/contacts/");
        return this;
    }

    @Step("Заполнить поле '{field}' значением '{value}'")
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

    @Step("Выбрать тему: {topic}")
    public ContactsPage selectTopic(String topic) {
        $(".dropdown-header").click();
        topicDropdown.$$("a").findBy(Condition.text(topic)).click();
        return this;
    }

    @Step("Поставить чекбокс 'Согласие' в значение {value}")
    public ContactsPage checkAgree(boolean value) {
        if (value) agreeCheckbox.setSelected(true);
        return this;
    }

    @Step("Поставить чекбокс 'Реклама' в значение {value}")
    public ContactsPage checkReklama(boolean value) {
        if (value) reklamaCheckbox.setSelected(true);
        return this;
    }

    @Step("Отправить форму")
    public ContactsPage submitForm() {
        submitButton.click();
        return this;
    }

    @Step("Проверить успешную отправку")
    public ContactsPage checkValidation() {
        successMessage.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить отображение ошибки: {expectedError}")
    public ContactsPage checkValidationErrors(String expectedError) {
        errorText.shouldBe(Condition.visible)
                .shouldHave(Condition.text(expectedError));
        return this;
    }
}
