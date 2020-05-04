package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderAttributeTests {

    private WebDriver driver;
    private By signInLink = By.cssSelector("a.login");
    private By emailInputField = By.id("email");
    private By passwordInputField = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By signOutLink = By.cssSelector("a.logout");
    private By adminMenu = By.id("welcome");
    private By logoutMenuListItem = By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]");

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (dataProvider = "login-provider")
    public void testSignIn(String email, String password, boolean success) {
        driver.findElement(signInLink).click();
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(signInButton).click();

        System.out.println("Credentials: " + "\n" + "Email = " + email + "\n" + "Password = " + password + "\n" + "Successful Log In = " + success + "\n" );

        Assert.assertEquals(driver.findElement(signOutLink).getText(), "Sign out", "Seems like you haven't logged in successfully.");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider (name = "login-provider")
    public Object[][] logInData() {
        Object[][] data = new Object[3][3];

        data[0][0] = "TestNG@Framework.com";
        data[0][1] = "TestNG1234";
        data[0][2] = true;

        data[1][0] = "Joe@Doe.com";
        data[1][1] = "DoeDoe34";
        data[1][2] = false;

        data[2][0] = "Test@AutomationU.com";
        data[2][1] = "TAU1234";
        data[2][2] = true;

        return data;
    }
}
