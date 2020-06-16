package com.jee.zad9_4.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class Car {
  @Id
  @GeneratedValue
  private long id;
  private String make;
  private int yop;
}
