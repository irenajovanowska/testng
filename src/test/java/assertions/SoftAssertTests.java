package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTests {

    private WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    private By usernameInputField = By.id("txtUsername");
    private By passwordInputField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By adminTabLink = By.id("menu_admin_viewAdminModule");
    private By usernameInputSearchField = By.xpath("//*[@id='searchSystemUser_userName']");
    private By searchButton = By.id("searchBtn");
    private By adminMenu = By.id("welcome");
    private By logoutMenuListItem = By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]");


    @BeforeClass
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("1. BeforeClass: Open Chrome & Application");
    }

    @Test (priority = 1)
    public void testSignIn () {
        String username = "Admin";
        String password = "admin123";

        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();

        System.out.println("2. Test: Sign In");
    }

    /**
     * A soft assert continues execution after a failed verification step and moves on to the next statement line.
     * An assertAll() call has to be added at the end of each test that uses soft assert for the soft assert to work.
     */
    @Test (priority = 2)
    public void testWelcomePage() {
        softAssert.assertTrue(driver.findElement(adminTabLink).isDisplayed(), "The Admin Tab is not displayed.");
        softAssert.assertTrue(driver.findElement(adminMenu).isDisplayed(), "The 'Welcome Admin' menu is not displayed.");

        softAssert.assertAll();
    }

    @Test (priority = 3)
    public void testUserSearch () {
        String username = "Admin";

        driver.findElement(adminTabLink).click();
        driver.findElement(usernameInputSearchField).sendKeys(username);
        driver.findElement(searchButton).click();

        System.out.println("3. Test: Search For User");
    }

    @Test (priority = 4)
    public void testSignOut () {
        driver.findElement(adminMenu).click();
        driver.findElement(logoutMenuListItem).click();
        System.out.println("4. Test: Sign Out");
    }

    @AfterClass
    public void tearDown () {
        driver.quit();

        System.out.println("5. AfterClass: Close Chrome & Application");
    }
}
