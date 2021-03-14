package pages;

import elements.Product;
import org.openqa.selenium.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsPage extends BasePage {

    String addToCartLocator = "//div[contains(.,'%s')]/ancestor::div[@class='inventory_item']//button";
    By inventoryItems =  By.xpath("//div[@class='inventory_item']");
    By sortImage = new By.ByCssSelector(".peek");
    Map<String, Product> productMap = new HashMap<>();

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage isProductPageLoaded(){
//        FluentWait<pages.DriverFluent> fluent = new FluentWait<>(new pages.DriverFluent(driver))
//        FluentWait<WebDriver> fluent = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(60))
//                .pollingEvery(Duration.ofSeconds(5))
//                .ignoring(NoSuchElementException.class);
//        fluent.until(driver -> driver.findElement(sortImage));
        System.out.println("FLUENT WAIT");
        driver.findElement(sortImage);
        return this;
    }

    public ProductsPage waitWithJsWaiter() throws Exception {
        try {
            explicitWait.until(waitForPageLoaded());
        } catch (TimeoutException e) {
            throw new Exception("Page is no loaded. JS waiter exception");
        }
        return this;
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();

    }

    public void logout() {
            driver.get(LoginPage.URL);
    }

    public void findRemoveButton(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }

    public void logOutFromMenuButton() {
        driver.findElement(By.id("logout_sidebar_link"));
    }

    public Product addProductToCart(String title){
        Product product = getProducts().get(title);
        product.addToCart();
        return product;
    }

    public void addAllProducts(){
        getProducts().forEach((key, value) -> value.addToCart());
    }

    public Map<String, Product> getProducts() {
        if (productMap.isEmpty()) {
            List<WebElement> productWebElementList = driver.findElements(inventoryItems);
            for (WebElement productElement :
                    productWebElementList) {
                Product product = new Product(productElement);
                productMap.put(product.getTitle(), product);
            }
        }
        return productMap;
    }


}
