package mystorepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {

    private WebDriver driver;
    private By emailInputField = By.id("email");
    private By passwordInputField = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage signIn(String email, String password) {
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new MyAccountPage(driver);
    }
}
