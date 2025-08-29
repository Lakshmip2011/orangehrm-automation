package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.EmployeePage;
import utils.BaseTest;
import utils.TestData;

public class DeleteEmployeeTest extends BaseTest {
    @Test
    public void testDeleteEmployee() {
        new LoginPage(driver).login("Admin", "admin123");
        new DashboardPage(driver).goToPIM();

        EmployeePage empPage = new EmployeePage(driver);
        // Search using employee id
        empPage.searchEmployeeById(TestData.employeeId);
        empPage.deleteEmployee();        
    }
}
