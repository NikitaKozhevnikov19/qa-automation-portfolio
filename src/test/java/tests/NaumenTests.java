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
                homePage.openPage().checkMainTitle()
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

        step("Перейти в Компания → О нас", () ->
                menu.openSubMenu("Компания", "О нас")
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
    void contactsFormTest() {
        step("Открыть главную страницу", () ->
                homePage.openPage()
        );

        step("Открыть Контакты", () ->
                menu.openMenuItem("Контакты")
        );

        step("Заполнить форму", () ->
                contactsPage.fillContactForm("Nikita", "test@test.com", "Hello!")
        );

        step("Отправить форму", () ->
                contactsPage.submitForm()
        );

        step("Проверить валидацию/успех", () ->
                contactsPage.checkValidation()
        );
    }
}
