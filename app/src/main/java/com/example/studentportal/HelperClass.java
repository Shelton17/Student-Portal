package com.example.studentportal;

public class HelperClass {
    String firstname, lastname, idNumber, yearofStudy, gender, attempt;

    public HelperClass(String firstname, String lastname, String idNumber, String yearofStudy, String gender, String attempt) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.idNumber = idNumber;
        this.yearofStudy = yearofStudy;
        this.gender = gender;
        this.attempt = attempt;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getYearofStudy() {
        return yearofStudy;
    }

    public void setYearofStudy(String yearofStudy) {
        this.yearofStudy = yearofStudy;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }
}
