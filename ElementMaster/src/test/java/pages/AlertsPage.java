package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    By alertsCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    By alertsMenu = By.xpath("//span[text()='Alerts']");

    By alertButton = By.id("alertButton");
    By confirmButton = By.id("confirmButton");
    By promptButton = By.id("promtButton");

    By confirmResult = By.id("confirmResult");
    By promptResult = By.id("promptResult");

    public void navigate() {
        scrollTo(alertsCard);
        click(alertsCard);
        click(alertsMenu);
    }

    // ✅ Simple Alert
    public String handleSimpleAlert() {

        click(alertButton);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();

        alert.accept();

        return text;
    }

    // ✅ Confirm Alert
    public String handleConfirmAlert() {

        click(confirmButton);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        return getText(confirmResult);
    }

    // ✅ Prompt Alert
    public String handlePromptAlert(String input) {

        click(promptButton);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(input);
        alert.accept();

        return getText(promptResult);
    }
}