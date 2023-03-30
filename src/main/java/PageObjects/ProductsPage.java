package PageObjects;

import Utilities.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    TestContext testContext;

    public ProductsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "#shopping_cart_container > a")
    public WebElement cart;

    @FindBy(xpath = "//select[@class = 'product_sort_container']")
    public WebElement filter;

    @FindAll({@FindBy(xpath = "//div[@class='cart_item']")})
    public static List<WebElement> cartItems;

    @FindBy(xpath = "//span[@class='title' and text() = 'Checkout: Complete!']")
    public static WebElement Complete;

    @FindBy(xpath = "//span[@class='select_container']//span[@class='active_option']")
    public WebElement activeFilter;

    @FindAll({@FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item")})
    public List<WebElement> itemsList;

    @FindBy(id = "checkout")
    public static WebElement checkout;

    @FindBy(id = "continue")
    public static WebElement Continue;

    @FindBy(id = "finish")
    public static WebElement Finish;

    @FindBy(xpath = "//input[@data-test='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@data-test='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    public WebElement zipCode;

    public void cartclick() {
        cart.click();
    }


    public void enterCheckoutDetails(String firstname, String lastname, String zipcode) {
        firstName.clear();
        firstName.sendKeys(firstname);
        lastName.clear();
        lastName.sendKeys(lastname);
        zipCode.clear();
        zipCode.sendKeys(zipcode);


    }
}