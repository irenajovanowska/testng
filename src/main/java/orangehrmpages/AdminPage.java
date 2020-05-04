package orangehrmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private WebDriver driver;
    private By usernameInputSearchField = By.xpath("//*[@id='searchSystemUser_userName']");
    private By searchButton = By.id("searchBtn");
    private By adminMenu = By.id("welcome");
    private By logoutMenuListItem = By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchUser(String username) {
        driver.findElement(usernameInputSearchField).sendKeys(username);
        driver.findElement(searchButton).click();
    }

    public OrangeHrmHomePage logout() {
        driver.findElement(adminMenu).click();
        driver.findElement(logoutMenuListItem).click();
        return new OrangeHrmHomePage(driver);
    }
}
