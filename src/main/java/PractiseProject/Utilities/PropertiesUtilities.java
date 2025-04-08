package PractiseProject.Utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class PropertiesUtilities {
    private PropertiesUtilities() {
    }

    public static final String PROPERTIES_PATH = "src/main/resources";

    //the aim of this method to restore or load the properties, merge them together, and inject them into the Java system properties so they can be used throughout my code.
    // Returns a Properties object containing all loaded data.
    public static Properties LoadProperties() {
        try {
            //Creates a new empty Properties object where all the file contents will be loaded.:
            Properties properties = new Properties();
            Collection<File> propertiesFileList;
            // Searches recursively (because of true) in the PROPERTIES_PATH folder:
            // Collects all files with .properties extension:
            //  The result is a list of File objects → propertiesFileList:
            propertiesFileList = FileUtils.listFiles(new File(PROPERTIES_PATH), new String[]{"properties"}
                    , true);
            propertiesFileList.forEach(propertyFile -> {
                try {
                    properties.load(new FileInputStream(propertyFile));
                    LogsUtilities.info("Loaded properties from: " + propertyFile.getAbsolutePath());

                } catch (IOException ioe) {
                    LogsUtilities.error("Error reading file " + propertyFile.getName() + ": " + ioe.getMessage());
                }

            });
            //properties.putAll(System.getProperties());  No need to load system properties into your custom object.
            System.getProperties().putAll(properties);
            LogsUtilities.info(("All properties successfully loaded and added to system properties."));
            return properties;
        } catch (Exception e) {
            LogsUtilities.error("Failed to load properties file data because:" + e.getMessage());
            return null;
        }
    }

    public static String getPropertyValue(String key) {

            String value = System.getProperty(key);

            if (value == null) {
                LogsUtilities.warn(" Property not found for key: " + key);
            } else {
                LogsUtilities.info("Retrieved property: " + key + " = " + value);
            }
            return value;
        }
        /*NOTE: i created this method just for the logs and the exception but i could have used this line:
          System.getProperty(key); directly each time i want to get a property value*/


        }