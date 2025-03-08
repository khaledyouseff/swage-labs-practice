package PractiseProject.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class scroll {
    public static void ScrollToElement(WebDriver driver , By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" ,driver.findElement(locator));
    }

}
