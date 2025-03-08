package PractiseProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementAction {

    public static void SendData(WebDriver driver, By locator ,String data){
        Waits.WaitForElementVisibility(driver , locator);
        Scroll.ScrollToElement(driver,locator);
        FindElement(driver,locator).sendKeys(data);  }

    public static void ClickElement(WebDriver driver , By locator){
        Waits.WaitForElementVisibility(driver , locator);
        Scroll.ScrollToElement(driver,locator);
        FindElement(driver,locator).click();
    }

    public static WebElement FindElement(WebDriver driver , By locator){

       return driver.findElement(locator);
    }
    public static String GetText(WebDriver driver , By locator){
        Waits.WaitForElementVisibility(driver , locator);
        Scroll.ScrollToElement(driver,locator);
      return   FindElement(driver,locator).getText();
    }

}
