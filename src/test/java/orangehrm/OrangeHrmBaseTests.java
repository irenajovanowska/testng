package orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import orangehrmpages.OrangeHrmHomePage;

import java.util.concurrent.TimeUnit;

public class OrangeHrmBaseTests {

    private WebDriver driver;
    protected OrangeHrmHomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        homePage = new OrangeHrmHomePage(driver);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
