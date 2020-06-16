package com.example.lab5_1;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Person {
    @NotNull(message = "Name is required")
    @Size(min = 2, message = "Name should be start at least two characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be at least zero")
    private int age;

    @NotNull(message = "Postal code is required")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message ="Postal code format xx-xxx")
    String postalCode;

    @NotNull(message = "Salary is required")
    @Min(value = 2000, message = "Minimum Salary is 2000")
    @Max(value = 3000, message = "Maximum Salary is 3000")
    private int salary;


}