package PractiseProject.Utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtilities {
    private FileUtilities() {
    }

    public static void deleteFiles(File dirPath) {
        if (dirPath == null) {
            LogsUtilities.warn("Directory does not exist :" + dirPath);
            return;
        }
        File[] fileList = dirPath.listFiles();
        if (fileList == null) {
            LogsUtilities.warn("Directory does not exist :" + dirPath);
            return;
        }
        for (File file : fileList) {
            //Recursion:If the current file is a directory:So the same method is called again and again at different levels,
            // and in each call, the files in that level are being deleted using that line:Files.delete(file.toPath())
            if (file.isDirectory()) {
                deleteFiles(file);
                LogsUtilities.info("previous allure reports is deleted in subdirectory");
            } else
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtilities.error("Failed to delete file " + file);
                }
        }

    }

    public static File getLatestFile(String folderPath) {
        File directory = new File(folderPath);
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            LogsUtilities.warn("No files found in directory : " + folderPath);
            return null;
        }

        File latestFile = files[0];

        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        return latestFile;
    }

    public static void cleanDirectory(File file) {
        try {
            FileUtils.cleanDirectory(file);
        } catch (Exception e) {
            LogsUtilities.error(e.getMessage());
        }
    }
}