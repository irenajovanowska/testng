package dependencies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DependsOnGroupsTests {

    private WebDriver driver;
    private By usernameInputField = By.id("txtUsername");
    private By passwordInputField = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By adminTabLink = By.id("menu_admin_viewAdminModule");
    private By usernameInputSearchField = By.xpath("//*[@id='searchSystemUser_userName']");
    private By searchButton = By.id("searchBtn");
    private By pimTabLink = By.xpath("//*[@id='menu_pim_viewPimModule']/b");
    private By employeeSearchButton = By.id("searchBtn");
    private By recruitmentTabLink = By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']/b");
    private By candidateSearchButton = By.id("btnSrch");
    private By adminMenu = By.id("welcome");
    private By logoutMenuListItem = By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]");


    @Test(priority = 1, groups = "initialize")
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("1. Open Chrome");
    }

    @Test (priority = 2, groups = "env_application", dependsOnGroups = "initialize")
    public void testOpenApplication() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Assert.assertEquals(false, true, "Could Not Access OrangeHRM");

        System.out.println("2. Open Application");
    }

    @Test (priority = 3, dependsOnGroups = "env_application")
    public void testSignIn () {
        String username = "Admin";
        String password = "admin123";

        driver.findElement(usernameInputField).sendKeys(username);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();

        System.out.println("3. Sign In");
    }

    @Test (priority = 4, dependsOnGroups = "env_application")
    public void testSearchUser () {
        String username = "Admin";

        driver.findElement(adminTabLink).click();
        driver.findElement(usernameInputSearchField).sendKeys(username);
        driver.findElement(searchButton).click();

        System.out.println("4. Search User");
    }

    @Test (priority = 5, dependsOnGroups = "env_application")
    public void testSearchEmployee() {
        driver.findElement(pimTabLink).click();
        driver.findElement(employeeSearchButton).click();

        System.out.println("5. Search Employee");
    }

    @Test (priority = 6, dependsOnGroups = "env_application")
    public void testSearchCandidate() {
        driver.findElement(recruitmentTabLink).click();
        driver.findElement(candidateSearchButton).click();

        System.out.println("6. Search Candidate");
    }

    @Test (priority = 7, dependsOnGroups = "env_application")
    public void testSignOut () {
        driver.findElement(adminMenu).click();
        driver.findElement(logoutMenuListItem).click();
        System.out.println("7. Sign Out");
    }

    @Test (priority = 8, groups = "initialize")
    public void tearDown () {
        driver.quit();

        System.out.println("8. Close Chrome");
    }
}
