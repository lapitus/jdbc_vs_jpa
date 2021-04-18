package com.lapitus.jpaAndJdbc;

import com.lapitus.jpaAndJdbc.entity.Person;
import com.lapitus.jpaAndJdbc.jdbc.PersonJdbcDao;
import com.lapitus.jpaAndJdbc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class JpaAndJdbcApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAndJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person oleg = new Person("Oleg", "Ivanov", "Saratov");
		Person pavel = new Person("Pavel", "Ivanov", "Saratov");
		Person serg = new Person("Sergey", "Petrov", "Omsk");
		Person alex = new Person("Alex", "Sheglov", "Kislovodsk");
		Person mskOleg = new Person("Oleg", "Petrov", "Msk");


		List<Person> personList = Arrays.asList(oleg, pavel, serg, alex, mskOleg);
		personRepository.saveAll(personList);
		System.out.println("<<<<<<<<<< " + personRepository.findAll());

//		//List<Person> personList = new List<Person>.of(oleg,pavel,serg,alex);
//
//		personJdbcDao.insertPerson(oleg);
//		personJdbcDao.insertPerson(pavel);
//		personJdbcDao.insertPerson(serg);
//		personJdbcDao.insertPerson(alex);

		//System.out.println("<<<<<<<<<< " + personJdbcDao.findAll());

	}
}
