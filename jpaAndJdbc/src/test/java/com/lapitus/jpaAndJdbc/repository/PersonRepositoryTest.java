package com.lapitus.jpaAndJdbc.repository;

import com.lapitus.jpaAndJdbc.entity.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void findByFirstName() {
        List<Person> listPerson = personRepository.findByFirstName("Alex");

        assertThat(listPerson).hasSize(1);
        assertThat(listPerson.get(0).getLastName()).isEqualTo("Sheglov");
    }

    @Test
    void findByFirstAndLastName() {
        List<Person> listPerson = personRepository.findByFirstNameAndLastName("Oleg", "Petrov");
        assertThat(listPerson).hasSize(1);
        assertThat(listPerson.get(0).getLastName()).isEqualTo("Petrov");
    }

    @Test
    void findAllOrderedByFirsName() {
        List<Person> listPerson = personRepository.findAllOrderedByFirsName();
        assertThat(listPerson).hasSize(5);
        assertThat(listPerson.get(0).getFirstName()).isEqualTo("Alex");

    }

    @Test
    void findAllByAddress() {
        List<Person> listPerson = personRepository.findAllByAddress("Omsk");
        assertThat(listPerson).hasSize(1);
        assertThat(listPerson.get(0).getFirstName()).isEqualTo("Sergey");
    }
}