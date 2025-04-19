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
        AllureUtilities.AttachLogsToAllureReport();
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtilities.info("Test case", result.getName() , "Passed");
        try {
            ScreenshotsUtilities.takeScreenshot("Passed-" + result.getName());
        } catch (IOException e) {
            LogsUtilities.error(e.getMessage());
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtilities.info("Test case", result.getName() , "Failed");

        try {
            ScreenshotsUtilities.takeScreenshot("Failed-" + result.getName());
        } catch (IOException e) {
            LogsUtilities.error(e.getMessage());
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtilities.info("Test case", result.getName() , "Skipped");

        try {
            ScreenshotsUtilities.takeScreenshot("Skipped-" + result.getName());
        } catch (IOException e) {
            LogsUtilities.error(e.getMessage());
        }
    }
}