package StepDefinitions;

import Utilities.TestContext;
import io.cucumber.java.en.And;
import PageObjects.ProductsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ProductsSteps {

    TestContext testContext;
    ProductsPage productsPage;

    public ProductsSteps(TestContext context) {
        testContext = context;
        productsPage = testContext.getPageObjectManager().getProductsPage();
    }

    @And("The user selects {string} option")
    public void theUserClicksTheLoginButton(String option) {
        Select select = new Select(productsPage.filter);
        switch (option) {
            case "A to Z":
                select.selectByValue("az");
                break;
            case "Z to A":
                select.selectByValue("za");
                break;
            case "low to high":
                select.selectByValue("lohi");
                break;
            case "high to low":
                select.selectByValue("hilo");
                break;

        }

    }

    @And("verify selected {string} is applied")
    public void verifySelectedIsApplied(String option) {
    String filterText = productsPage.activeFilter.getText();
        switch (option) {
        case "A to Z":

        Assert.assertEquals(filterText, "Name (A to Z)");
        break;
        case "Z to A":
             //filterText = productsPage.activeFilter.getText();
        Assert.assertEquals(filterText, "Name (Z to A)");
        break;
        case "low to high":
             //filterText = productsPage.activeFilter.getText();
        Assert.assertEquals(filterText, "Price (low to high)");
        break;
        case "high to low":
           //  filterText = productsPage.activeFilter.getText();
        Assert.assertEquals(filterText, "Price (high to low)");
        break;

    }

    }

    @And("The user adds {string} item by clicking Add To Cart")
    public void theUserAddsItemByClickingAddToCart(String count) {
        for (int i = 1; i <= Integer.valueOf(count); i++) {
            testContext.getDriverManager().getDriver().findElement(By.xpath("//button[contains(@id,'add-to-cart')]['" + i + "']")).click();

        }
    }


    @And("The user clicks on the shopping cart")
    public void theUserClicksOnTheShoppingCart() {
        productsPage.cartclick();
    }

    @Then("There should be {string} items in the shopping cart")
    public void thereShouldBeItemsInTheShoppingCart(String count) {

        int actualCount = productsPage.itemsList.size();
        int expectedCount = Integer.valueOf(count);
        Assert.assertEquals(actualCount, expectedCount);


    }

    @And("the user removes {string} item from cart")
    public void theUserRemovesItemFromCart(String count) {
        for (int i = 1; i <= Integer.valueOf(count); i++) {
            testContext.getDriverManager().getDriver().findElement(By.xpath("//button[contains(@id,'remove')]['" + i + "']")).click();
        }
    }

    @And("The user clicks {string}")
    public void theUserClicksCheckout(String button) {
        switch(button){
            case "Checkout":
                JavascriptExecutor js = (JavascriptExecutor) testContext.getDriverManager().getDriver();
                js.executeScript("arguments[0].scrollIntoView();", ProductsPage.checkout);
                ProductsPage.checkout.click();
                break;
            case "Continue":
                ProductsPage.Continue.click();
                break;
            case "Finish":
                ProductsPage.Finish.click();
                break;
        }

    }

    @And("The user provides the first name as {string} and last name as {string} and zip code as {string}")
    public void theUserProvidesTheFirstNameAsAndLastNameAsAndZipCodeAs(String firstname, String lastname, String zipcode) {
        productsPage.enterCheckoutDetails(firstname,lastname,zipcode);

    }

    @Then("verify that sum of individual items is equal to the items total")
    public void verifyThatSumOfIndividualItemsIsEqualToTheItemsTotal() {
        Float Total = Float.valueOf(0);
        int itemCount = ProductsPage.cartItems.size();
        for (int i = 1; i <= itemCount; i ++){
           WebElement ItemPrice = testContext.getDriverManager().getDriver().findElement(By.xpath("(//div[@class='inventory_item_price'])[" + i + "]"));
            Float Itemvalue = Float.parseFloat(ItemPrice.getText().replace("$","").toString());
             Total = Total + Itemvalue;

        }

        WebElement ItemTotal = testContext.getDriverManager().getDriver().findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        Float TotalValue = Float.parseFloat(ItemTotal.getText().replaceAll("[^0-9.]",""));

        Assert.assertEquals(Total, TotalValue);
    }

    @Then("Verify checkout is complete")
    public void verifyCheckoutIsComplete() {
        ProductsPage.Complete.isDisplayed();
    }
}

