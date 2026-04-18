package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import org.testng.annotations.*;
import utils.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseUrl"));

        // ✅ wait until page loads
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h5[text()='Forms']")));
    }

    @AfterMethod
    public void teardown() {
        if (driver != null)
            driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}