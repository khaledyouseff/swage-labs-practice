package PractiseProject.Drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
   /* in case i wanted to execute parallel execution so only one initialized instance
   is thrown so i can open more than one session
   with its instance(Ensures Each Thread Has Its Own WebDriver Instance)*/
    private static final ThreadLocal<WebDriver>  driverThreadLocal = new ThreadLocal<>();
}
