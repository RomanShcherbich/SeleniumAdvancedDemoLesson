package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class Product implements Button {

    private WebElement productElement;
    private String title;
    private By button = By.tagName("button");
    private By titleLocator = By.className("inventory_item_name");

    public Product(WebElement productElement) {
        this.productElement = productElement;
        this.title = productElement.findElement(titleLocator).getText();
    }

    public void addToCart() {
        productElement.findElement(button).click();
    }

    public String getTitle() {
        return title;
    }

    public String getButtonTitle() {
        return productElement.findElement(button).getText();
    }

    @Override
    public void click() {
        productElement.click();
    }



}
