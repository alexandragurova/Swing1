package com.alexandragurova.swing1.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gurova on 09.03.2015.
 */
public class PersonDatabase {
    private ArrayList<Person> people;

    public PersonDatabase() {
        people = new ArrayList<Person>();
    }

    public void addPeople(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}
