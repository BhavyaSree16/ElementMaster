package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    By menu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    By nestedFramesMenu = By.xpath("//span[text()='Nested Frames']");

    By parentFrame = By.id("frame1");
    By childFrame = By.xpath("//iframe[contains(@srcdoc,'Child')]");

    By bodyText = By.tagName("body");

    public void navigate() {

        System.out.println("Navigating to nested frames page");

        scrollTo(menu);
        click(menu);

        scrollTo(nestedFramesMenu);
        click(nestedFramesMenu);
    }

    public String getParentFrameText() {

        System.out.println("Switching to parent frame");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(parentFrame));

        String text = driver.findElement(bodyText).getText();

        System.out.println("Parent frame text is " + text);

        return text;
    }

    public String getChildFrameText() {

        System.out.println("Switching to child frame");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(childFrame));

        String text = driver.findElement(bodyText).getText();

        System.out.println("Child frame text is " + text);

        return text;
    }

    public void switchToMainPage() {

        System.out.println("Switching back to main content");

        driver.switchTo().defaultContent();
    }

    public boolean isMainPageAccessible() {

        System.out.println("Checking main page access");

        try {
            WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[text()='Nested Frames']")
                )
            );
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}