package pages;

import base.BasePage;
import org.openqa.selenium.*;

import java.util.Set;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    By menu = By.xpath("//span[text()='Browser Windows']");
    By newTabBtn = By.id("tabButton");

    public void navigate() {
        click(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        click(menu);
    }

    public String getNewTabTitle() {

        String parent = driver.getWindowHandle();

        click(newTabBtn);

        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {
            if (!win.equals(parent)) {
                driver.switchTo().window(win);
            }
        }

        String title = driver.getTitle();

        driver.close();
        driver.switchTo().window(parent);

        return title;
    }
}