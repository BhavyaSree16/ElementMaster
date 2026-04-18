package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class RadioButtonPage extends BasePage {

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    By elementsCard = By.xpath("//h5[text()='Elements']");
    By radioMenu = By.xpath("//span[text()='Radio Button']");
    By yesRadio = By.xpath("//label[text()='Yes']");
    By result = By.className("text-success");

    public void navigate() {
        click(elementsCard);
        click(radioMenu);
    }

    public void selectYes() {
        click(yesRadio);
    }

    public String getResult() {
        return getText(result);
    }
}