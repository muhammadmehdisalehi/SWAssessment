package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "user-name")
    public WebElement usernameEle;

    @FindBy(id = "password")
    public WebElement passwordEle;

    @FindBy(id = "login-button")
    private WebElement login;

    @FindBy(xpath = "//div[@class='login-box']//div[@class='error-message-container error']")
    public WebElement lockedError;

    @FindBy(xpath = "//span[@class='title' and text() = 'Products']")
    public WebElement productHeading;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menu;

    @FindBy(xpath = "//select[@class = 'product_sort_container']")
    public WebElement filter;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logout;

    public void enterUsername(String username) {
        usernameEle.click();
        usernameEle.sendKeys(username);
        
    }

    public void enterPassword(String password) {
       // passwordEle.click();
        passwordEle.sendKeys(password);
    }

    public boolean hasLockedOutError() {
        {
            return lockedError.isDisplayed();
        }
    }

    public boolean productPage() {
        boolean flag = false;
        if (
                productHeading.isDisplayed() && menu.isDisplayed() && filter.isDisplayed()){

            flag =  true;
        }
       return flag;
    }

    public void clickLogin() {
        login.click();
    }

    public void clickMenu() {
        menu.click();
    }

    public void clickLogout() {
        logout.click();
    }

    public void clickFilter() {
        filter.click();
    }
}
