package com.alexandragurova.swing1.controller;

import com.alexandragurova.swing1.gui.FormEvent;
import com.alexandragurova.swing1.model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Gurova on 09.03.2015.
 */
public class Controller {
    PersonDatabase db = new PersonDatabase();

    public List<Person> getPeople(){
        return db.getPeople();
    }

    public void addPerson(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCategory = e.getAgeCategory();
        String employCategory = e.getEmployCategory();
        boolean citizen = e.isCitizen();
        String taxId = e.getTaxId();
        String gender = e.getGender();

        AgeCategory ageCategoryEnum = null;

        switch (ageCategory){
            case 0:
                ageCategoryEnum = AgeCategory.child;
                break;
            case 1:
                ageCategoryEnum = AgeCategory.adult;
                break;
            case 2:
                ageCategoryEnum = AgeCategory.senior;
                break;
        }

        EmploymentCategory employmentCategoryEnum;

        if (employCategory.equals("employed")){
            employmentCategoryEnum = EmploymentCategory.employed;
        } else if (employCategory.equals("self-employed")){
            employmentCategoryEnum = EmploymentCategory.selfemployed;
        } else if (employCategory.equals("unemployed")){
            employmentCategoryEnum = EmploymentCategory.unemployed;
        } else {
            employmentCategoryEnum = EmploymentCategory.other;
        }

        Gender genderEnum = null;

        if (gender.equals("male")){
            genderEnum = Gender.male;
        } else if (gender.equals("female")){
            genderEnum = Gender.female;
        }

        Person person = new Person(name,
                occupation,
                ageCategoryEnum,
                employmentCategoryEnum,
                citizen,
                taxId,
                genderEnum);

        db.addPeople(person);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}
