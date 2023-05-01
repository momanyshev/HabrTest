package com.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void companySearchTest() {

        WebElement companiesLink = driver.findElement(By.xpath("//a[@href='/ru/companies/']"));
        companiesLink.click();

        WebElement searchQuery = driver.findElement(By.cssSelector("input[placeholder='Поиск']"));
        searchQuery.sendKeys("Сбер");

        WebElement companyProfile = driver.findElement(By.xpath("//em[(text()='Сбер')]"));
        companyProfile.click();

        List<WebElement> companyWebsite = (driver.findElements(By.xpath("//a[contains(text(),'www.sber.ru')]")));
        assertFalse(companyWebsite.isEmpty(), "Ссылка на сайт компании отсутствует");
    }

    @Test
    public void docsRulesTest() {

        WebElement docsLink = driver.findElement(By.cssSelector("a[href='/ru/docs/docs/transparency/']"));
        docsLink.click();

        WebElement rulesRules = driver.findElement(By.xpath("//a[contains(text(),'Правила оказания рекламных услуг')]"));
        rulesRules.click();

        List<WebElement> companyWebsite = (driver.findElements(By.xpath("//h2[text()='Правила оказания рекламных услуг']")));
        assertFalse(companyWebsite.isEmpty(), "Ссылка на Правила оказания рекламных услуг недействительна");
    }
}
