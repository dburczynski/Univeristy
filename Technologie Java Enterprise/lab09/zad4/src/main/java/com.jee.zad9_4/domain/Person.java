package com.jee.zad9_4.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Person {
  @Id
  private String id;
  private String firstName;
  private int yob;
  @OneToOne
  private Address address;
  @OneToMany
  private List<Car> cars;
  @OneToMany
  private List<ShoppingCard> shoppingCards;
}
