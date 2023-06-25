package com.example.habrtest.tests;

import com.example.habrtest.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private static  WebDriver driver;

    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
        mainPage = new MainPage(getDriver());

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода по логотипу на главную страницу")
    public void logoChecking() {
        assertEquals("https://habr.com/ru/all/", mainPage.mainPageClick(), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка перехода по элементу выпадающего списка Хабр")
    public void dropdownToggleHabr(){
        assertEquals("https://habr.com/ru/all/",  mainPage.dropdownToggleElementClick(0), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка перехода по элементу выпадающего списка Q&A")
    public void dropdownToggleQaA(){
        assertEquals("https://qna.habr.com/",  mainPage.dropdownToggleElementClick(1), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка перехода по элементу выпадающего списка Карьера")
    public void dropdownToggleCareer(){
        assertEquals("https://career.habr.com/",  mainPage.dropdownToggleElementClick(2), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка перехода по элементу выпадающего списка Фриланс")
    public void dropdownToggleFreelance(){
        assertEquals("https://freelance.habr.com/",  mainPage.dropdownToggleElementClick(3), "Открылась неверная ссылка");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки КАК СТАТЬ АВТОРОМ")
    public void authorButtonClick(){
        assertTrue(mainPage.headerAuthorButtonClick(), "Кнопка КАК СТАТЬ АВТОРОМ не кликабельная");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Все потоки")
    public void mainMenuAllStreams(){
        assertTrue(mainPage.mainMenuAllStreamsClick(0).contains("item_active"), "Элемент Все потоки не выбран");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Разработка")
    public void mainMenuDevelop(){
        assertTrue(mainPage.mainMenuDevelopClick(1).contains("item_active"), "Элемент Разработка не выбран");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Администрирование")
    public void mainMenuAdmin(){
        assertTrue(mainPage.mainMenuAdminClick(2).contains("item_active"), "Элемент Администрирование не выбран");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Дизайн")
    public void mainMenuDesign(){
        assertTrue(mainPage.mainMenuDesignClick(3).contains("item_active"), "Элемент Дизайн не выбран");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Менеджмент")
    public void mainMenuManagement(){
        assertTrue(mainPage.mainMenuManagementClick(4).contains("item_active"), "Элемент Менеджмент не выбран");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Маркетинг")
    public void mainMenuItemMarketing(){
        assertTrue(mainPage.mainMenuMarketingClick(5).contains("item_active"), "Элемент Маркетинг не выбран");
    }

    @Test
    @DisplayName("Проверка выбора в главном меню элемента Научтоп")
    public void mainMenuItemPopsci(){
        assertTrue(mainPage.mainMenuPopsciClick(6).contains("item_active"), "Элемент Научтоп не выбран");
    }

    @Test
    @DisplayName("Проверка открытия страницы поиска")
    public void headerMenuSearch() {
        assertTrue(mainPage.headerMenuSearchClick().contains("/search/"), "Не было осуществлено перехода на страницу поиска");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Профиль")
    public void headerMenuProfileClick(){
        assertTrue(mainPage.headerMenuProfileIsClickable(), "Кнопка Профиль не кликабельная");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Войти")
    public void loginButtonClick(){
        assertTrue(mainPage.menuAuthButtonsClick(0), "Кнопка Войти не кликабельная");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Регистрация")
    public void registerButtonClick(){
        assertTrue(mainPage.menuAuthButtonsClick(1), "Кнопка Регистрация не кликабельная");
    }

    @Test
    @DisplayName("Проверка отображения на ссылки на страницу Как стать автором")
    public void menuTopLinksAuthorLinkIsDisplayed(){
        assertEquals("https://habr.com/ru/sandbox/start/", mainPage.menuTopLinksAuthorLink(0), "Ссылка Как стать автором отсутствует на странице");
    }

    @Test
    @DisplayName("Проверка отображения на ссылки на страницу Правила сайта")
    public void menuTopLinksSiteRulesIsDisplayed(){
        assertEquals("https://habr.com/ru/docs/help/rules/", mainPage.menuTopLinksAuthorLink(1), "Ссылка Правила сайта отсутствует на странице");
    }

    @Test
    @DisplayName("Проверка отображения формы настроек языка и ленты")
    public void menuLinkGreyForm(){
        assertTrue(mainPage.menuLinkGreyClick().contains("Настройки страницы"), "Форма настроек языка и ленты не содержит нужного заголовка");
    }

    /*
    @Test
    @Test
    @Test
    */

    public static WebDriver getDriver(){
        return driver;
    }

}
