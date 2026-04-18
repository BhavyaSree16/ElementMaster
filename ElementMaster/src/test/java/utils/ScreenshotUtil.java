package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String name) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = "reports/screenshots/" + name + ".png";

        try {
            File dest = new File(path);
            dest.getParentFile().mkdirs(); // create folder if not exists
            FileHandler.copy(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}