package PractiseProject.Utilities;

import PractiseProject.Drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    @Step("Navigate to URL: {URL}")
    public static void GoToBrowser(WebDriver driver , String URL){
        driver.get(URL);
        LogsUtilities.info("Navigated to URL:" , URL);
    }
    @Step("Getting current URL")
    public static String GetCurrentBrowserURL(WebDriver driver){
        LogsUtilities.info("Current URL:" , driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    @Step("Getting page title")
    public static String GetPageTitle(WebDriver driver){
        LogsUtilities.info("Current page title:" , driver.getTitle());
        return driver.getTitle();
    }
    @Step("Refreshing the page")
    public static void  RefreshPage(WebDriver driver){
         driver.navigate().refresh();
         LogsUtilities.info("Refreshing the browser");

    }
    @Step("Quiting the browser")
    public static void quitBrowser(WebDriver driver){

        driver.quit();
        LogsUtilities.info("Quiting the browser");

    }
}
