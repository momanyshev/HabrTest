package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

//page_url = https://habr.com/
public class MainPage {

    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    private WebElement headerLogo;

    @FindBy(xpath = "//button[@class='tm-header__dropdown-toggle']")
    private WebElement headerDropdownToggle;

    @FindBy(xpath = "//a[contains(@class,'author-btn')]")
    private WebElement headerAuthorButton;

    @FindBy(xpath = "//a[@class='tm-our-projects__item']")
    private List <WebElement> dropdownToggleElement;

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

    @FindBy(xpath = "//span//a[@href='/ru/flows/all/']")
    private WebElement flowsAll;

    @FindBy(xpath = "//span//a[@href='/ru/posts/']")
    private WebElement flowsPosts;

    @FindBy(xpath = "//span//a[@href='/ru/news/']")
    private WebElement flowsNews;

    @FindBy(xpath = "//span//a[@href='/ru/hubs/']")
    private WebElement flowsHubs;

    @FindBy(xpath = "//span//a[@href='/ru/users/']")
    private WebElement flowsAuthors;

    @FindBy(xpath = "//span//a[@href='/ru/companies/']")
    private WebElement flowsCompanies;

    public String mainPageClick(){
        headerLogo.click();
        LOG.info("Переход на главную страницу");
        return driver.getCurrentUrl();
    }

    public void headerDropdownToggleClick(){
        headerDropdownToggle.click();
        LOG.info("Раскрытие выпадающего списка направлений");
    }

    public void headerAuthorButtonClick(){
        headerAuthorButton.click();
        LOG.info("Нажатие на кнопку 'КАК СТАТЬ АВТОРОМ'");
    }

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
