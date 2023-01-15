package mirea.ippo.entity;

import javax.persistence.*;

@Entity
@Table(name = "person_first")
public class Person_first {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String profession;

    @Column
    private Integer age;

    @Column
    private String phone;

    @Column
    private String vacation;

    @Column
    private Integer space;

    @Column
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setVacation(String vacation) {
        this.vacation = vacation;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"address\":\"" + address + "\"," +
                "\"profession\":\"" + profession + "\"," +
                "\"age\":\"" + age + "\"," +
                "\"space\":\"" + space + "\"," +
                "\"email\":\"" + email + "\"," +
                "\"phone\":\"" + phone + "\"" +
                '}';
    }

    public String getVacation(){
        return "{" +
                "\"name\":\"" + name + "\"," +
                "\"vacation\":\"" + vacation + "\"" +
                '}';
    }
}
