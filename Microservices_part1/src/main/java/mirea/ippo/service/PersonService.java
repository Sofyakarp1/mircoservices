package mirea.ippo.service;


import mirea.ippo.entity.Person_first;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mirea.ippo.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person_first> allPersons() {
        return personRepository.allEmployee();
    }

    public Person_first getEmployeeByName(String name) {
        return personRepository.getEmployeeByName(name);
    }

    public String getPhone(String name) {
        return personRepository.getPhoneByName(name);
    }

    public List<String> getVacation() {
        List<Person_first> fullList = personRepository.allEmployee();
        List<String> vacationList = new ArrayList<>();
        for (Person_first employee : fullList) {
            vacationList.add(employee.getVacation());
        }
        return vacationList;
    }

    public String getWorkSpace(String name) {
        return personRepository.getWorkSpace(name);
    }

    public String getEmail(String name) {
        return personRepository.getEmail(name);
    }
}
