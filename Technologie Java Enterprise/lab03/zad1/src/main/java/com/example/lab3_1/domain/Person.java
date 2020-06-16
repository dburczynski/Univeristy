package com.example.lab3_1.domain;

public class Person {

  private String name;
  private String lastName;
  private String email;
  private String companyName;

  public Person() {
    System.out.println("Creating person " + this);
  }

  public Person(String name, String lastName, String email, String companyName) {
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.companyName = companyName;
    System.out.println("Creating person " + this);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {return lastName;}

  public void setLastName(String lastName) {this.lastName = lastName;}

  public String getEmail() {return email;}

  public void setEmail(String email) {this.email = email;}

  public String getCompanyName() {return companyName;}

  public void setCompanyName(String companyName) {this.companyName = companyName;}


  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", Surname'=" + lastName + '\'' +
        ", email=" + email +
        ", company=" + companyName+
        '}';
  }
}
