package mirea.ippo.rest;


import com.sun.jersey.api.client.Client;
import mirea.ippo.check.JsonAdapter;
import mirea.ippo.check.JsonAdapterImpl;
import mirea.ippo.client.HttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HttpCodeStatusMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final JsonAdapter jsonAdapter;

    @Autowired
    public RestController(JsonAdapter jsonAdapter){
        this.jsonAdapter = jsonAdapter;
    }

    @GetMapping("/all/employee")
    public JSONObject getAllPersons() throws ParseException {
        System.out.println(jsonAdapter.convert("Kakaka", "Sasasa"));
        Client client = new Client();
        HttpClient httpClient = new HttpClient();
        return httpClient.getJson(client, "http://localhost:8333/all/employee");
    }

    @PostMapping(path = "/get/employee", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public JSONObject authorization(@RequestBody String member) throws ParseException {
        System.out.println(jsonAdapter.convert("Kakaka", member));
        JSONObject json = new JSONObject();
        json.put("httpCode", HttpStatus.BAD_REQUEST.value());
        json.put("httpMessage", HttpStatus.BAD_REQUEST.name());
        json.put("moreInformation", "<kf ,kf ,kf ");
        ResponseEntity responseEntity = new ResponseEntity(json, HttpStatus.BAD_REQUEST);
        System.out.println(responseEntity);
        System.out.println("Connection is true");
        Client client = new Client();
        HttpClient httpClient = new HttpClient();
        return httpClient.postJson(client, "http://localhost:8333/get/employee", member);
    }

    @PostMapping(path = "/employee/phone/byName", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public JSONObject getPhone(@RequestBody String member) throws ParseException {
//        System.out.println(jsonAdapter.convert("Kakaka", member));
//        JSONObject json = new JSONObject();
//        json.put("httpCode", HttpStatus.BAD_REQUEST.value());
//        json.put("httpMessage", HttpStatus.BAD_REQUEST.name());
//        json.put("moreInformation", "<kf ,kf ,kf ");
//        ResponseEntity responseEntity = new ResponseEntity(json, HttpStatus.BAD_REQUEST);
//        System.out.println(responseEntity);
//        System.out.println("Connection is true");
        Client client = new Client();
        HttpClient httpClient = new HttpClient();
        if (jsonAdapter.check(member)){
            return httpClient.postJsonSing(client, "http://localhost:8333/employee/phone/byName", member, "phone");
        }
        else return jsonAdapter.authFail();
//        Client client = new Client();
//        HttpClient httpClient = new HttpClient();
//        return httpClient.postJsonSing(client, "http://localhost:8333/employee/phone/byName", member, "phone");
    }

    @PostMapping(path = "/work/email", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public JSONObject getEmail(@RequestBody String member) throws ParseException {
        System.out.println(jsonAdapter.convert("Kakaka", member));
        JSONObject json = new JSONObject();
        json.put("httpCode", HttpStatus.BAD_REQUEST.value());
        json.put("httpMessage", HttpStatus.BAD_REQUEST.name());
        json.put("moreInformation", "<kf ,kf ,kf ");
        ResponseEntity responseEntity = new ResponseEntity(json, HttpStatus.BAD_REQUEST);
        //System.out.println(responseEntity);
        System.out.println("Connection is true");
        Client client = new Client();
        HttpClient httpClient = new HttpClient();
        return httpClient.postJsonSing(client, "http://localhost:8333/work/email", member, "email");
    }

    @PostMapping(path = "/work/space", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public JSONObject getSpace(@RequestBody String member) throws ParseException {
        System.out.println(jsonAdapter.convert("Kakaka", member));
        JSONObject json = new JSONObject();
        json.put("httpCode", HttpStatus.BAD_REQUEST.value());
        json.put("httpMessage", HttpStatus.BAD_REQUEST.name());
        json.put("moreInformation", "<kf ,kf ,kf ");
        ResponseEntity responseEntity = new ResponseEntity(json, HttpStatus.BAD_REQUEST);
        System.out.println(responseEntity);
        System.out.println("Connection is true");
        Client client = new Client();
        HttpClient httpClient = new HttpClient();
        return httpClient.postJsonSing(client, "http://localhost:8333/work/space", member, "space");
    }

    @GetMapping("/all/vacations")
    public JSONObject getVacation() throws ParseException {
        System.out.println(jsonAdapter.convert("Kakaka", "Sasasa"));
        Client client = new Client();
        HttpClient httpClient = new HttpClient();
        return httpClient.getJson(client, "http://localhost:8333/all/vacations");
    }
}
