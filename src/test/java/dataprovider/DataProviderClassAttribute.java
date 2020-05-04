package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DataProviderClassAttribute {

    private WebDriver driver;
    private By usernameInputField = By.id("txtUsername");
    private By passwordInputField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By adminMenu = By.id("welcome");

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (dataProviderClass = DataProviderClass.class, dataProvider = "signIn-provider")
    public void testSignIn(String username, String password, boolean success) {
        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();

        System.out.println("Credentials: " + "\n" + "Username = " + username + "\n" + "Password = " + password + "\n" + "Successful Sign In = " + success + "\n");

        Assert.assertEquals(driver.findElement(adminMenu).getText(), "Welcome Admin", "Seems like you haven't logged in successfully.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
