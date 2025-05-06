package PractiseProject.Drivers;

import PractiseProject.Utilities.PropertiesUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxFactory extends AbstractDriver implements WebDriverOptionsAbstract<FirefoxOptions>{
    @Override
    public FirefoxOptions getOptions() {
        WebDriverManager.chromedriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--remote-allow-origins=*");

        System.out.println("executionType: '" + PropertiesUtilities.getPropertyValue("executionType") + "'");

        if (!PropertiesUtilities.getPropertyValue("executionType").equalsIgnoreCase("Local")) {
            firefoxOptions.addArguments("--headless");
        }

        return firefoxOptions;
    }
    @Override
    public WebDriver StartDriver(){
        return new FirefoxDriver(getOptions());
    }
}
