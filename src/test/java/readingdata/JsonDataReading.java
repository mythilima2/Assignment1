package readingdata;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
public class JsonDataReading {
    //this is for reading data from the json file
    public String  read(String attribute) throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/readdata/readingdatafromjson.json");
        Object obj = jsonParser.parse(reader);
        JsonObject jsonObject = (JsonObject) obj;
        String value = jsonObject.get(attribute).getAsString();
        return value;
    }
}
