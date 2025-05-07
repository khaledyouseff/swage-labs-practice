package PractiseProject.Pages;

import PractiseProject.Drivers.MyDriver;
import PractiseProject.Utilities.CustomSoftAssertion;
import PractiseProject.Utilities.ElementAction;
import PractiseProject.Utilities.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {

    //variables
    MyDriver driver;

    //constructor
    public CheckoutInfoPage(MyDriver driver) {
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
        driver.element().SendData(this.firstName, firstName);
        driver.element().SendData( this.lastName, lastName);
        driver.element().SendData( this.postalCode, postalCode);
        return this;
    }

    @Step("Click continue button")
    public OverViewPage clickContinueButton() {
        driver.element().ClickElement( continueButton);
        return new OverViewPage(driver);
    }

    //validation
    @Step("assert data into the fields of checkout page")
    public CheckoutInfoPage assertInformationPageData(String firstName, String lastName, String postalCode) {
        CustomSoftAssertion.softAssertion.assertEquals(driver.element().GetValueFromInputField(this.firstName),firstName);
        CustomSoftAssertion.softAssertion.assertEquals(driver.element().GetValueFromInputField(this.lastName),lastName);
        CustomSoftAssertion.softAssertion.assertEquals(driver.element().GetValueFromInputField(this.firstName),firstName);
        return new CheckoutInfoPage(driver);
    }


}