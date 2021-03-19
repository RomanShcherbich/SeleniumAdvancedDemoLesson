package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Set;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/env/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 800));
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

//    @BeforeMethod
//    public void openNewTab() {
//    }
//
//    private void initNewTab() {
//        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
//    }
//
//    private void switchToTheLastTab() {
//        String windowsHandler = null;
//        Set<String> handles = driver.getWindowHandles();
//        Iterator<String> iterator = handles.iterator();
//        while (iterator.hasNext()) {
//            windowsHandler = iterator.next();
//        }
//        driver.switchTo().window(windowsHandler);
//    }
//
//    public void afterBrowser() {
//        initNewTab();
//        driver.manage().deleteAllCookies();
//        driver.close();
//        switchToTheLastTab();
//        System.out.println();
//    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowserAlways() {
        driver.quit();
    }


}
