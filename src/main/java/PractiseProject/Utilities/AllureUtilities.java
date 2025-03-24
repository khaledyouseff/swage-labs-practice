package PractiseProject.Utilities;

import com.beust.ah.A;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtilities {
    public static String Allure_Path = "test-outputs/allure-results";

    private AllureUtilities() {
    }

    public static void AttachLogsToAllureReport() {
        try {
            File logFile = FileUtilities.getLatestFile(LogsUtilities.Logs_Path);

            if (!logFile.exists()) {
                LogsUtilities.warn("Log file does not exist: " + LogsUtilities.Logs_Path);
                return;
            }

            Allure.addAttachment("Logs.log", Files.readString(Path.of(logFile.getPath())));

        } catch (Exception e) {
            LogsUtilities.error("Failed to add logs to Allure report: " + e.getMessage());
        }
    }
    public static void attachScreenshotsToAllure(String screenshotName , String screenshotPath){
        try{
            Allure.addAttachment(screenshotName,Files.newInputStream(Path.of(screenshotPath)));

        } catch (IOException e) {
            LogsUtilities.error("Failed to attach screenshot to allure report" + e.getMessage());
        }
    }
}
