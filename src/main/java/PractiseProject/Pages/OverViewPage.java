package PractiseProject.Pages;

import PractiseProject.Utilities.ElementAction;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage {
    //variables
    WebDriver driver;
    //Locators
    private final By finishButton = By.id("finish");
    //Constructor

    public OverViewPage(WebDriver driver) {
        this.driver = driver;
    }
    //actions
    @Step("Click finish button")
    public ConfirmationPage clickFinishButton(){
        ElementAction.ClickElement(driver, finishButton);
        return new ConfirmationPage(driver);
    }

}
