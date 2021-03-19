package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    String addToCartLocator = "//div[contains(.,'%s')]/ancestor::div[@class='inventory_item']//button";
    By sortImage = new By.ByCssSelector(".peek");
    By pictogram = By.className("fa-layers-counter");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        System.out.println("FLUENT WAIT");
        driver.findElement(sortImage);
    }

    public ProductsPage isProductPageLoaded(){
        isPageOpened();
        return this;
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

    public int getPictogramValue(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(pictogram));
        return Integer.parseInt(driver.findElement(pictogram).getText());
    }

}
