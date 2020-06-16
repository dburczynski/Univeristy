package com.jee.zad9_4.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Book {
  @Id
  @GeneratedValue
  private long id;
  private String title;
  private int yop;
}


