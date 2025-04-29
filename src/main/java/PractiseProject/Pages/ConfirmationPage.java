package PractiseProject.Pages;

import PractiseProject.Utilities.ElementAction;
import PractiseProject.Utilities.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    //variables
    WebDriver driver;
    //Locators
    private final By completeMessage = By.cssSelector(".complete-header");
    //Constructor
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }
    //actions
    @Step("getting confirmation message")
    public String getConfirmationMessage(){
        return ElementAction.GetText(driver,completeMessage);
    }
    //
    @Step("assert that the message is correct")
    public void assertConfirmationMessage(String ExpectedMessage){
        String actualMessage= getConfirmationMessage();
        Validations.AssertEquals(actualMessage
                , ExpectedMessage , "this message is not correct");
    }

}
