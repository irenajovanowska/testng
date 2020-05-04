package priority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExecutionOrderTests {

    private WebDriver driver;
    private By signInLink = By.cssSelector("a.login");
    private By emailInputField = By.id("email");
    private By passwordInputField = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By tShirtMenuLink = By.xpath("//div[@id='block_top_menu']/ul/li/a[not(contains(@class, 'sf-with-ul'))]");
    private By searchInputBar = By.id("search_query_top");
    private By searchButton = By.name("submit_search");
    private By signOutMenuItem = By.cssSelector("a.logout");

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * The default execution order is ascending alphabetical order from a – z (@Test method names).
     * The priority attribute uses an Integer data type to determine the execution order for the @Test methods.
     * The lowest number gets executed first.
     */
    @Test (priority = 1)
    public void testSignIn() {
        String email = "TestNG@Framework.com";
        String password = "TestNG1234";

        driver.findElement(signInLink).click();
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(signInButton).click();

        System.out.println("1. Sign In");
    }

    @Test (priority = 2)
    public void testSearchItem() {
        String itemAttribute = "blue";

        driver.findElement(tShirtMenuLink).click();
        driver.findElement(searchInputBar).sendKeys(itemAttribute);
        driver.findElement(searchButton).click();

        System.out.println("2. Search T-Shirt");
    }

    @Test (priority = 3)
    public void testSignOut() {
        driver.findElement(signOutMenuItem).click();

        System.out.println("3. Sign Out");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
