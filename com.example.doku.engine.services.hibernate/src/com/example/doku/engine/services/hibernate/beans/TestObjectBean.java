package com.example.doku.engine.services.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_object")
public class TestObjectBean {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private int id;

  @Column(name = "value")
  private String value;

  public TestObjectBean(int id, String value) {
    this.id = id;
    this.value = value;
  }

  public TestObjectBean() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
