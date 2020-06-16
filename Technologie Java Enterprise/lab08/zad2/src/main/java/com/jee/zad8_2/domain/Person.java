package com.jee.zad8_2.domain;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
public class Person {

    private int id;
    private String firstName, surname;
}
