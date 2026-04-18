package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.FramesPage;

public class FramesTest extends BaseTest {

    @Test
    public void testFrame() {

        System.out.println("Starting frame test");

        FramesPage page = new FramesPage(driver);

        page.navigate();

        String text = page.getFrameText();

        Assert.assertTrue(text.contains("sample"));

        System.out.println("Frame test completed");
    }
}