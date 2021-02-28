import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class DriverFluent implements WebDriver {

    WebDriver driver;

    public DriverFluent(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void get(String s) {
        System.out.println();
    }

    @Override
    public String getCurrentUrl() {
        System.out.println();
        return null;
    }

    @Override
    public String getTitle() {
        System.out.println();
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        System.out.println();
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        System.out.println(" FLUENT WAIT ");

        return  driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        System.out.println();
        return null;
    }

    @Override
    public void close() {
        System.out.println();

    }

    @Override
    public void quit() {

        System.out.println();
    }

    @Override
    public Set<String> getWindowHandles() {
        System.out.println();
        return null;
    }

    @Override
    public String getWindowHandle() {
        System.out.println();
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        System.out.println();
        return null;
    }

    @Override
    public Navigation navigate() {
        System.out.println();
        return null;
    }

    @Override
    public Options manage() {
        System.out.println();
        return null;
    }
}
