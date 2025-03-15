package PractiseProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementAction {

    public static void SendData(WebDriver driver, By locator ,String data){
        Waits.WaitForElementVisibility(driver , locator);
        Scroll.ScrollToElement(driver,locator);
        FindElement(driver,locator).sendKeys(data);
        LogsUtilities.info("data entered is :" , data, " in field:", locator.toString());
    }

    public static void ClickElement(WebDriver driver , By locator){
        Waits.WaitForElementToBeClickable(driver , locator);
        Scroll.ScrollToElement(driver,locator);
        FindElement(driver,locator).click();
        LogsUtilities.info("click on element:" ,  locator.toString());
    }

    public static WebElement FindElement(WebDriver driver , By locator){
        LogsUtilities.info("Finding element:" ,  locator.toString());

       return driver.findElement(locator);
    }
    public static String GetText(WebDriver driver , By locator){
        LogsUtilities.info("Getting the text of the element:" ,  locator.toString() , "text" , FindElement(driver,locator).getText());

        Waits.WaitForElementVisibility(driver , locator);
        Scroll.ScrollToElement(driver,locator);
      return   FindElement(driver,locator).getText();
    }

}
