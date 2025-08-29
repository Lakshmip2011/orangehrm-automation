package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("WrongUser", "WrongPass");

        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials", "Unexpected error message!");
    }
}
