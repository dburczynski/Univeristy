package com.jee.zad9_4.domain;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
public class ShoppingCard implements Serializable {
    @ManyToOne
    @Id
    @JoinColumn
    private Person person;
    @ManyToOne
    @Id
    @JoinColumn
    private Product product;

}
