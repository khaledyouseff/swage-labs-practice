package PractiseProject.Listeners;

import PractiseProject.Utilities.*;
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

        // to attach only after the test method not the other methods in test class
       if(method.isTestMethod())
       {
           //should be added here so the result of soft assertion appears
           CustomSoftAssertion.customAssertAll();

           switch (testResultt.getStatus()){
               case ITestResult.SUCCESS -> {
                   try {
                       ScreenshotsUtilities.takeScreenshot("Passed-" + testResultt.getName());
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }

               }
               case ITestResult.FAILURE -> {
                   try {
                       ScreenshotsUtilities.takeScreenshot("Failed-" + testResultt.getName());
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }


               }
               case ITestResult.SKIP -> {
                   try {
                       ScreenshotsUtilities.takeScreenshot("Skipped-" + testResultt.getName());
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