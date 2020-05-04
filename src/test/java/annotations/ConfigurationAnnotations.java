package annotations;

import org.testng.annotations.*;

public class ConfigurationAnnotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1. BeforeSuite: Chrome - Set Up System Property");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("2. BeforeTest: Open Chrome");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("3. BeforeClass: Open Test Application");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("4. BeforeMethod: Sign In");
    }

    @Test
    public void searchCustomer() {
        System.out.println("5. Test: Search For Customer");
    }

    @Test
    public void searchProduct() {
        System.out.println("6. Test: Search For Product");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("7. AfterMethod: Sign Out");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("8. AfterClass: Close Test Application");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("9. AfterTest: Close Chrome");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("10. AfterSuite: Chrome - Clean Up All Cookies");
    }
}
