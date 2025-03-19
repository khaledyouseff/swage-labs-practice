package PractiseProject.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public   class FileUtilities {
    private FileUtilities(){}
    public  static void deleteFiles(File dirPath){
        if(dirPath == null){
            LogsUtilities.warn("Directory does not exist :" + dirPath);
            return;
        }
        File[] fileList = dirPath.listFiles();
        if(fileList == null){
            LogsUtilities.warn("Directory does not exist :" + dirPath);
            return;
        }
        for(File file :fileList){
            if( file.isDirectory()){
                deleteFiles(file);
            }
            else
                try{
                    Files.delete(file.toPath());
                }catch (IOException e) {
                   LogsUtilities.error("Failed to delete file " + file);
                }
        }

    }
}
