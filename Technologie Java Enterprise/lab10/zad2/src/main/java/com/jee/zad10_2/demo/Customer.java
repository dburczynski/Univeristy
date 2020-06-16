package com.jee.zad10_2.demo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AccessLevel;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @lombok.Getter(AccessLevel.PUBLIC)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 25)
    @lombok.Getter(AccessLevel.PUBLIC)
    @lombok.Setter(AccessLevel.PUBLIC)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 25)
    @lombok.Getter(AccessLevel.PUBLIC)
    @lombok.Setter(AccessLevel.PUBLIC)
    private String lastName;

    @Min(0)
    @Max(100)
    @lombok.Getter(AccessLevel.PUBLIC)
    @lombok.Setter(AccessLevel.PUBLIC)
    private Double money;

    @lombok.Getter(AccessLevel.PUBLIC)
    @lombok.Setter(AccessLevel.PUBLIC)
    private Date date;


}
