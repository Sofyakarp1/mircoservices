package mirea.ippo.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJson {

    public JSONObject parseJsonFromService(String json) throws ParseException {
        String strinG = "{\"Persons\":" + json + "}";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(strinG);
        return jsonObject;
    }

    public JSONObject parseJsonFromServiceSingle(String json, String param) throws ParseException {
        String strinG = "{\"" + param + "\":\"" + json + "\"}";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(strinG);
        return jsonObject;
    }

    public String getAsJson(String str) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        return (String) jsonObject.get("auth");
    }
}
