package PractiseProject.Drivers;

import PractiseProject.Utilities.PropertiesUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeFactory extends AbstractDriver implements WebDriverOptionsAbstract<EdgeOptions> {
    @Override
    public EdgeOptions getOptions() {
        WebDriverManager.chromedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        // edgeOptions.addArguments("--remote-allow-origins=*");

        System.out.println("executionType: '" + PropertiesUtilities.getPropertyValue("executionType") + "'");
        if (!PropertiesUtilities.getPropertyValue("executionType").equalsIgnoreCase("Local")) {
            edgeOptions.addArguments("--headless");
        }

        return edgeOptions;
    }
    @Override
    public WebDriver StartDriver(){
        return new EdgeDriver(getOptions());
    }
}
