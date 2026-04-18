package pages;

import base.BasePage;
import org.openqa.selenium.*;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    By formsCard = By.xpath("//h5[text()='Forms']");
    By practiceForm = By.xpath("//span[text()='Practice Form']");

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By gender = By.xpath("//label[text()='Male']");
    By mobile = By.id("userNumber");
    By submit = By.id("submit");

    By successModal = By.id("example-modal-sizes-title-lg");

    public void navigateToForm() {
        System.out.println("Navigating to Form");

        scrollTo(formsCard);
        click(formsCard);

        scrollTo(practiceForm);
        click(practiceForm);
    }

    public void fillForm(String fname, String lname, String mail, String mob) {
        type(firstName, fname);
        type(lastName, lname);
        type(email, mail);
        click(gender);
        type(mobile, mob);
    }

    public void submitForm() {
        scrollTo(submit);
        click(submit);
    }

    public boolean isFormSubmitted() {
        try {
            return isDisplayed(successModal);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorPresent() {
        return driver.findElement(firstName)
                .getAttribute("class")
                .contains("field-error");
    }
}