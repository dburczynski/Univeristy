package com.jee.zad9_2.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Address {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private long id;

    @Getter
    @Setter
    private String address;
}
