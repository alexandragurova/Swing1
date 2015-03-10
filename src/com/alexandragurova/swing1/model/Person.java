package com.alexandragurova.swing1.model;

import java.io.Serializable;

/**
 * Created by Gurova on 09.03.2015.
 */
public class Person implements Serializable{

    private static int idCounter = 0;

    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory employCategory;
    private boolean citizen;
    private String taxId;
    private Gender gender;

    public Person(String name,
                  String occupation,
                  AgeCategory ageCategory,
                  EmploymentCategory employCategory,
                  boolean citizen,
                  String taxId,
                  Gender gender) {

        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employCategory = employCategory;
        this.citizen = citizen;
        this.taxId = taxId;
        this.gender = gender;

        this.id = idCounter;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmployCategory() {
        return employCategory;
    }

    public void setEmployCategory(EmploymentCategory employCategory) {
        this.employCategory = employCategory;
    }

    public boolean isCitizen() {
        return citizen;
    }

    public void setCitizen(boolean citizen) {
        this.citizen = citizen;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
