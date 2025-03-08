package PractiseProject.Pages;

import com.google.common.base.FinalizablePhantomReference;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

public class HomePage {
    private  WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver=driver;
    }
}
