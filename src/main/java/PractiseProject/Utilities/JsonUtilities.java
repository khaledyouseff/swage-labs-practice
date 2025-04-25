package PractiseProject.Utilities;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtilities {
    public static final String JSON_FILE_PATH = "src/test/resources/";
    String jsonReader;
    String jsonFileName;


    // I created this constructor to recall any object whenever I want to use a data from
    public JsonUtilities(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            //Reads and parses the file into a JSON object.
            //Converts the object to a JSON string and stores it in jsonReader.
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(JSON_FILE_PATH + jsonFileName + ".json"));
            //Will hold the raw JSON string (after reading and parsing the file):
            jsonReader = data.toJSONString();
        } catch (Exception e) {
            LogsUtilities.error(e.getMessage());
        }
    }

    // this method is to actually get the data
    public String getJsonData(String jsonPath) {
        String testData = "";
        try {
            testData = JsonPath.read(jsonReader, jsonPath);
        } catch (Exception e) {
            LogsUtilities.error(e.getMessage(), " NO result for json path: " + jsonPath + " in the json file:", this.jsonFileName + "'");
        }
        LogsUtilities.info("Json path: '" + jsonPath + "' in the json file: '" + this.jsonFileName + "' has value: '" + testData + "'");

        return testData;
    }
}
