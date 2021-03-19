package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        explicitWait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver, int explicitWait) {
        this.driver = driver;
        this.explicitWait = new WebDriverWait(driver, explicitWait);
    }

    public abstract void isPageOpened();

}
