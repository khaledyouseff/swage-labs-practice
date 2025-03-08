package PractiseProject.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private Validations(){
    }
    public static void AssertEquals(String Actual , String Expected , String Message){
        Assert.assertEquals(Actual,Expected,Message);
    }
    public static void AssertNotEquals(String Actual , String Expected , String Message){
        Assert.assertNotEquals(Actual,Expected,Message);
    }
    public static void AssertTrue(boolean Condition ,  String Message){
        Assert.assertTrue(Condition,Message);
    }
    public static void AssertFalse(boolean Condition ,  String Message){
        Assert.assertFalse(Condition,Message);
    }
    public static void AssertPageURL(WebDriver driver, String Expected){
        Assert.assertEquals(BrowserActions.GetCurrentBrowserURL(driver),Expected);
    }
    public static void AssertPageTitle(WebDriver driver, String Expected){
        Assert.assertEquals(BrowserActions.GetPageTitle(driver),Expected);
    }
}
