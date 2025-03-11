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
                ChromeOptions ChromeOptions = new ChromeOptions();
                ChromeOptions.addArguments("--start-maximized");
                ChromeOptions.addArguments("--disable-notifications");
                ChromeOptions.addArguments("--disable-extensions");
                ChromeOptions.addArguments("--disable-infobars");
                ChromeOptions.addArguments("--remote-allow-origins=*");
                Map<String , Object> ChromePrefs=Map.of("profile.managed_default_content_settings.notification" , false ,
                        "credentials_enable_service", false ,
                        "profile_password_manager_enabled", false ,
                        "autofill.profile_enabled", false);
                ChromeOptions.setExperimentalOption("prefs" , ChromePrefs);

                return new ChromeDriver(ChromeOptions);
            case "firefox" :
                FirefoxOptions FirefoxOptions = new FirefoxOptions();
                FirefoxOptions.addArguments("--start-maximized");
                FirefoxOptions.addArguments("--disable-notifications");
                FirefoxOptions.addArguments("--disable-extensions");
                FirefoxOptions.addArguments("--disable-infobars");
                FirefoxOptions.addArguments("--remote-allow-origins=*");
                
                return new FirefoxDriver(FirefoxOptions);

            default :
                EdgeOptions EdgeOptions = new EdgeOptions();
                EdgeOptions.addArguments("--start-maximized");
                EdgeOptions.addArguments("--disable-notifications");
                EdgeOptions.addArguments("--disable-extensions");
                EdgeOptions.addArguments("--disable-infobars");
                EdgeOptions.addArguments("--remote-allow-origins=*");

                return new EdgeDriver(EdgeOptions);

        }
    }
}
