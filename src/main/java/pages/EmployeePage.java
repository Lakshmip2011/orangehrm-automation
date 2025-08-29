package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public static String generatedEmpId;

    // Locators
    private By addEmployeeButton = By.xpath("//button[contains(.,'Add') or contains(.,'Add Employee')]");
    private By firstNameField = By.xpath("//input[@placeholder='First Name']");
    private By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    private By employeeId = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");
    private By saveButton = By.xpath("//button[@type='submit']");

    // Search section
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
    private By searchButton = By.xpath(" //button[normalize-space()='Search']");

    // Table actions
    private By editBtn = By.xpath("//div[@class='orangehrm-container']//button[1]");
    private By deleteBtn = By.xpath("//i[@class='oxd-icon bi-trash']");
    private By confirmDeleteBtn = By.xpath(" //button[normalize-space()='Yes, Delete']");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Add Employee
    public void addEmployee(String first, String last) {
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(first);
        driver.findElement(lastNameField).sendKeys(last);
        generatedEmpId = driver.findElement(employeeId).getAttribute("value").trim();
        driver.findElement(saveButton).click();
        
        // Wait until personal details page loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Personal Details']")));
    
    }

    // Search by ID
    public void searchEmployeeById(String empId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField)).clear();
        driver.findElement(employeeIdField).sendKeys(empId);
        driver.findElement(searchButton).click();
    }

    // Check if employee is present
    public boolean isEmployeePresent(String empId) {
        By employeeRow = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell' and text()='" + empId + "']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(employeeRow));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Update Employee
    public void updateEmployee(String newFirstName) {
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).clear();
        driver.findElement(firstNameField).sendKeys(newFirstName);
        driver.findElement(saveButton).click();
    }

    // Delete Employee
    public void deleteEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn)).click();
    }
}
