package mystorepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyStoreHomePage {

    private WebDriver driver;
    private By signInLink = By.cssSelector("a.login");

    public MyStoreHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage clickSignIn() {
        driver.findElement(signInLink).click();
        return new AuthenticationPage(driver);
    }
}
