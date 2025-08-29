package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dashboardHeader = By.xpath("//h6[contains(normalize-space(),'Dashboard')]");
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private By logoutBtn = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDashboardVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }

    public void goToPIM() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    public void goToEmployeeList() {
        driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();
    }
    
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
    }
}
