import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseJUnit {

    @BeforeClass
    public static void beforeBaseClass() {
        System.out.println("Chrome - Set Up System Property");
        System.out.println("BASE");
    }


    @AfterClass
    public static void afterBaseClass() {
        System.out.println("BASE");
        System.out.println("Close Test Application");
    }

}
