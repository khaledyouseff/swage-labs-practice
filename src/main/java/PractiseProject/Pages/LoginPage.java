package PractiseProject.Pages;

import PractiseProject.Utilities.BrowserActions;
import PractiseProject.Utilities.ElementAction;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static PractiseProject.Utilities.BrowserActions.GoToBrowser;

public class LoginPage {
    private final WebDriver driver;
//why private??? : to follow encapsulation.

    //Locators
    private final By UserName = By.id("user-name");
    private final By PassWord = By.id("password");
    private final By LogInButton = By.id("login-button");
    private final By LoginErrorMessage = By.className("data-test='error'");

    //Constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    //Actions    WE need to 1-wait  2- scroll 3-find  4-make action
    /*So we need to put the repeated functions of finding elements , waits and scrolls
    in separated package*/

    // It is recommended to start each page class with navigation method and end it with assertion method
    //navigation method:
    public void GoToLoginPage() {
        GoToBrowser(driver, "https://www.saucedemo.com");
    }

    public LoginPage SetUserNameField(String UserNameText) {
      ElementAction.SendData(driver, UserName, UserNameText);
        return new LoginPage(driver);
        //or return this;
    }

    public LoginPage SetPasswordField(String PasswordText) {
        ElementAction.SendData(driver, PassWord, PasswordText);
        return new LoginPage(driver);
        //or return this;
    }

    public LoginPage ClickLoginButton() {
        ElementAction.ClickElement(driver, LogInButton);
        return new LoginPage(driver);
    }


    //Validations
    //we will  assert that if the new url of homepage is displayed that it is successful , otherwise check error msg
    //Not that we need to change the scope of testng in pom.xml file from test to compile
    public LoginPage AssertSuccessLogin() {
        Assert.assertEquals(BrowserActions.GetCurrentBrowserURL(driver), "https://www.saucedemo.com/inventory.html");
        return new LoginPage(driver);

    }

    public LoginPage AssetFailedLogin() {
        Assert.assertEquals(ElementAction.GetText(driver, LoginErrorMessage),
                "Epic sadface: Username and password do not match any user in this service");
        return new LoginPage(driver);
    }
}