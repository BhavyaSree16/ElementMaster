package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.AlertsPage;

public class AlertsTest extends BaseTest {

    @Test
    public void testAlerts() {

        System.out.println("Starting alerts test");

        AlertsPage page = new AlertsPage(driver);
        page.navigate();

        //Simple Alert Verification
        String alertText = page.handleSimpleAlert();
        Assert.assertTrue(alertText.contains("You clicked a button"));

        //Confirm Alert Verification
        String confirmText = page.handleConfirmAlert();
        Assert.assertTrue(confirmText.contains("Cancel"));

        //Prompt Alert Verification
        String input = "Bhavya";
        String promptText = page.handlePromptAlert(input);
        Assert.assertTrue(promptText.contains(input));

        System.out.println("Alerts test completed");
    }
}