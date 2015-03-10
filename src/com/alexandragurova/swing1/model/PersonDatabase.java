package com.alexandragurova.swing1.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person[] peopleArray = people.toArray(new Person[people.size()]);

        oos.writeObject(peopleArray);
        oos.close();
    }

    public  void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Person[] peopleArray = (Person[]) ois.readObject();

            people.clear();
            people.addAll(Arrays.asList(peopleArray));
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}
