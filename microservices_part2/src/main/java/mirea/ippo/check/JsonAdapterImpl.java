package mirea.ippo.check;

import mirea.ippo.parser.ParseJson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class JsonAdapterImpl implements JsonAdapter{
    @Override
    public String convert(String part1, String part2) {
        return part1 + part2;
    }

    @Override
    public Boolean check(String member) throws ParseException {
        ParseJson parse = new ParseJson();
        String auth = parse.getAsJson(member);
        if(auth.equals("4")){
            return true;
        }
        else return false;
    }

    @Override
    public JSONObject authFail() throws ParseException {
        String str = "{\"error\":\"Authentication error\"}";
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        return jsonObject;
    }


}
