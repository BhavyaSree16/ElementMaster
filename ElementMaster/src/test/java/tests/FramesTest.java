package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.FramesPage;
import utils.ScreenshotUtil;

public class FramesTest extends BaseTest {

    @Test
    public void testNestedFrames() {

        System.out.println("Starting nested frame test");

        FramesPage page = new FramesPage(driver);

        page.navigate();

        try {

            String parentText = page.getParentFrameText();
            Assert.assertTrue(parentText.contains("Parent"));

            String childText = page.getChildFrameText();
            Assert.assertTrue(childText.contains("Child"));

            page.switchToMainPage();

            boolean mainVisible = page.isMainPageAccessible();
            Assert.assertTrue(mainVisible);

        } catch (Exception e) {

            System.out.println("Frame test failed taking screenshot");

            ScreenshotUtil.capture(driver, "FrameFailure");

            Assert.fail("Frame test failed");
        }

        System.out.println("Nested frame test completed");
    }
}