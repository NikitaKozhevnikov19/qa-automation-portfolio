package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactsPage {

    @Step("Открыть страницу 'Контакты'")
    public ContactsPage openContactsPage() {
        open("/company/contacts/");
        return this;
    }

    @Step("Ввести имя: {value}")
    public ContactsPage setName(String value) {
        $("input[placeholder='Фамилия, Имя']").setValue(value);
        return this;
    }

    @Step("Ввести email: {value}")
    public ContactsPage setEmail(String value) {
        $("input[placeholder='E-mail']").setValue(value);
        return this;
    }

    @Step("Ввести телефон: {value}")
    public ContactsPage setPhone(String value) {
        $("input[data-name='phone']").setValue(value);
        return this;
    }

    @Step("Ввести название компании: {value}")
    public ContactsPage setCompany(String value) {
        $("input[placeholder='Название компании']").setValue(value);
        return this;
    }

    @Step("Ввести сообщение: {value}")
    public ContactsPage setMessage(String value) {
        $("textarea[placeholder='Ваш вопрос']").setValue(value);
        return this;
    }

    @Step("Выбрать тему сообщения: {topic}")
    public ContactsPage selectTopic(String topic) {
        $(".dropdown-header").click();
        $(".dropdown-box a").shouldHave(Condition.text(topic)).click();
        return this;
    }

    @Step("Отметить согласие на обработку данных")
    public ContactsPage agreeToTerms() {
        $("#form_checkbox_agree_59_6238").setSelected(true);
        return this;
    }

    @Step("Отправить форму")
    public ContactsPage submit() {
        $("input[type='submit'][value='Отправить']").click();
        return this;
    }

    @Step("Проверить отображение ошибки: {expectedText}")
    public ContactsPage checkError(String expectedText) {
        $(".errortext").shouldBe(Condition.visible).shouldHave(Condition.text(expectedText));
        return this;
    }
}
