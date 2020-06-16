package com.jee.zad9_4.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Publisher {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private int yof;


}
