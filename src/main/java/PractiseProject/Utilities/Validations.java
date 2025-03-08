package PractiseProject.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {
    private Validations(){
    }
    public void AssertEquals(String Actual , String Expected , String Message){
        Assert.assertEquals(Actual,Expected,Message);
    }
    public void AssertNotEquals(String Actual , String Expected , String Message){
        Assert.assertNotEquals(Actual,Expected,Message);
    }
    public void AssertTrue(boolean Condition ,  String Message){
        Assert.assertTrue(Condition,Message);
    }
    public void AssertFalse(boolean Condition ,  String Message){
        Assert.assertFalse(Condition,Message);
    }
    public void AssertPageURL(WebDriver driver, String Expected){
        Assert.assertEquals(BrowserActions.GetCurrentBrowserURL(driver),Expected);
    }
    public void AssertPageTitle(WebDriver driver, String Expected){
        Assert.assertEquals(BrowserActions.GetPageTitle(driver),Expected);
    }
}
