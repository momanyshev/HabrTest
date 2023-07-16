package com.example.habrtest.tests;

import com.example.habrtest.MyExtension;
import com.example.habrtest.pages.MainPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class MainPageTest {
    private static WebDriver driver;

    private final MainPage mainPage = new MainPage(getDriver());

    public static WebDriver getDriver() {
        if (driver == null)
            createDriver();
        if (driver.toString().contains("null"))
            createDriver();
        return driver;
    }

    public static void createDriver() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    public void setUp() {
        getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода по логотипу на главную страницу")
    public void logoChecking() {
        assertTrue(mainPage.mainPageClick().contains("/all/"), "Открылась неверная ссылка");
    }

    @ParameterizedTest(name = "{index} - {2}")
    @CsvSource({"0, /all/, Хабр",
            "1, /qna.habr.com/, Q&A",
            "2, /career.habr.com/, Карьера",
            "3, /freelance.habr.com/, Фриланс"})
    @DisplayName("Проверка открытия страницы сервисов")
    public void dropdownProjectItemsUrlCheck(int num, String url, String name) {
        assertTrue(mainPage.dropdownToggleElementClick(num).contains(url), "Открылась неверная ссылка, должна была открыться ссылка на сервис " + name);
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки КАК СТАТЬ АВТОРОМ")
    public void authorButtonClick() {
        assertTrue(mainPage.headerAuthorButtonClick(), "Кнопка КАК СТАТЬ АВТОРОМ не кликабельная");
    }

    @ParameterizedTest(name = "{index} - {1}")
    @CsvSource({"0, Все потоки",
            "1, Разработка",
            "2, Администрирование",
            "3, Дизайн",
            "4, Менеджмент",
            "5, Маркетинг",
            "6, Научпоп"})
    @DisplayName("Проверка выбора в главном меню элементов")
    public void mainMenuItemActiveCheck(int num, String name) {
        assertTrue(mainPage.mainMenuAllStreamsClick(num, name).contains("item_active"), "Элемент " + name + " не выбран");
    }

    @Test
    @DisplayName("Проверка открытия страницы поиска")
    public void headerMenuSearch() {
        assertTrue(mainPage.headerMenuSearchClick().contains("/search/"), "Не было осуществлено перехода на страницу поиска");
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки Профиль")
    public void headerMenuProfileClick() {
        assertTrue(mainPage.headerMenuProfileIsClickable(), "Кнопка Профиль не кликабельная");
    }

    @ParameterizedTest(name = "{index} - {1}")
    @CsvSource({"0, Войти", "1, Регистрация"})
    @DisplayName("Проверка кликабельности кнопок авторизации")
    public void authButtonsCkick(int num, String name) {
        assertTrue(mainPage.menuAuthButtonsClick(num), "Кнопка " + name + " не кликабельная");
    }

    @ParameterizedTest(name = "{index} - {1}")
    @CsvSource({"0, Как стать автором, /sandbox/start/", "1, Правила сайта, /docs/help/rules/"})
    @DisplayName("Проверка отображения на ссылки на страницы")
    public void menuTopLinksIsDisplayed(int num, String name, String url) {
        assertTrue(mainPage.menuTopLinksAuthorLink(num).contains(url), "Ссылка " + name + " отсутствует на странице");
    }

    @Test
    @DisplayName("Проверка отображения формы настроек языка и ленты")
    public void menuLinkGreyForm() {
        assertTrue(mainPage.menuLinkGreyClick().contains("Настройки страницы"), "Форма настроек языка и ленты не содержит нужного заголовка");
    }
}
