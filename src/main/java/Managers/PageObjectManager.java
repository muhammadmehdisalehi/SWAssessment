package Managers;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Short Hand If...Else
    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
    }

    //General If...Else
    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }

    public ProductsPage getProductsPage()  {
        return (productsPage == null) ? productsPage = new ProductsPage(webDriver) : productsPage;
    }
}
