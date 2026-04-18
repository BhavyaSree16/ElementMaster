package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WidgetsPage extends BasePage {

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    By widgetsCard = By.xpath("//h5[text()='Widgets']");
    By datePickerMenu = By.xpath("//span[text()='Date Picker']");
    By sliderMenu = By.xpath("//span[text()='Slider']");
    By accordionMenu = By.xpath("//span[text()='Accordian']");

    By dateInput = By.id("datePickerMonthYearInput");
    By monthDropdown = By.className("react-datepicker__month-select");
    By yearDropdown = By.className("react-datepicker__year-select");

    By slider = By.xpath("//input[@type='range']");
    By sliderValue = By.id("sliderValue");

    By section1 = By.id("section1Heading");

    public void navigateToDatePicker() {

        System.out.println("Navigating to date picker");

        scrollTo(widgetsCard);
        click(widgetsCard);
        click(datePickerMenu);
    }

    public void selectDate(String day, String month, String year) {

        System.out.println("Selecting date");

        click(dateInput);

        Select m = new Select(driver.findElement(monthDropdown));
        m.selectByVisibleText(month);

        Select y = new Select(driver.findElement(yearDropdown));
        y.selectByVisibleText(year);

        By dayLocator = By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']");
        click(dayLocator);
    }

    public String getSelectedDate() {
        return driver.findElement(dateInput).getAttribute("value");
    }

    public void navigateToSlider() {

        System.out.println("Navigating to slider");

        scrollTo(widgetsCard);
        click(widgetsCard);
        click(sliderMenu);
    }

    public void moveSlider(String value) {

        System.out.println("Moving slider");

        WebElement slide = wait.until(
                ExpectedConditions.elementToBeClickable(slider)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "arguments[0].value='" + value + "'; arguments[0].dispatchEvent(new Event('change'));",
            slide
        );
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getAttribute("value");
    }

    public void navigateToAccordion() {

        System.out.println("Navigating to accordion");

        scrollTo(widgetsCard);
        click(widgetsCard);
        click(accordionMenu);
    }

    public void clickSection1() {
        click(section1);
    }

    public String getSection1State() {
        return driver.findElement(section1).getAttribute("aria-expanded");
    }
}