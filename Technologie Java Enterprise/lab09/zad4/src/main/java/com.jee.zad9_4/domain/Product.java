package com.jee.zad9_4.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private long id;
    private String name;
    @OneToMany
    private List<ShoppingCard> shoppingCards;
}
