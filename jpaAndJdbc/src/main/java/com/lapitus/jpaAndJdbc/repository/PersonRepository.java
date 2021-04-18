package com.lapitus.jpaAndJdbc.repository;

import com.lapitus.jpaAndJdbc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT person FROM Person person ORDER BY firstName")
    List<Person> findAllOrderedByFirsName();

    @Query("SELECT person FROM Person person WHERE person.address = ?1")
    List<Person> findAllByAddress(String adress);
}
