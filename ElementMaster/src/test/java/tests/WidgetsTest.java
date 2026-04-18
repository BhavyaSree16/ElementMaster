package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.WidgetsPage;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class WidgetsTest extends BaseTest {

    @Test(priority = 1)
    public void testDatePicker() {

        System.out.println("Starting date picker test");

        WidgetsPage page = new WidgetsPage(driver);
        page.navigateToDatePicker();

        try {

            String day = ConfigReader.get("date");
            String month = ConfigReader.get("month");
            String year = ConfigReader.get("year");

            page.selectDate(day, month, year);

            String selected = page.getSelectedDate();

            System.out.println("Selected date is " + selected);

            Assert.assertTrue(selected.contains(day));

        } catch (Exception e) {

            System.out.println("Date picker failed taking screenshot");
            ScreenshotUtil.capture(driver, "DatePickerFailure");
            Assert.fail("Date picker test failed");
        }
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

        } catch (Exception e) {

            System.out.println("Slider test failed taking screenshot");
            ScreenshotUtil.capture(driver, "SliderFailure");
            Assert.fail("Slider test failed");
        }
    }

    @Test(priority = 3)
    public void testAccordion() {

        System.out.println("Starting accordion test");

        WidgetsPage page = new WidgetsPage(driver);
        page.navigateToAccordion();

        try {

            String before = page.getSection1State();

            System.out.println("Section state before click is " + before);

            page.clickSection1();

            Thread.sleep(1000);

            String after = page.getSection1State();

            System.out.println("Section state after click is " + after);

            Assert.assertNotEquals(before, after, "Accordion did not toggle");

        } catch (Exception e) {

            System.out.println("Accordion test failed taking screenshot");
            ScreenshotUtil.capture(driver, "AccordionFailure");
            Assert.fail("Accordion test failed");
        }
    }
}