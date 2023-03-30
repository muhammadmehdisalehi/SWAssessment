package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='login_logo' and text() = 'Swag Labs']")
    private WebElement headerLogo;


    @FindBy(id = "login-button")
    public WebElement loginButton;

    public boolean defaultHomePageIsDisplayed() {

        if (headerLogo.isDisplayed() && loginButton.isDisplayed()) {

            return true;
        }
        return false;
    }

    public void clickLoginButton() {

        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

}
