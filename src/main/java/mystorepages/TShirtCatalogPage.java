package mystorepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TShirtCatalogPage {

    private WebDriver driver;
    private By searchInputBar = By.id("search_query_top");
    private By searchButton = By.name("submit_search");
    private By signOutMenuItem = By.cssSelector("a.logout");

    public TShirtCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchTShirts(String keyword) {
        driver.findElement(searchInputBar).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public void signOut() {
        driver.findElement(signOutMenuItem).click();
    }
}
