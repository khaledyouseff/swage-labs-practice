package PractiseProject.Drivers;

import PractiseProject.Utilities.PropertiesUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class ChromeFactory extends AbstractDriver implements WebDriverOptionsAbstract<ChromeOptions>{
    @Override
    public ChromeOptions getOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--remote-allow-origins=*");
        System.out.println("executionType: '" + PropertiesUtilities.getPropertyValue("executionType") + "'");

        if (!PropertiesUtilities.getPropertyValue("executionType").equalsIgnoreCase("Local")) {
            chromeOptions.addArguments("--headless");
        }

        Map<String , Object> ChromePrefs=Map.of("profile.managed_default_content_settings.notification" , false ,
                "credentials_enable_service", false ,
                "profile_password_manager_enabled", false ,
                "autofill.profile_enabled", false);
        chromeOptions.setExperimentalOption("prefs" , ChromePrefs);
        return chromeOptions;

    }
    @Override
    public WebDriver StartDriver(){
        return new ChromeDriver(getOptions());
    }


}

