package com.example.habrtest.tests;

import com.example.habrtest.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public static WebDriver getDriver(){
        return driver;
    }

}
