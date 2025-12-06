package tests;

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
    void openHomePageTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage().checkLogo()
        );
    }

    @Test
    @Tag("naumen")
    void productsPageTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Перейти в раздел Продукты", () ->
                menu.openMenuItem("Продукты")
        );

        step("Проверить, что продукты загрузились", () ->
                productsPage.checkProductsLoaded()
        );
    }

    @Test
    @Tag("naumen")
    void companyAboutTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Перейти на страницу О компании", () ->
                companyPage.openAboutPage()
        );

        step("Проверить данные о компании", () ->
                companyPage.checkAboutPage()
        );
    }

    @Test
    @Tag("naumen")
    void careersVacanciesTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Перейти в Карьеры", () ->
                menu.openMenuItem("Карьера")
        );

        step("Открыть вакансии и проверить их", () ->
                careersPage.openVacancies()
                        .checkVacanciesLoaded()
        );
    }

    @Test
    @Tag("naumen")
    void contactsFormNegativeTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Открыть Контакты", () ->
                contactsPage.openContactsPage()
        );

        step("Заполнить форму с некорректными данными", () -> {
            contactsPage.setName("")
                    .setEmail("invalid-email")
                    .setPhone("")
                    .setCompany("")
                    .setMessage("")
                    .selectTopic("Консультация по решению")
                    .checkAgree(false)
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