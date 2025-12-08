package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.components.HeaderMenuComponent;

@Tag("naumen")
public class NaumenTests extends TestBase {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    CompanyPage companyPage = new CompanyPage();
    CareersPage careersPage = new CareersPage();
    ContactsPage contactsPage = new ContactsPage();
    HeaderMenuComponent menu = new HeaderMenuComponent();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    void openHomePageTest() {
        homePage.openPage()
                .closeCookiesIfPresent()
                .checkHomePageIsOpened();
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    void productsPageTest() {
        homePage.openPage().closeCookiesIfPresent();
        menu.openMainMenu("Продукты");
        productsPage.checkProductsLoaded();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    void companyAboutTest() {
        homePage.openPage().closeCookiesIfPresent();
        menu.openSubMenu("О нас", "О компании");
        companyPage.checkSliderHeader("О компании")
                .checkBlockVisible(companyPage.getAboutBlock(), "О компании");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    void careersVacanciesTest() {
        homePage.openPage().closeCookiesIfPresent();
        menu.openMainMenu("Карьера");
        careersPage.openVacancies().checkVacanciesLoaded();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    void contactsFormNegativeTest() {
        homePage.openPage().closeCookiesIfPresent();
        contactsPage.openContactsPage()
                .setName("Иван Иванов")
                .setEmail("invalid-email")
                .setPhone("1234567890")
                .setCompany("TestCompany")
                .setMessage("Тестовое сообщение")
                .selectTopic("Консультация по решению")
                .checkAgree(true)
                .checkReklama(false)
                .submitForm()
                .checkValidationErrors("Ошибка! Введен некорректный адрес email");
    }
}
