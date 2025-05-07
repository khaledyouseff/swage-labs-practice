package PractiseProject.Pages;
import PractiseProject.Drivers.MyDriver;
import PractiseProject.Utilities.BrowserActions;
import PractiseProject.Utilities.CustomSoftAssertion;
import PractiseProject.Utilities.ElementAction;
import PractiseProject.Utilities.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static PractiseProject.Utilities.PropertiesUtilities.getPropertyValue;

public class LoginPage {
    private final MyDriver driver;
//why private??? : to follow encapsulation.

    //Locators
    private final By UserName = By.id("user-name");
    private final By PassWord = By.id("password");
    private final By LogInButton = By.id("login-button");
    private final By LoginErrorMessage = By.className("data-test='error'");

    //Constructor

    public LoginPage(MyDriver driver) {
        this.driver = driver;
    }

    //Actions -->   WE need to 1-wait  2- scroll 3-find  4-make action
    /*So we need to put the repeated functions of finding elements , waits and scrolls
    in separated package so we invoke the method every time without repeating code*/

    // It is recommended to start each page class with navigation method and end it with assertion method

    //navigation method:
    @Step("Navigate to Login Page")
    public void GoToLoginPage() {
        //this browser is inside MyDriver class that returns object from BrowserElement class
        driver.browser().GoToBrowser( getPropertyValue("baseURL"));
    }

    //Actions on login elements
    @Step("Enter username")
    public LoginPage SetUserNameField(String UserNameText) {
        driver.element().SendData( UserName, UserNameText);
        return new LoginPage(driver);
        //or return this;
    }
    @Step("Enter Password")
    public LoginPage SetPasswordField(String PasswordText) {
        driver.element().SendData( PassWord, PasswordText);
        return new LoginPage(driver);
        //or return this;
    }
    @Step("Click login button")
    public LoginPage ClickLoginButton() {
       driver.element().ClickElement(LogInButton);
        return new LoginPage(driver);
    }


    //Validations
    //hard assertions:

    //we will  assert that if the new url of homepage is displayed that it is successful , otherwise check error msg
    //Not that we need to change the scope of testng in pom.xml file from test to compile
    public HomePage AssertSuccessLogin() {
       driver.validate().AssertPageURL( getPropertyValue("homeURL"));
        driver.validate().AssertPageTitle(getPropertyValue("homePageTitle"));
        return new HomePage(driver);

    }

    public LoginPage AssertFailedLogin() {
        driver.validate().AssertEquals(driver.element().GetText(LoginErrorMessage),
                getPropertyValue("errorMessage"), "Login Failed");
        return new LoginPage(driver);
    }
    //soft assertions:

    public LoginPage SoftAssertLoginPageURL() {
        /*softAssertion object is declared as public static inside CustomSoftAssertion public class,
         which means it belongs to the class itself, not an instance.
         Since it is static, you can access it using the class name as follows:*/
        CustomSoftAssertion.softAssertion.assertEquals(driver.browser().GetCurrentBrowserURL(),
                getPropertyValue("homeURL") , "URL is not as expected");
        return new LoginPage(driver);
    }
    public LoginPage SoftAssertLoginPageTitle() {
        CustomSoftAssertion.softAssertion.assertEquals(driver.browser().GetCurrentBrowserURL(),
                getPropertyValue("homePageTitle") , "Title is not as expected");

        return new LoginPage(driver);
    }
    public LoginPage SoftAssertSuccessfulLoginPage(){
        SoftAssertLoginPageURL().SoftAssertLoginPageTitle();
       /*CustomSoftAssertion.customAssertAll();  // Validate all soft assertions at once but i added it in tearup
        ()method to assert them before quit the browser*/
        return new LoginPage(driver);
    }

}