package com.example.doku.model;

import com.example.doku.model.core.AbstractDescriptor;

public class TestObject extends AbstractDescriptor<Integer> {

  private String value;

  public TestObject(Integer id, String value) {
    super(id);
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
  
  @Override
  public String toString() {
    return String.format("<TestObject id=\"%d\" value=\"%s\">", getId(), value);
  }

}
