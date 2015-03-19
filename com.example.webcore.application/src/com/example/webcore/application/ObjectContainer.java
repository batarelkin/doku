package com.example.webcore.application;

public class ObjectContainer<T> {

  private T object;

  public T get() {
    return object;
  }

  public void set(T object) {
    this.object = object;
  }

}
