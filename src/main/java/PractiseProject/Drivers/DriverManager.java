package PractiseProject.Drivers;

import PractiseProject.Utilities.LogsUtilities;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import static org.testng.Assert.fail;

public class DriverManager {
    /* in case i wanted to execute parallel execution so only one initialized instance
    is thrown so i can open more than one session
    with its instance(Ensures Each Thread Has Its Own WebDriver Instance)*/
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    public static WebDriver CreateDriver(String BrowserName) {
        WebDriver driver = BrowserFactory.GetBrowser(BrowserName);
        LogsUtilities.info("Driver created on:", BrowserName);
        setDriver(driver);
        return getDriver();
    }
    /*This ensures each test thread gets its own WebDriver instance.
    Prevents conflicts when running multiple tests in parallel:*/
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            LogsUtilities.error("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }
    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }

}
