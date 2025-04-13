package PractiseProject.Utilities;

import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtilities {
    public static final String JSON_FILE_PATH = "src/test/resources/";
    String jsonReader;
    String jsonFileName;


    // I created this object to recall it whenever i want to use a data from
    public JsonUtilities(String jsonFileName) {
        this.jsonFileName = jsonFileName;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(JSON_FILE_PATH + jsonFileName + ".json"));
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
            LogsUtilities.error(e.getMessage(), " NO result for json path: " + jsonPath + " in the json file:", this.jsonFileName + "'" );
        }
        LogsUtilities.info("Json path: '" + jsonPath + "' in the json file: '" + this.jsonFileName + "' has value: '" + testData + "'");

        return testData;
    }
}
