package orangehrm;

import org.testng.annotations.Test;

public class OrangeHRMTests extends OrangeHrmBaseTests {

    @Test
    public void testLogInSearchUserLogOut() {
        String username = "Admin";
        String password = "admin123";

        var dashboardPage = homePage.login(username, password);
        var adminPage = dashboardPage.clickOnAdminTab();
        adminPage.searchUser(username);
        adminPage.logout();
    }
}
