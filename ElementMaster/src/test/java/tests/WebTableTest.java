package tests;

import base.BaseTest;
import org.testng.annotations.*;
import org.testng.Assert;
import pages.WebTablePage;
import pages.WidgetsPage;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class WebTableTest extends BaseTest {

    @DataProvider(name = "tableData")
    public Object[][] data() {

        System.out.println("Loading data from config");

        return new Object[][]{
                {
                        ConfigReader.get("firstname"),
                        ConfigReader.get("lastname"),
                        ConfigReader.get("email"),
                        ConfigReader.get("age"),
                        ConfigReader.get("salary"),
                        ConfigReader.get("department")
                }
        };
    }

    @Test(dataProvider = "tableData", priority = 1)
    public void testAddRecord(String fname, String lname, String email, String age, String salary, String dept) {

        System.out.println("Starting add record test");

        WebTablePage page = new WebTablePage(driver);

        page.navigate();
        page.addRecord(fname, lname, email, age, salary, dept);

        Assert.assertTrue(page.isRecordPresent(fname));

        System.out.println("Add record test completed");
    }

    @Test(priority = 2)
    public void testSlider() {

        System.out.println("Starting slider test");

        WidgetsPage page = new WidgetsPage(driver);
        page.navigateToSlider();

        try {

            String value = ConfigReader.get("sliderValue");

            page.moveSlider(value);

            String actual = page.getSliderValue();

            int actualVal = Integer.parseInt(actual);
            int expectedVal = Integer.parseInt(value);

            System.out.println("Slider value is " + actualVal);

            Assert.assertTrue(
                actualVal >= expectedVal - 2 && actualVal <= expectedVal + 2,
                "Slider value is not within expected range"
            );

        } catch (Throwable e) {

            System.out.println("Slider test failed taking screenshot");

            ScreenshotUtil.capture(driver, "SliderFailure");

            Assert.fail("Slider test failed");
        }
    }

    @Test(dataProvider = "tableData", priority = 3)
    public void testDeleteRecord(String fname, String lname, String email, String age, String salary, String dept) {

        System.out.println("Starting delete test");

        WebTablePage page = new WebTablePage(driver);

        page.navigate();

        try {
            System.out.println("Adding record before deleting");
            page.addRecord(fname, lname, email, age, salary, dept);

            System.out.println("Deleting first matching row");
            page.deleteFirstRow(fname);

            System.out.println("Verifying record deletion");
            Assert.assertTrue(page.isRecordDeleted(fname));

        } catch (Exception e) {

            System.out.println("Element not interactable, capturing screenshot");
            ScreenshotUtil.capture(driver, "DeleteFailure");

            Assert.fail("Delete failed due to element interaction issue");
        }

        System.out.println("Delete test completed");
    }

    @Test(priority = 4)
    public void testPagination() {

        System.out.println("Starting pagination test");

        WebTablePage page = new WebTablePage(driver);

        page.navigate();

        Assert.assertTrue(page.isPaginationWorking());

        System.out.println("Pagination test completed");
    }
}