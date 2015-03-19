package com.example.doku.model.core;

/**
 * Базовый класс для всех сущностей, которые могут быть сохранены в хранилище.
 * 
 * @author btarelkin
 *
 * @param <T>
 *          тип идентификатора
 */
public class AbstractDescriptor<T> {

  private T id;

  public AbstractDescriptor(T id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || !this.getClass().equals(obj.getClass()))
      return false;
    return this.id.equals(((AbstractDescriptor<?>) obj).getId());
  }

  public final T getId() {
    return id;
  }

  protected void setId(T id) {
    this.id = id;
  }

}
