package tests;

import base.BaseTest;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.*;
import utils.*;

public class FormTest extends BaseTest {

    @DataProvider(name = "formData")
    public Object[][] data() {
        System.out.println("Loading test data from config properties");
        return new Object[][]{
                {
                        ConfigReader.get("firstname"),
                        ConfigReader.get("lastname"),
                        ConfigReader.get("email"),
                        ConfigReader.get("mobile")
                }
        };
    }

    @Test(dataProvider = "formData", priority = 1)
    public void testFormSubmission(String fname, String lname, String email, String mobile) {

        System.out.println("Starting form submission test");

        FormPage form = new FormPage(driver);

        System.out.println("Navigating to practice form");
        form.navigateToForm();

        System.out.println("Filling form data");
        form.fillForm(fname, lname, email, mobile);

        System.out.println("Submitting form");
        form.submitForm();

        System.out.println("Verifying form submission");
        Assert.assertTrue(form.isFormSubmitted());

        System.out.println("Form submission test completed");
    }

    @Test(priority = 2)
    public void testRadioButton() {

        System.out.println("Starting radio button test");

        RadioButtonPage radio = new RadioButtonPage(driver);

        System.out.println("Navigating to radio button page");
        radio.navigate();

        System.out.println("Selecting yes radio button");
        radio.selectYes();

        String result = radio.getResult();
        System.out.println("Selected value is " + result);

        Assert.assertEquals(result, "Yes");

        System.out.println("Radio button test completed");
    }

    @Test(priority = 3)
    public void testCheckbox() {

        System.out.println("Starting checkbox test");

        CheckBoxPage cb = new CheckBoxPage(driver);

        cb.navigate();

        try {
            System.out.println("Trying to select checkbox");

            cb.selectCheckbox();

            String result = cb.getResult();
            System.out.println("Checkbox result is " + result);

            Assert.assertTrue(result.toLowerCase().contains("home"));

            System.out.println("Checkbox test passed");

        } catch (Exception e) {

            System.out.println("Checkbox selection failed");
            System.out.println("Capturing screenshot");

            ScreenshotUtil.capture(driver, "CheckboxFailure");

            // Fail the test properly (important for evaluation)
            Assert.fail("Checkbox test failed. Screenshot captured.");
        }
    }

    @Test(priority = 4)
    public void testEmptyFormValidation() {

        System.out.println("Starting empty form validation test");

        FormPage form = new FormPage(driver);

        System.out.println("Navigating to practice form");
        form.navigateToForm();

        System.out.println("Submitting empty form");
        form.submitForm();

        boolean submitted = form.isFormSubmitted();
        System.out.println("Form submitted status is " + submitted);

        if (!submitted) {
            System.out.println("Capturing screenshot for empty form");
            ScreenshotUtil.capture(driver, "EmptyForm");
        }

        System.out.println("Verifying form is not submitted");
        Assert.assertFalse(submitted);

        System.out.println("Empty form validation test completed");
    }
}