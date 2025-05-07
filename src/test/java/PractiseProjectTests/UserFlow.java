package PractiseProjectTests;

import PractiseProject.Drivers.MyDriver;
import PractiseProject.Listeners.TestNGListeners;
import PractiseProject.Pages.LoginPage;
import PractiseProject.Utilities.BrowserActions;
import PractiseProject.Utilities.JsonUtilities;
import PractiseProject.Utilities.PropertiesUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(TestNGListeners.class)
public class UserFlow {
    String browserName;
    JsonUtilities testData;
    MyDriver driver;

    //configurations
    @BeforeClass
    public void beforeClass() {

        testData = new JsonUtilities("test_data");
    }

    @BeforeMethod // I changed it from before method to before class as i will write more than one method for tests
    public void Setup() {

        browserName = PropertiesUtilities.getPropertyValue("browserType");
        driver = new MyDriver(browserName);
        new LoginPage(driver).GoToLoginPage();
    }
    @Test
    public void SuccessfullLogin(){
        new LoginPage(driver).
                SetUserNameField(testData.getJsonData("successful-Login.username")).
                SetPasswordField(testData.getJsonData("successful-Login.password")).
                ClickLoginButton().AssertSuccessLogin().
                addToItemTOCart(testData.getJsonData("productInfo.product1.name"))
                .assertAddItemToCart(testData.getJsonData("productInfo.product1.name"))
                .ClickOnCartIcon().assertItemDetails(
                testData.getJsonData("productInfo.product1.name"),
                        testData.getJsonData("productInfo.product1.price")).ClickOnCheckoutButton().fillInformationForm(testData.getJsonData(
                        "information-form.first-name"), testData.getJsonData(
                        "information-form.last-name"), testData.getJsonData(
                        "information-form.postal-code")).
                assertInformationPageData(testData.getJsonData(
                        "information-form.first-name"), testData.getJsonData(
                        "information-form.last-name"), testData.getJsonData(
                        "information-form.postal-code")).
                clickContinueButton().clickFinishButton().assertConfirmationMessage(testData.getJsonData("confirmation-message.message"));
    }

    @AfterClass
    public void TearDown() {
       driver.browser().quitBrowser();
        //we should add this here to asset all the soft validations if we used it in the test class (video #7)
        // CustomSoftAssertion.customAssertAll();
    }

    @AfterClass
    public void AttachLogsTOAllureReport() {
        // AllureUtilities.AttachLogsToAllureReport();  moved to listener class
    }
}







