package PractiseProject.Pages;

import PractiseProject.Utilities.CustomSoftAssertion;
import PractiseProject.Utilities.ElementAction;
import PractiseProject.Utilities.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {

    //variables
    WebDriver driver;

    //constructor
    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    //actions
    @Step("Filling info form data")
    public CheckoutInfoPage fillInformationForm(String firstName, String lastName, String postalCode) {
        ElementAction.SendData(driver, this.firstName, firstName);
        ElementAction.SendData(driver, this.lastName, lastName);
        ElementAction.SendData(driver, this.postalCode, postalCode);
        return this;
    }

    @Step("Click continue button")
    public OverViewPage clickContinueButton() {
        ElementAction.ClickElement(driver, continueButton);
        return new OverViewPage(driver);
    }

    //validation
    @Step("assert data into the fields of checkout page")
    public CheckoutInfoPage assertInformationPageData(String firstName, String lastName, String postalCode) {
        CustomSoftAssertion.softAssertion.assertEquals(ElementAction.GetValueFromInputField(driver,this.firstName),firstName);
        CustomSoftAssertion.softAssertion.assertEquals(ElementAction.GetValueFromInputField(driver,this.lastName),lastName);
        CustomSoftAssertion.softAssertion.assertEquals(ElementAction.GetValueFromInputField(driver,this.firstName),firstName);
        return new CheckoutInfoPage(driver);
    }


}