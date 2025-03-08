import PractiseProject.Pages.LoginPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    //variable
    private WebDriver driver;
    LoginPage loginPage;

    //tests
    @Test
    public void SuccessfullLogin() {
        loginPage = new LoginPage(driver);
        loginPage.SetUserNameField("standard_user");
        loginPage.SetPasswordField("secret_sauce");
        loginPage.ClickLoginButton();
        loginPage.AssertSuccessLogin();
        //new(LoginPage).SetUserNameField("standard_user").SetPasswordField("standard_user").ClickLoginButton().AssertSuccessLogin();

        /*or use an anonymous object so instead of:  LoginPage loginPage; loginPage = new LoginPage(driver);
         loginPage.GoToLoginPage(); we will write one line as follows :
         new(LoginPage).SetUserNameField("standard_user").SetPasswordField("standard_user")
         .ClickLoginButton().AssertSuccessLogin();
         BUT this will not respond because the return type of this methods in LoginPage class is void
         So we need to adjust the return type from void to LoginPage in the methods
         this is called: Fluent Pattern Approach So Each method in the class return an object from the class or
         other class so we can call them in one line
         */

    }

    //configurations
    @BeforeMethod
    public void Setup() {
        EdgeOptions option = new EdgeOptions();
        //to max the window
        option.addArguments("Start-Maximized");
        /*to wait until the page is ready as we do not want to use explicit wait
         as we used it before to avoid concurrency issues*/
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(option);
        loginPage = new LoginPage(driver);
        loginPage.GoToLoginPage();
        /*or use an anonymous object so instead of:  LoginPage loginPage; loginPage = new LoginPage(driver);
         loginPage.GoToLoginPage(); we will write one line as follows :
         new(LoginPage).driver.GoToLoginPage();
         */


    }
/*
    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
    */

}
