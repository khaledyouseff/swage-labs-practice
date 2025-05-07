package PractiseProject.Pages;

import PractiseProject.Drivers.MyDriver;
import PractiseProject.Utilities.ElementAction;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage {
    //variables
    MyDriver driver;
    //Locators
    private final By finishButton = By.id("finish");
    //Constructor

    public OverViewPage(MyDriver driver) {
        this.driver = driver;
    }
    //actions
    @Step("Click finish button")
    public ConfirmationPage clickFinishButton(){
        driver.element().ClickElement( finishButton);
        return new ConfirmationPage(driver);
    }

}
