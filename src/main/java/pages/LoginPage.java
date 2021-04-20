package pages;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
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
        Logger log = LoggerFactory.getLogger(LoginPage.class);
        log.debug(String.format("send text[%s] to text field [%s]", userName, "user-name"));
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        log.debug(String.format("send text[%s] to text field [%s]", password, "password"));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        explicitWait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        driver.findElement(LOGIN_BUTTON).click();
    }

    public LoginPage waitLoginPageLoaded(){
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LOGIN_BUTTON));
        return this;
    }

    public ProductsPage loginWithoutCreeds() {
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    //TODO create method to get error message
}
