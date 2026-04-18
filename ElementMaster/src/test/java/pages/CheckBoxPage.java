package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    By elementsCard = By.xpath("//h5[text()='Elements']");
    By checkboxMenu = By.xpath("//span[text()='Check Box']");
    By expandAll = By.cssSelector("button[title='Expand all']");
    By homeCheckbox = By.xpath("//label[@for='tree-node-home']");
    By result = By.id("result");

    public void navigate() {
        scrollTo(elementsCard);
        click(elementsCard);

        scrollTo(checkboxMenu);
        click(checkboxMenu);
    }

    public void selectCheckbox() {

        System.out.println("Expanding checkbox tree");

        scrollTo(expandAll);
        wait.until(ExpectedConditions.elementToBeClickable(expandAll));

        WebElement expand = driver.findElement(expandAll);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", expand);

        System.out.println("Clicking home checkbox");

        scrollTo(homeCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(homeCheckbox));

        WebElement checkbox = driver.findElement(homeCheckbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }

    public String getResult() {
        return getText(result);
    }
}