package mirea.ippo.rest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import mirea.ippo.service.PersonService;


@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    PersonService personService;

    @GetMapping("/all/employee")
    public String getAllPersons(){
        return personService.allPersons().toString();
    }

    @PostMapping(path = "/get/employee", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public String authorization(@RequestBody String member) throws ParseException {
        System.out.println("Connection is true");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(member));
        return personService.getEmployeeByName((json.get("name").toString())).toString();
    }

    @PostMapping(path = "/employee/phone/byName", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public String getPhone(@RequestBody String member) throws ParseException {
        System.out.println("Connection is true");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(member));
        return personService.getPhone((json.get("name").toString()));
    }


    @GetMapping("/all/vacations")
    public String getVacation() {
        return personService.getVacation().toString();
    }

    @PostMapping(path = "/work/space", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public String getWorkSpace(@RequestBody String member) throws ParseException {
        System.out.println("Connection is true");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(member));
        return personService.getWorkSpace((json.get("name").toString()));
    }

    @PostMapping(path = "/work/email", consumes = "*/*;charset=UTF-8", produces = "application/json")
    public String getEmail(@RequestBody String member) throws ParseException {
        System.out.println("Connection is true");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(member));
        return personService.getEmail((json.get("name").toString()));
    }
}
