package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

    private WebDriver driver;

    @Test
    @Parameters ( {"URL", "BrowserType"} )
    public void testHomePage(String url, String browserType) {
        if(browserType.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if(browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("\n" + "Open " + browserType);
        System.out.println("   " +  driver.getTitle());
        System.out.println("Close " + browserType + "\n");

        driver.quit();
    }
}
