package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    By menu = By.xpath("//span[text()='Frames']");
    By frame1 = By.id("frame1");
    By frameText = By.id("sampleHeading");

    public void navigate() {
        click(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        click(menu);
    }

    public String getFrameText() {

        System.out.println("Switching to frame");

        driver.switchTo().frame(driver.findElement(frame1));

        String text = driver.findElement(frameText).getText();

        System.out.println("Frame text is " + text);

        driver.switchTo().defaultContent();

        return text;
    }
}