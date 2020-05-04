package mystore;

import mystorepages.MyStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class MyStoreBaseTests {

    private WebDriver driver;
    protected MyStoreHomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        homePage = new MyStoreHomePage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
