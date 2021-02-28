import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ProductsPage extends BasePage {

    String addToCartLocator = "//div[contains(.,'%s')]/ancestor::div[@class='inventory_item']//button";
    By sortImage = new By.ByCssSelector(".peek2");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage isProductPageLoaded(){
//        explicitWait.until(ExpectedConditions.attributeToBe(sortImage, "class", "peek1"));



        FluentWait<DriverFluent> fluent = new FluentWait<>(new DriverFluent(driver))
//        FluentWait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluent.until(driver -> driver.findElement(sortImage));
        return new ProductsPage(driver);
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();

    }

    public void findRemoveButton(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }

    public void logOutFromMenuButton() {
        driver.findElement(By.id("logout_sidebar_link"));
    }

}
