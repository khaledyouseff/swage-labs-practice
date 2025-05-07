package PractiseProject.Pages;

import PractiseProject.Drivers.MyDriver;
import PractiseProject.Utilities.CustomSoftAssertion;
import PractiseProject.Utilities.ElementAction;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    // variables
    MyDriver driver;

    //constructor
    public CartPage(MyDriver driver) {
        this.driver = driver;
    }

    //locators
    By removeButton = By.id("remove-sauce-labs-backpack");
    By itemTitle = By.id("item_4_title_link");
    By itemPrice = By.cssSelector(".inventory_item_price");
    By checkoutButton = By.id("checkout");

    //actions
    @Step("Get item name")
    public String getItemName() {
        return driver.element().GetText( itemTitle);
    }
    @Step("Get item price")
    public String getItemPrice() {
        return driver.element().GetText( itemPrice);
    }
    @Step("Click checkout button")
    public CheckoutInfoPage ClickOnCheckoutButton() {
        driver.element().ClickElement( checkoutButton);
        return new CheckoutInfoPage(driver);
    }

    //validations
    @Step("Assert item details")
    public CartPage assertItemDetails(String itemName, String itemPrice) {
        String actualItemName = getItemName();
        String actualItemPrice = getItemPrice();
        CustomSoftAssertion.softAssertion.assertEquals(actualItemName, itemName, "item name mismatch");
        CustomSoftAssertion.softAssertion.assertEquals(actualItemPrice, itemPrice, "item price mismatch");
        return this;
    }

}
