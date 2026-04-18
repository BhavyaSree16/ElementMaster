package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.WindowsPage;

public class WindowsTest extends BaseTest {

    @Test
    public void testWindow() {

        System.out.println("Starting window test");

        WindowsPage page = new WindowsPage(driver);
        page.navigate();

        String title = page.getNewTabTitle();

        Assert.assertTrue(title.contains("DEMOQA"));

        System.out.println("Window test completed");
    }
}