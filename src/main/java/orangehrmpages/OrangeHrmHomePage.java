package orangehrmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHrmHomePage {

    private WebDriver driver;
    private By usernameInputField = By.id("txtUsername");
    private By passwordInputField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public OrangeHrmHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public DashboardPage login(String username, String password) {
        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
}
