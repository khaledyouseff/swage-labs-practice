package PractiseProject.Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {
    private WebDriver driver;
    private ElementAction elementAction;

    public Scroll(WebDriver driver) {
        this.driver = driver;
        elementAction = new ElementAction(driver);
    }


}
