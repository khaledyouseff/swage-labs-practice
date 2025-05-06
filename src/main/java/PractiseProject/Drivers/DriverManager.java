package PractiseProject.Drivers;

import PractiseProject.Utilities.LogsUtilities;
import io.qameta.allure.Step;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import static org.testng.Assert.fail;

public class DriverManager {
    /* in case i wanted to execute parallel execution so only one initialized instance
    is thrown so i can open more than one session
    with its instance(Ensures Each Thread Has Its Own WebDriver Instance)*/
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public DriverManager(String BrowserName) {

        WebDriver driver = getDriver(BrowserName).StartDriver();
        setDriver(driver);
    }

    /*
   // in pom.xml the scope was test so change it to compile so it can be recognized here
   @Step("creating a driver instance for : {BrowserName}")
   public static WebDriver CreateDriver(String BrowserName) {
       WebDriver driver = BrowserFactory.GetBrowser(BrowserName);  // This line creates the driver
       LogsUtilities.info("Driver created on:", BrowserName);
       setDriver(driver);  // stores the driver  in ThreadLocal
       return getDriver(); // returns it for use in tests
   }

  This ensures each test thread gets its own WebDriver instance.
   Prevents conflicts when running multiple tests in parallel:
   public static WebDriver getDriver() {
       if (driverThreadLocal.get() == null) {
           LogsUtilities.error("Driver is null");
           fail("Driver is null");
       }
       return driverThreadLocal.get();
   }
*/
    private AbstractDriver getDriver(String browserName) {
        //code
        return switch (browserName.toLowerCase()) {
            case "chrome" -> new ChromeFactory();
            case "firefox" -> new FireFoxFactory();
            case "edge" -> new EdgeFactory();
            default -> throw new IllegalArgumentException();
        };

    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public WebDriver get() {
        if (driverThreadLocal.get() == null) {
            LogsUtilities.error("Driver is null");
            fail("Driver is null");
            return null;
        }
        return driverThreadLocal.get();
    }

}
