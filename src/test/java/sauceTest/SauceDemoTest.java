package sauceTest;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

import java.time.Duration;

public class SauceDemoTest extends BaseTest {

    @Test(groups = {"flacky"})
    public void testJsWaiter(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        FluentWait<ProductsPage> fluent = new FluentWait<>(productsPage)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluent.until(ProductsPage::isProductPageLoaded);

        try {
            productsPage.waitWithJsWaiter();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(groups = {"init-browser"})
    public void validLogin(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        productsPage.isProductPageLoaded();
    }

    @Test(groups = {"flacky"})
    public void addProductToCart(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        productsPage.isProductPageLoaded();
        Assert.assertEquals(productsPage.addProductToCart("Sauce Labs Backpack").getButtonTitle(),
                "REMOVE");

    }

    @Test(groups = {"flacky"})
    public void addAllProductsToCart(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        productsPage.isProductPageLoaded();
        productsPage.addAllProducts();
        Assert.assertEquals(productsPage.addProductToCart("Sauce Labs Backpack").getButtonTitle(),
                "ADD TO CART");
//                "REMOVE");
    }


    @Test(groups = {"init-browser"})
    public void logout(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        productsPage.isProductPageLoaded();
        productsPage.logout();
    }


}
