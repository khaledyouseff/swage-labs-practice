package PractiseProject.Pages;

import PractiseProject.Utilities.CustomSoftAssertion;
import PractiseProject.Utilities.ElementAction;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    // variables
    WebDriver driver;

    //constructor
    public CartPage(WebDriver driver) {
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
        return ElementAction.GetText(driver, itemTitle);
    }
    @Step("Get item price")
    public String getItemPrice() {
        return ElementAction.GetText(driver, itemPrice);
    }
    @Step("Click checkout button")
    public CheckoutInfoPage ClickOnCheckoutButton() {
        ElementAction.ClickElement(driver, checkoutButton);
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
