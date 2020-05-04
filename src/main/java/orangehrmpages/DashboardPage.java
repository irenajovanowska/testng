package orangehrmpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;
    private By adminTabLink = By.id("menu_admin_viewAdminModule");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPage clickOnAdminTab() {
        driver.findElement(adminTabLink).click();
        return new AdminPage(driver);
    }
}
