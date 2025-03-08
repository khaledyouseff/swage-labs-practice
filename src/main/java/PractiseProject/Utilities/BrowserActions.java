package PractiseProject.Utilities;

import org.openqa.selenium.WebDriver;

public class BrowserActions {

    public static void GoToBrowser(WebDriver driver , String URL){
        driver.get(URL);
    }
    public static String GetCurrentBrowserURL(WebDriver driver){
       return driver.getCurrentUrl();
    }
}
