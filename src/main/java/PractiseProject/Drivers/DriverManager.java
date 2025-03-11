package PractiseProject.Drivers;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;

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
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            fail("driver is null");
        }
        return driverThreadLocal.get();
    }
    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }
}
