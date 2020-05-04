package mystorepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private WebDriver driver;
    private By tShirtMenuLink = By.xpath("//div[@id='block_top_menu']/ul/li/a[not(contains(@class, 'sf-with-ul'))]");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public TShirtCatalogPage clickTShirtMenu() {
        driver.findElement(tShirtMenuLink).click();
        return new TShirtCatalogPage(driver);
    }

}
