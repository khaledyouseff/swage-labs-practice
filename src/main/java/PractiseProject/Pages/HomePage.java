package PractiseProject.Pages;

import PractiseProject.Utilities.*;
import com.google.common.base.FinalizablePhantomReference;
import io.qameta.allure.Step;
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
    By CartIcon = By.id("shopping_cart_container");

    //actions
    @Step("navigate to homepage")
    public HomePage navigateToHomePage(){
        BrowserActions.GoToBrowser(driver , PropertiesUtilities.getPropertyValue("homeURL"));
        return this;
    }
    @Step("Add an item to the cart")
    public HomePage addToItemTOCart(String productName) {
        LogsUtilities.info("Adding " + productName + "to cart");
        By addToCart = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='"+ productName +"']"));

        LogsUtilities.info("Locator for adding to cart: " + addToCart);
        ElementAction.FindElement(driver , addToCart);
        ElementAction.ClickElement(driver,addToCart);
        return this;
    }
    @Step("Click  cart icon")
    public CartPage ClickOnCartIcon(){
        ElementAction.ClickElement(driver,CartIcon);
        return new CartPage(driver);
    }
    //validations
    @Step("Assert adding item to the cart")
    public HomePage assertAddItemToCart(String productName){
        By addToCart = RelativeLocator.with(By.tagName("button")).below(By.xpath("//div[.='"+ productName +"']"));

        String actualValue= ElementAction.GetText(driver,addToCart);
        LogsUtilities.info("Actual value is :" + actualValue);
        Validations.AssertEquals(actualValue, "Remove","Product not added to cart");

        return new HomePage(driver);
    }

}
