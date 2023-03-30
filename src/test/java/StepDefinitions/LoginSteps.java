package StepDefinitions;

import PageObjects.LoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }





    @And("The user provides the username as {string} and password as {string}")
    public void theUserProvidesTheUsernameAsAndPasswordAs(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("The user should login successfully and is brought to the inventory page")
    public void theUserShouldLoginSuccessfullyAndIsBroughtToTheInventoryPage() throws InterruptedException {
        Thread.sleep(1000);
        String currentUrl = testContext.getDriverManager().getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(loginPage.productPage());
    }

    @Then("The user should be shown a locked out message")
    public void theUserShouldBeShownALockedOutMessage() {
        Assert.assertTrue(loginPage.hasLockedOutError());
        Assert.assertEquals(loginPage.lockedError.getText(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @And("The user clicks the {string} button")
    public void theUserClicksTheLoginButton(String button) {
        switch (button) {
            case "Login":
                loginPage.clickLogin();
                break;
            case "Menu":
                loginPage.clickMenu();
                break;
            case "Logout":
                loginPage.clickLogout();
                break;
            case "Filter":
                loginPage.clickFilter();
                break;
        }

    }

    @Then("The user should be shown an invalid username\\/password message")
    public void theUserShouldBeShownAnInvalidUsernamePasswordMessage() {
        Assert.assertTrue(loginPage.hasLockedOutError());
        Assert.assertEquals(loginPage.lockedError.getText(),"Epic sadface: Username and password do not match any user in this service");
    }
}
