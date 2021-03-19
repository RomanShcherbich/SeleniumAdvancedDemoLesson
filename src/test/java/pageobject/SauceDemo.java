package pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.time.Duration;

public class SauceDemo extends BaseTest {

    public static final String VALIDATE_LOGIN_FORM_WITH_VALID_ADMIN_CREDENTIALS = "";

    @Parameters({"username", "password"})
    @Test(testName = "VALIDATE_LOGIN_FORM_WITH_VALID_ADMIN_CREDENTIALS")
    public void validateLoginFormWithValidAdminCredentials(String username, String password){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin(username, password);
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 2)
    public void testBrowser2(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @DataProvider
    public Object[][] products(){
        return new Object[][]{
                {"Sauce Labs Backpack", 1},
                {"Sauce Labs Bolt T-Shirt", 1},
                {"Sauce Labs Bike Light", 1},
                {"Sauce Labs Fleece Jacket", 1},
                {"Sauce Labs Onesie", 1},
                {"Test.allTheThings() T-Shirt (Red)", 1},
        };
    }

    @DataProvider
    public Object[][] login(){
        return new Object[][]{
                {"username_invalid", "password_valid", false},
                {"standard_user", "secret_sauce", true},
                {"standard_user", "password_invalid", false},
                {"standard_user", "", false},
                {"", "password_invalid", false},

        };
    }

    @Test(dataProvider = "products")
    public void addProductToCart(String productTitle, int count){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        productsPage.addToCart(productTitle);
        Assert.assertEquals(productsPage.getPictogramValue(), count, "Invalid count");
    }


}
