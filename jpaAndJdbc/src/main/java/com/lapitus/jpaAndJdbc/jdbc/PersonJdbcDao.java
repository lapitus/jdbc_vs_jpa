package com.lapitus.jpaAndJdbc.jdbc;

import com.lapitus.jpaAndJdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        List<Person> personList = jdbcTemplate.query("SELECT * FROM sbdemo.person",
                new BeanPropertyRowMapper<>(Person.class));

        return personList;
    }

    public int insertPerson(Person person) {

        int insertCnt = jdbcTemplate.update("INSERT INTO sbdemo.person " +
                "(ID,FIRST_NAME,LAST_NAME,ADDRESS) " +
                "VALUES (?,?,?,?)",
                new Object[] {
                        person.getId(),person.getFirstName(),person.getLastName(),
                        person.getAddress()
        });

        return insertCnt;
    }
}
