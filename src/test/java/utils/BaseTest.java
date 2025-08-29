package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Add an explicit wait (10 seconds default)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load the application URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
        // Wait until the login page is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
