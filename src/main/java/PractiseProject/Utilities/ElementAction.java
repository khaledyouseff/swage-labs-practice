package PractiseProject.Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementAction {

    private WebDriver driver;
    // added these two bots waits and scroll
    private Waits waits;


    public ElementAction(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);

    }

    @Step("Sending data : {data} to element : {locator}")
    public void SendData(By locator, String data) {
        waits.WaitForElementVisibility(locator);
        ScrollToElement(locator);
        FindElement(locator).sendKeys(data);
        LogsUtilities.info("data entered is :", data, " in field:", locator.toString());
    }

    @Step("Clicking the element : {locator}")
    public void ClickElement(By locator) {
        waits.WaitForElementToBeClickable(locator);
        ScrollToElement(locator);
        FindElement(locator).click();
        LogsUtilities.info("click on element:", locator.toString());
    }

    public WebElement FindElement(By locator) {
        LogsUtilities.info("Finding element:", locator.toString());

        return driver.findElement(locator);
    }

    @Step("Getting text of the element : {locator}")
    public String GetText(By locator) {
        LogsUtilities.info("Getting the text of the element:", locator.toString(), "text", FindElement(locator).getText());

        waits.WaitForElementVisibility(locator);
        ScrollToElement(locator);
        return FindElement(locator).getText();
    }

    //this method to get a text from input field that has the tag : value
    public String GetValueFromInputField(By locator) {
        LogsUtilities.info("Getting the text of the element:", locator.toString(), "text", FindElement(locator).getDomAttribute("Value"));
        waits.WaitForElementVisibility(locator);
        ScrollToElement(locator);
        return FindElement(locator).getDomAttribute("Value");
    }
    @Step("Scroll to the element : {locator}")

    public void ScrollToElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"
                , FindElement(locator));
        LogsUtilities.info("Scrolling to the element", locator.toString());
    }

}
