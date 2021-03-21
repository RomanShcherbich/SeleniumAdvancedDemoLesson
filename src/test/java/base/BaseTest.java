package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }


    @BeforeMethod
    public void openWindow() {

    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
    }

    public void switchToNewTab() {
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }

    @AfterClass
    public void closeWindow(ITestContext context) {
        openNewTab();
        driver.manage().deleteAllCookies();
        driver.close();
        switchToNewTab();
    }

    @AfterTest
    public void closeBrowser(ITestContext context) {
        driver.quit();
        ResultMap.putResult(context);
        ResultMap.printCurrentTest(context.getName());
    }


    @AfterSuite
    public void printResults() {
        ResultMap.printResults();
    }

    private static class ResultMap {
        private static Map<String, Set<ITestResult>> resultMap = new HashMap<>();

        public static synchronized void putResult(ITestContext context) {
            resultMap.put(context.getName(), context.getPassedTests().getAllResults());
        }

        public static synchronized void printCurrentTest(String name){
            ITestResult test = resultMap.get(name).stream().findFirst().get();
            printResult(test.getName(), test.isSuccess());
        }

        public static void printResult(String name, boolean isSuccess){
            System.out.printf(" PARALLEL TEST LOG - %s - %s %n", name, isSuccess?"PASSED":"FAILED");
        }

        public static synchronized void printResults(){
            for (Map.Entry<String, Set<ITestResult>> result: resultMap.entrySet()) {
                var test = result.getValue().stream().findFirst().get();
                printResult(result.getKey(), test.isSuccess());
            }
        }

    }


}
