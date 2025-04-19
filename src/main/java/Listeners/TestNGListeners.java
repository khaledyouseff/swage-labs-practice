package Listeners;

import PractiseProject.Utilities.FileUtilities;
import PractiseProject.Utilities.LogsUtilities;
import PractiseProject.Utilities.PropertiesUtilities;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;

import java.io.File;

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
    }
}
