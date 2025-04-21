package PractiseProject.Pages;

import PractiseProject.Utilities.BrowserActions;
import PractiseProject.Utilities.ElementAction;
import PractiseProject.Utilities.LogsUtilities;
import PractiseProject.Utilities.PropertiesUtilities;
import com.google.common.base.FinalizablePhantomReference;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.lang.reflect.Field;

public class HomePage {
    //variables
    private WebDriver driver;

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //locators

    //actions
    public HomePage navigateToHomePage(){
        BrowserActions.GoToBrowser(driver , PropertiesUtilities.getPropertyValue("homeURL"));
        return this;
    }
    public HomePage addToItemTOCart(String productName) {
        LogsUtilities.info("Adding" + productName + "to cart");
        By addToCart = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='"+ productName +"']"));
        ElementAction.FindElement(driver , addToCart);
        ElementAction.ClickElement(driver,addToCart);
        return this;
    }
    //validations

}
