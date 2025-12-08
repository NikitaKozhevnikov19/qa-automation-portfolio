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
                .checkHomePageIsOpened();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    void productsPageTest() {
        homePage.openPage();
        menu.openMain("Продукты");
        productsPage.checkProductsLoaded();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    void companyAboutTest() {
        homePage.openPage();
        menu.openSubMenu("О нас", "О компании");
        companyPage.checkHeaderContains("О компании")
                .checkAboutBlockVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    void careersVacanciesTest() {
        homePage.openPage();
        menu.openMain("Карьера");
        careersPage.openVacancies()
                .checkVacanciesLoaded();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    void contactsFormNegativeTest() {
        homePage.openPage();

        contactsPage.openContactsPage()
                .setName("Иван Иванов")
                .setEmail("invalid-email")
                .setPhone("1234567890")
                .setCompany("TestCompany")
                .setMessage("Тестовое сообщение")
                .selectTopic("Консультация по решению")
                .agreeToTerms()
                .submit()
                .checkError("Ошибка! Введен некорректный адрес email");
    }
}
