package com.jee.zad8_1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private int id;
    private String firstName , surname;
}
