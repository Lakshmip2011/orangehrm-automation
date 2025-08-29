package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utils.BaseTest;

public class LogoutTest extends BaseTest {
    @Test
    public void testLogout() {
        new LoginPage(driver).login("Admin", "admin123");
        DashboardPage dashboard = new DashboardPage(driver);

        dashboard.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Logout failed!");
    }
}
