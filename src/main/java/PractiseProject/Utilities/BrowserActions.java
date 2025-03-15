package PractiseProject.Utilities;

import PractiseProject.Drivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    public static void GoToBrowser(WebDriver driver , String URL){
        driver.get(URL);
        LogsUtilities.info("Navigated to URL:" , URL);
    }
    public static String GetCurrentBrowserURL(WebDriver driver){
        LogsUtilities.info("Current URL:" , driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public static String GetPageTitle(WebDriver driver){
        LogsUtilities.info("Current page title:" , driver.getTitle());
        return driver.getTitle();
    }
    public static void  RefreshPage(WebDriver driver){
         driver.navigate().refresh();
         LogsUtilities.info("Refreshing the browser");

    }
    public static void quitBrowser(WebDriver driver){

        driver.quit();
        LogsUtilities.info("Quiting the browser");

    }
}
