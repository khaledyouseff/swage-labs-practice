package PractiseProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    // I made the all static to be able to call them directly without instantiating object from the class
    //this private constructor prevents direct instantiating from the class
    private WebDriver driver;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    //present

    public  WebElement WaitForElementPresence( By locator) {
    /*we will not wait until a certain condition as
    it is not effective,but we will use lambda expression*/
        LogsUtilities.info("waiting to the element to present:", locator.toString());
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(locator));
        //.until(WebDriver::findElement); instead of .until(driver1 -> driver1.findElement(locator));
    }


    //visible
    public  WebElement WaitForElementVisibility( By locator) {
        LogsUtilities.info("waiting to the element to be visible:", locator.toString());

        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                        {
                            WebElement element = WaitForElementPresence(locator);
                            return element.isDisplayed() ? element : null;
                        }
                );
    }


    //Clickable
    public  WebElement WaitForElementToBeClickable( By locator) {
        LogsUtilities.info("waiting to the element to be clickable:", locator.toString());

        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 ->

                {
                    WebElement element = WaitForElementVisibility( locator);
                    return element.isEnabled() ? element : null;
                }

        );
    }
}
