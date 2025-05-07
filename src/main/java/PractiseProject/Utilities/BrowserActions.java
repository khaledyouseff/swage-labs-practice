package PractiseProject.Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to URL: {URL}")
    public  void GoToBrowser( String URL) {
        driver.get(URL);
        LogsUtilities.info("Navigated to URL:", URL);
    }

    @Step("Getting current URL")
    public  String GetCurrentBrowserURL() {
        LogsUtilities.info("Current URL:", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step("Getting page title")
    public  String GetPageTitle() {
        LogsUtilities.info("Current page title:", driver.getTitle());
        return driver.getTitle();
    }

    @Step("Refreshing the page")
    public  void RefreshPage() {
        driver.navigate().refresh();
        LogsUtilities.info("Refreshing the browser");

    }

    @Step("Quiting the browser")
    public  void quitBrowser() {

        driver.quit();
        LogsUtilities.info("Quiting the browser");

    }
}
