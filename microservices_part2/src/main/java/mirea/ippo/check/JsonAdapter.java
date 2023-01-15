package mirea.ippo.check;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public interface JsonAdapter {
    String convert(String part1, String part2);

    Boolean check(String member) throws ParseException;

    JSONObject authFail() throws ParseException;
}
