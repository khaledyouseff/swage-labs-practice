import PractiseProject.Drivers.DriverManager;
import PractiseProject.Pages.LoginPage;
import PractiseProject.Utilities.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static PractiseProject.Utilities.PropertiesUtilities.LoadProperties;

public class LoginTest {
    //variables
    // private WebDriver driver;
    // LoginPage loginPage;  no need for it as we used anonymous object  instead
    String browserName ;
    JsonUtilities testData;

    @BeforeSuite
    public void beforeSuite() {
        PropertiesUtilities.LoadProperties();
        FileUtilities.deleteFiles(new File("test-outputs/allure-results"));
        testData = new JsonUtilities("test_data");
    }

    @BeforeMethod
    public void Setup() {
        // ic created a class to instantiate the driver so i do not need all this
        /*
        EdgeOptions option = new EdgeOptions();
        //to max the window
        option.addArguments("Start-Maximized");
        /*to wait until the page is ready as we do not want to use explicit wait
         as we used it before to avoid concurrency issues :
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(option);
        loginPage = new LoginPage(driver);
        loginPage.GoToLoginPage();*/

        /*or use an anonymous object so instead of:  LoginPage loginPage; loginPage = new LoginPage(driver);
         loginPage.GoToLoginPage(); we will write one line as follows :
         new LoginPage(driver).GoToLoginPage();

         */
        browserName= PropertiesUtilities.getPropertyValue("browserType");
        DriverManager.CreateDriver(browserName);
        new LoginPage(DriverManager.getDriver()).GoToLoginPage();


    }

    //tests
    @Test
    public void SuccessfullLogin() throws IOException {
        /*
        loginPage = new LoginPage(driver);
        loginPage.SetUserNameField("standard_user");
        loginPage.SetPasswordField("secret_sauce");
        loginPage.ClickLoginButton();
        loginPage.AssertSuccessLogin();
        */

        new LoginPage(DriverManager.getDriver()).
                SetUserNameField(testData.getJsonData("successful-Login.username")).
                SetPasswordField(testData.getJsonData("successful-Login.password")).
                ClickLoginButton().AssertSuccessLogin();
        ScreenshotsUtilities.takeScreenshot("Successful login");
        /*in case of soft assertion the following line will be added:
        loginPage.SoftAssertSuccessfulLoginPage();*/


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



/*
    @AfterMethod
    public void TearDown() {
        BrowserActions.quitBrowser(DriverManager.getDriver());
        //we should add this here to asset all the soft validations if we used it in the test class (video #7)
        // CustomSoftAssertion.customAssertAll();
    }
*/
    @AfterClass
    public void AfterClass() {
        AllureUtilities.AttachLogsToAllureReport();
    }


}
