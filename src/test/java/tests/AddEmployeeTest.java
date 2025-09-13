package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.EmployeePage;
import utils.BaseTest;
import utils.TestData;
import java.time.Duration;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void testAddEmployee() {
        // Login
        new LoginPage(driver).login("Admin", "admin123");

        // Navigate to PIM
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.goToPIM();

        // Add employee
        EmployeePage empPage = new EmployeePage(driver);
        empPage.addEmployee(TestData.employeeFirstName, TestData.employeeLastName);

        // Save generated empId
        TestData.employeeId = EmployeePage.generatedEmpId;
        System.out.println("DEBUG: Stored Employee ID in TestData = " + TestData.employeeId);

        // Go to Employee List
        dashboard.goToEmployeeList();

        // Search by empId
        empPage.searchEmployeeById(TestData.employeeId);

        
        // Verify employee exists in results by Employee ID
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement employeeRow = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(
                        "//div[@class='oxd-table-card']//div[text()='" + TestData.employeeId + "']"
        )));

        Assert.assertTrue(employeeRow.isDisplayed(), "Employee with ID " + TestData.employeeId + " not found in list!");
        System.out.println("Employee added & verified successfully with ID: " + TestData.employeeId);
        
        
    }
}
