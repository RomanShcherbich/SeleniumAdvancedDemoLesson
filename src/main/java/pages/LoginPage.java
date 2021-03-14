package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final String URL = "https://www.saucedemo.com";
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public ProductsPage validLogin(String userName, String password) {
        loginWithUserData(userName, password);
        return new ProductsPage(driver);
    }

    private void loginWithUserData(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        explicitWait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }


    public ProductsPage loginWithoutCreeds() {
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    //TODO create method to get error message
}
