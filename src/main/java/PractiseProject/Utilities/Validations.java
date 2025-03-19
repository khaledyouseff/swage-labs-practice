package PractiseProject.Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private Validations(){
    }
    @Step("Validate Equals")
    public static void AssertEquals(String Actual , String Expected , String Message){
        Assert.assertEquals(Actual,Expected,Message);
    }
    @Step("Validate not Equals")
    public static void AssertNotEquals(String Actual , String Expected , String Message){
        Assert.assertNotEquals(Actual,Expected,Message);
    }
    @Step("Validate true")
    public static void AssertTrue(boolean Condition ,  String Message){
        Assert.assertTrue(Condition,Message);
    }
    @Step("Validate false")
    public static void AssertFalse(boolean Condition ,  String Message){
        Assert.assertFalse(Condition,Message);
    }
    @Step("Validate page url")
    public static void AssertPageURL(WebDriver driver, String Expected){
        Assert.assertEquals(BrowserActions.GetCurrentBrowserURL(driver),Expected);
    }
    @Step("Validate page title")
    public static void AssertPageTitle(WebDriver driver, String Expected){
        Assert.assertEquals(BrowserActions.GetPageTitle(driver),Expected);
    }
}
