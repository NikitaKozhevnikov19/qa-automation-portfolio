package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.components.HeaderMenuComponent;

import static io.qameta.allure.Allure.step;

public class NaumenTests extends TestBase {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    CompanyPage companyPage = new CompanyPage();
    CareersPage careersPage = new CareersPage();
    ContactsPage contactsPage = new ContactsPage();
    HeaderMenuComponent menu = new HeaderMenuComponent();

    @Test
    @Tag("naumen")
    @Severity(SeverityLevel.BLOCKER)
    void openHomePageTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage().checkLogo()
        );
    }

    @Test
    @Tag("naumen")
    @Severity(SeverityLevel.CRITICAL)
    void productsPageTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Перейти в раздел 'Продукты'", () ->
                menu.openMenuItem("Продукты")
        );

        step("Проверить, что продукты загрузились", () ->
                productsPage.checkProductsLoaded()
        );
    }

    @Test
    @Tag("naumen")
    @Severity(SeverityLevel.NORMAL)
    void companyAboutTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Перейти на страницу 'О компании'", () ->
                companyPage.openAboutPage()
        );

        step("Проверить данные о компании", () ->
                companyPage.checkAboutPage()
        );
    }

    @Test
    @Tag("naumen")
    @Severity(SeverityLevel.NORMAL)
    void careersVacanciesTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Перейти в 'Карьера'", () ->
                menu.openMenuItem("Карьера")
        );

        step("Открыть 'вакансии' и проверить их", () ->
                careersPage.openVacancies()
                        .checkVacanciesLoaded()
        );
    }

    @Test
    @Tag("naumen")
    @Severity(SeverityLevel.CRITICAL)
    void contactsFormNegativeTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Открыть 'Контакты'", () ->
                contactsPage.openContactsPage()
        );

        step("Заполнить форму с некорректными данными", () -> {
            contactsPage.setName("Иван Иванов")
                    .setEmail("invalid-email") // <-- некорректный email
                    .setPhone("1234567890")
                    .setCompany("TestCompany")
                    .setMessage("Тестовое сообщение")
                    .selectTopic("Консультация по решению")
                    .checkAgree(true)
                    .checkReklama(false);
        });

        step("Попытаться отправить форму", () ->
                contactsPage.submitForm()
        );

        step("Проверить, что отображаются ошибки валидации", () ->
                contactsPage.checkValidationErrors()
        );
    }

}