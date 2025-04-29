import PractiseProject.Drivers.DriverManager;
import PractiseProject.Listeners.TestNGListeners;
import PractiseProject.Pages.*;
import PractiseProject.Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestNGListeners.class) //Without this line the driver will be null as the properties will not be loaded
public class E2E {
    //variables
    // private WebDriver driver;
    // LoginPage loginPage;  no need for it as we used anonymous object  instead
    String browserName;
    JsonUtilities testData;
    WebDriver driver;

    //configurations
    @BeforeClass
    public void beforeClass() {
        // PropertiesUtilities.LoadProperties();  move it to listeners class
        // FileUtilities.deleteFiles(new File("test-outputs/allure-results"));  move it to listeners class
        /* After moving the above lines to lister class i changed the
        annotation from @BeforClass to @BeforMethod as the test data needed to be seen only at the class
        but then returened to @BeforeClass as i added more than test case ,OR the JSON file will be loaded
        before every single test method — which might be slower and redundant if the data doesn't change between tests.
         */

        //Loads a JSON file once when instantiated:
        testData = new JsonUtilities("test_data");
    }

    @BeforeClass // I changed it from before method to before class as i will write more than one method for tests
    public void Setup() {
        // i created a class to instantiate the driver so i do not need all this:
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
        browserName = PropertiesUtilities.getPropertyValue("browserType");
        driver = DriverManager.CreateDriver(browserName);
        new LoginPage(driver).GoToLoginPage();


    }

    //Tests
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
        //  ScreenshotsUtilities.takeScreenshot("Successful login");  moved to listener class
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

    @Test(dependsOnMethods = "SuccessfullLogin")
    public void AddItemToCart() {
        new HomePage(driver).addToItemTOCart(testData.getJsonData("productInfo.product1.name"))
                .assertAddItemToCart(testData.getJsonData("productInfo.product1.name"));
    }

    @Test(dependsOnMethods = "AddItemToCart")
    public void checkoutItem() {
        new HomePage(driver).ClickOnCartIcon().assertItemDetails(
                testData.getJsonData("productInfo.product1.name"), testData.getJsonData("productInfo.product1.price"));
    }

    @Test(dependsOnMethods = "checkoutItem")
    public void fillInformationData() {
        new CartPage(driver).ClickOnCheckoutButton().fillInformationForm(testData.getJsonData(
                "information-form.first-name"), testData.getJsonData(
                "information-form.last-name"), testData.getJsonData(
                "information-form.postal-code")).
                assertInformationPageData(testData.getJsonData(
                "information-form.first-name"), testData.getJsonData(
                "information-form.last-name"), testData.getJsonData(
                "information-form.postal-code"));
    }
    @Test(dependsOnMethods = "fillInformationData")
    public void finishPurchasing(){
        new CheckoutInfoPage(driver).clickContinueButton()
                .clickFinishButton().
                assertConfirmationMessage(testData.getJsonData("confirmation-message.message"));
    }


    @AfterClass
    public void TearDown() {
        BrowserActions.quitBrowser(DriverManager.getDriver());
        //we should add this here to asset all the soft validations if we used it in the test class (video #7)
        // CustomSoftAssertion.customAssertAll();
    }

    @AfterClass
    public void AttachLogsTOAllureReport() {
        // AllureUtilities.AttachLogsToAllureReport();  moved to listener class
    }
}
