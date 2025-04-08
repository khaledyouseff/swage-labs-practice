package PractiseProject.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;
import java.util.Objects;

public class BrowserFactory {
    public static WebDriver GetBrowser(String BrowserName){
        //.toLowerCase() to neglect upper or lower case letters
        switch(BrowserName.toLowerCase()){
            case "chrome" :
                ChromeOptions chromeOptions = getChromeOptions();

                return new ChromeDriver(chromeOptions);
            case "firefox" :
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("--disable-infobars");
                firefoxOptions.addArguments("--remote-allow-origins=*");

                return new FirefoxDriver(firefoxOptions);

            default :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-infobars");
               // edgeOptions.addArguments("--remote-allow-origins=*");

                return new EdgeDriver(edgeOptions);

        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--remote-allow-origins=*");
        Map<String , Object> ChromePrefs=Map.of("profile.managed_default_content_settings.notification" , false ,
                "credentials_enable_service", false ,
                "profile_password_manager_enabled", false ,
                "autofill.profile_enabled", false);
        chromeOptions.setExperimentalOption("prefs" , ChromePrefs);
        return chromeOptions;
    }
}
