package PractiseProject.Listeners;

import PractiseProject.Drivers.MyDriver;
import PractiseProject.Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestNGListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {
    File AllureFile = new File("test-outputs/allure-results");
    File LogseFile = new File("test-outputs/logs");
    File screenshotsFile = new File("test-outputs/screenshots");


    @Override
    public void onExecutionStart() {
        LogsUtilities.info("Test Execution Started");
        PropertiesUtilities.LoadProperties();
        FileUtilities.deleteFiles(AllureFile);
        FileUtilities.cleanDirectory(LogseFile);
        FileUtilities.cleanDirectory(screenshotsFile);


    }

    @Override
    public void onExecutionFinish() {
        LogsUtilities.info("Test Execution Finished");

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResultt) {
        WebDriver driver =MyDriver.getInstance();
        // to attach only after the test method not the other methods in test class
       if(method.isTestMethod())
       {
           try {
               //should be added here so the result of soft assertion appears
               // I put it in try,catch so if the exception happens it ends the session
               CustomSoftAssertion.customAssertAll();
           } catch (Exception e) {
               testResultt.setStatus(ITestResult.FAILURE);
               testResultt.setThrowable(e);
           }


           switch (testResultt.getStatus()){
               case ITestResult.SUCCESS -> {
                   try {
                       ScreenshotsUtilities.takeScreenshot(driver,"Passed-" + testResultt.getName());
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }

               }
               case ITestResult.FAILURE -> {
                   try {
                       ScreenshotsUtilities.takeScreenshot(driver,"Failed-" + testResultt.getName());
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }


               }
               case ITestResult.SKIP -> {
                   try {
                       ScreenshotsUtilities.takeScreenshot(driver,"Skipped-" + testResultt.getName());
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }


               }
           }
       }
        AllureUtilities.AttachLogsToAllureReport();

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtilities.info("Test case", result.getName() , "Passed");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtilities.info("Test case", result.getName() , "Failed");


    }
    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtilities.info("Test case", result.getName() , "Skipped");


    }
}