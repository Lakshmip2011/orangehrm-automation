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
/*




package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestData;

public class AddEmployeeTest extends BaseTest {

	public static String generatedEmpId;
	
    @Test
    public void testAddEmployee() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Login
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


        // Navigate to PIM
        WebElement pimMenu = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
        pimMenu.click();

        // Add Employee
        WebElement addEmployeeBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Add Employee']")));
        addEmployeeBtn.click();

        // Fill employee form
        String firstName = "Sai";
        String lastName = "Pandiri";

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='First Name']"))).sendKeys(firstName);

        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);

        // Capture Employee ID before save    
        WebElement empIdField = driver.findElement(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input"));
        generatedEmpId = empIdField.getAttribute("value").trim();

        // Save employee
        WebElement saveEmployeeBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[normalize-space()='Save']")));
        saveEmployeeBtn.click();
        
        
        Thread.sleep(5000);

        // Navigate back to Employee List
        pimMenu = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")));
        pimMenu.click();

        WebElement employeeListBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//a[text()='Employee List']")));
        employeeListBtn.click();

        // Search for employee using Employee ID
        WebElement searchBox = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//label[text()='Employee Id']/../following-sibling::div/input")));
        searchBox.clear();
        searchBox.sendKeys(generatedEmpId);

        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        // Verify employee exists in results by Employee ID
        WebElement employeeRow = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(
                        "//div[@class='oxd-table-card']//div[text()='" + generatedEmpId + "']"
                )));

        Assert.assertTrue(employeeRow.isDisplayed(), "Employee with ID " + generatedEmpId + " not found in list!");
        System.out.println("Employee added & verified successfully with ID: " + generatedEmpId);
    }
}*/
