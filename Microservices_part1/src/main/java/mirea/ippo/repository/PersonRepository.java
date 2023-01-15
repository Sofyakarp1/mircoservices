package mirea.ippo.repository;

import mirea.ippo.entity.Person_first;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person_first, Integer> {

    @Query(value = "select * from person_first", nativeQuery = true)
    List<Person_first> allEmployee();

    @Query(value = "select * from person_first where name = :name", nativeQuery = true)
    Person_first getEmployeeByName(@Param("name") String name);

    @Query(value = "select phone from person_first where name = :name", nativeQuery = true)
    String getPhoneByName(@Param("name") String name);

    @Query(value = "select space from person_first where name = :name", nativeQuery = true)
    String getWorkSpace(@Param("name") String name);

    @Query(value = "select email from person_first where name = :name", nativeQuery = true)
    String getEmail(@Param("name") String name);
}
