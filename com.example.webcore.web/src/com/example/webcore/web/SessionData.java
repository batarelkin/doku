package com.example.webcore.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.example.webcore.application.core.AppException;

/**
 * ������ ������ ������������.
 * 
 * @author Igor Pavlenko
 */
public class SessionData implements ISessionData<Serializable>, Serializable {
  private static final long serialVersionUID = -6155410003784800692L;

  private final Map<String, Serializable> attributes = new HashMap<String, Serializable>();

  public SessionData() {
    // for serialization
  }

  @Override
  public synchronized void setAttribute(String name, Serializable value) {
    attributes.put(name, value);
  }

  @Override
  public synchronized <T extends Serializable> T getAttribute(Class<T> clazz, String name) {
    Serializable value = attributes.get(name);
    if (clazz.isInstance(value)) {
      return clazz.cast(value);
    }
    return null;
  }

  @Override
  public void removeAttribute(String name) throws AppException {
    this.attributes.remove(name);
  }
}
