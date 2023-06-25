package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//page_url = https://habr.com/
public class MainPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    private WebElement headerLogo;

    @FindBy(xpath = "//button[@class='tm-header__dropdown-toggle']")
    private WebElement headerDropdownToggle;

    @FindBy(xpath = "//a[@class='tm-our-projects__item']")
    private List <WebElement> dropdownToggleElement;

    @FindBy(xpath = "//a[contains(@class,'author-btn')]")
    private WebElement headerAuthorButton;

    @FindBy(xpath = "//a[contains(@class,'tm-main-menu__item')]")
    private List <WebElement> mainMenuItem;

    @FindBy(xpath = "//a[@href='/ru/search/']")
    private WebElement headerMenuSearch;

    @FindBy(xpath = "//div[@class=\"tm-dropdown\"]//div[@class=\"tm-dropdown__head\"]")
    private WebElement headerMenuProfile;

    @FindBy(xpath = "//div[@class=\"tm-user-menu__auth-buttons\"]//a")
    private List <WebElement> menuAuthButtons;

    @FindBy(xpath = "//div[@class=\"tm-user-menu__menu_top\"]//a")
    private List <WebElement> menuTopLinks;

    @FindBy(xpath = "//button[contains(@class,'menu-link_grey')]")
    private WebElement menuLinkGrey;

    @FindBy(xpath = "//div[@class='tm-page-settings-form__title']")
    private WebElement menuLinkGreyHeader;

    public void nextTab(){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        LOG.info("Переход на новую вкладку");
    }

    public String mainPageClick(){
        headerLogo.click();
        LOG.info("Переход на главную страницу");
        return driver.getCurrentUrl();
    }

    public void headerDropdownToggleClick(){
        headerDropdownToggle.click();
        LOG.info("Раскрытие выпадающего списка направлений");
    }

    public boolean headerAuthorButtonClick(){
        LOG.info("Проверка кликабельности кнопки 'КАК СТАТЬ АВТОРОМ'");
        return headerAuthorButton.isEnabled();
    }

    public String dropdownToggleElementClick(int id){
        headerDropdownToggleClick();
        dropdownToggleElement.get(id).click();
        LOG.info("Переход по " + id + " элементу выпадающего списка");
        nextTab();
        return driver.getCurrentUrl();
    }

    public String mainMenuAllStreamsClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/all/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String mainMenuDevelopClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/develop/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String mainMenuAdminClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/admin/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String mainMenuDesignClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/design/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String mainMenuManagementClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/management/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String mainMenuMarketingClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/marketing/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String mainMenuPopsciClick(int id){
        mainMenuItem.get(id).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/popsci/') and contains(@class,'item_active')]")));
        LOG.info("Выбор "+ id + " элемента главного меню");
        return mainMenuItem.get(id).getAttribute("class");
    }

    public String headerMenuSearchClick(){
        headerMenuSearch.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Поиск']")));
        LOG.info("Нажатие на значок поиска");
        return driver.getCurrentUrl();
    }

    public boolean headerMenuProfileIsClickable(){
        LOG.info("Проверка кликабельности кнопки Профиль");
        return headerMenuProfile.isEnabled();
    }

    public void headerMenuProfileClick(){
        LOG.info("Нажатие на кнопку Профиль");
        headerMenuProfile.click();
    }

    public boolean menuAuthButtonsClick(int id){
        headerMenuProfileClick();
        LOG.info("Проверка кликабельности кнопки меню авторизации");
        return menuAuthButtons.get(id).isEnabled();
    }

    public String menuTopLinksAuthorLink(int id){
        headerMenuProfileClick();
        LOG.info("Проверка отображения на странице пользовательских ссылок");
        return menuTopLinks.get(id).getAttribute("href");
    }

    public String menuLinkGreyClick(){
        headerMenuProfileClick();
        menuLinkGrey.click();
        LOG.info("Нажатие на ссылку Язык, лента");
        return menuLinkGreyHeader.getText();
    }

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
