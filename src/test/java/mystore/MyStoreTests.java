package mystore;

import org.testng.annotations.Test;

public class MyStoreTests extends MyStoreBaseTests {

    @Test
    public void testSignInSearchSignOut() {
        String email = "TestNG@Framework.com";
        String password = "TestNG1234";
        String tShirtAttribute = "blue";

        //Sign In
        var authenticationPage = homePage.clickSignIn();
        var myAccountPage = authenticationPage.signIn(email, password);

        //Go to T-Shirts menu
        var tShirtCatalogPage = myAccountPage.clickTShirtMenu();

        //Search T-Shirts
        tShirtCatalogPage.searchTShirts(tShirtAttribute);

        //Sign Out
        tShirtCatalogPage.signOut();
    }
}
