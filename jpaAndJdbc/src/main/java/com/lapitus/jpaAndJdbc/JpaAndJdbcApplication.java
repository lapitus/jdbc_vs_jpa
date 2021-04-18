package com.lapitus.jpaAndJdbc;

import com.lapitus.jpaAndJdbc.entity.Person;
import com.lapitus.jpaAndJdbc.jdbc.PersonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaAndJdbcApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(JpaAndJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person oleg = new Person(1,"Oleg","Ivanov","Saratov");
		Person pavel = new Person(2,"Pavel","Ivanov","Saratov");
		Person serg = new Person(3,"Sergey","Petrov","Omsk");
		Person alex = new Person(4,"Alex","Sheglov","Kislovodsk");

		//List<Person> personList = new List<Person>.of(oleg,pavel,serg,alex);

		personJdbcDao.insertPerson(oleg);
		personJdbcDao.insertPerson(pavel);
		personJdbcDao.insertPerson(serg);
		personJdbcDao.insertPerson(alex);

		System.out.println("<<<<<<<<<< " + personJdbcDao.findAll());

	}
}
