package PractiseProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    // I made the all static to be able to call them directly without instantiating object from the class
    //this private constructor prevents direct instantiating from the class

    private Waits(){}

    //present

public static WebElement WaitForElementPresence(WebDriver driver , By locator){
    /*we will not wait until a certain condition as
    it is not effective,but we will use lambda expression*/

    return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(driver1 -> driver1.findElement(locator));
    //.until(WebDriver::findElement); instead of .until(driver1 -> driver1.findElement(locator));
}


    //visible
    public static WebElement WaitForElementVisibility(WebDriver driver , By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->
                        {
                            WebElement element = WaitForElementPresence(driver,locator);
                            return element.isDisplayed() ? element: null;
                        }
                        );
    }


    //Clickable
    public static WebElement WaitForElementToBeClickable(WebDriver driver, By locator){
    return new WebDriverWait(driver , Duration.ofSeconds(10)).until(driver1->

            {
                WebElement element = WaitForElementVisibility(driver,locator);
                        return element.isEnabled() ? element :null;
            }

            );
    }
}
