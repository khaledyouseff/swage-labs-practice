package PractiseProject.Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private WebDriver driver;
    private BrowserActions browserActions;
    public Validations (WebDriver driver){
        this.driver=driver;
        browserActions = new BrowserActions(driver);
    }
    private Validations(){
    }
    @Step("Validate Equals")
    public  void AssertEquals(String Actual , String Expected , String Message){
        Assert.assertEquals(Actual,Expected,Message);
    }
    @Step("Validate not Equals")
    public  void AssertNotEquals(String Actual , String Expected , String Message){
        Assert.assertNotEquals(Actual,Expected,Message);
    }
    @Step("Validate true")
    public  void AssertTrue(boolean Condition ,  String Message){
        Assert.assertTrue(Condition,Message);
    }
    @Step("Validate false")
    public  void AssertFalse(boolean Condition ,  String Message){
        Assert.assertFalse(Condition,Message);
    }
    @Step("Validate page url")
    public  void AssertPageURL( String Expected){
        Assert.assertEquals(browserActions.GetCurrentBrowserURL(),Expected);
    }
    @Step("Validate page title")
    public  void AssertPageTitle(String Expected){
        Assert.assertEquals(browserActions.GetPageTitle(),Expected);
    }
}
