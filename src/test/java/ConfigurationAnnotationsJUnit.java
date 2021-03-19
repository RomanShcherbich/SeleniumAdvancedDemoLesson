import org.junit.*;

public class ConfigurationAnnotationsJUnit extends BaseJUnit {

    @BeforeClass
    public static void setupBrowser() {
        System.out.println("Open Chrome");
        System.out.println("Open Test Application");
    }

    @Before
    public void setupApplication()
    {
        System.out.println("Sign In");
    }

    @Test
    public void searchCustomer()
    {
        System.out.println("Search For Customer");
    }

    @Test
    public void searchProduct()
    {
        System.out.println("Search For Product");
    }

    @After
    public void tearDownApplication()
    {
        System.out.println("Sign Out");
    }

    @AfterClass
    public static void tearDownBrowser() {
        System.out.println("Close Test Application");
        System.out.println("Close Chrome");
    }


}
