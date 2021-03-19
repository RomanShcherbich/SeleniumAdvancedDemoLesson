import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTestNg {


    @BeforeTest
    public void beforeTest()
    {
        System.out.println(">>>>>>>>>>>>>>>>>   BeforeTest");
        System.out.println("Open Chrome");
    }

    @BeforeClass
    public void beforeBaseClass()
    {
        System.out.println("BASE");
        System.out.println("Open Test Application");
    }


    @AfterClass
    public void afterBaseClass()
    {
        System.out.println("BASE");
        System.out.println("Close Test Application");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("Close Chrome");
    }


}
