package com.jee.zad9_2.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

  private long id;
  private String title;
  private int yop;

  private List<Publisher> publishers;

  public Book(String title, int yop) {
    this.title = title;
    this.yop = yop;
  }

  public Book() {
  }

  @ManyToMany
  public List<Publisher> getPublishers() {
    return publishers;
  }

  public void setPublishers(List<Publisher> publishers) {
    this.publishers = publishers;
  }

  @Id
  @GeneratedValue
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYop() {
    return yop;
  }

  public void setYop(int yop) {
    this.yop = yop;
  }
}
