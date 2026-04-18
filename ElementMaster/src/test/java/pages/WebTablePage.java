package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    By elementsCard = By.xpath("//h5[text()='Elements']");
    By webTableMenu = By.xpath("//span[text()='Web Tables']");
    By addButton = By.id("addNewRecordButton");

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");

    By searchBox = By.id("searchBox");

    public void navigate() {
        scrollTo(elementsCard);
        click(elementsCard);

        scrollTo(webTableMenu);
        click(webTableMenu);
    }

    public void addRecord(String fname, String lname, String mail, String ageVal, String salaryVal, String dept) {

        System.out.println("Clicking add button");
        click(addButton);

        System.out.println("Entering data");
        type(firstName, fname);
        type(lastName, lname);
        type(email, mail);
        type(age, ageVal);
        type(salary, salaryVal);
        type(department, dept);

        System.out.println("Submitting record");
        click(submit);
    }

    public void searchRecord(String name) {

        System.out.println("Searching record");

        WebElement box = wait.until(
            ExpectedConditions.elementToBeClickable(searchBox)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", box);

        box.clear();
        box.sendKeys(name);
    }

    public boolean isRecordPresent(String name) {
        return driver.getPageSource().contains(name);
    }

    public void deleteFirstRow(String name) {

        System.out.println("Searching record before deleting");
        searchRecord(name);

        System.out.println("Waiting for filtered row");

        By row = By.xpath("//div[@class='rt-tbody']//div[@role='row']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(row));

        System.out.println("Clicking first delete button");

        By deleteBtn = By.xpath("(//span[@title='Delete'])[1]");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isRecordDeleted(String name) {
        return !driver.getPageSource().contains(name);
    }

    public boolean isPaginationWorking() {

        System.out.println("Checking pagination");

        try {
            WebElement next = driver.findElement(By.xpath("//button[text()='Next']"));
            return next.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}