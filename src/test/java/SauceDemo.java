import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemo extends BaseTest {

    @Test
    public void TestBrowser(){
        loginPage.openPage();
        ProductsPage productsPage = loginPage.validLogin("standard_user", "secret_sauce");
        FluentWait<ProductsPage> fluent = new FluentWait<>(productsPage)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluent.until(ProductsPage::isProductPageLoaded);
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

}