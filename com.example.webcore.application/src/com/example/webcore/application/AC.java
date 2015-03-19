package com.example.webcore.application;

import java.util.HashMap;
import java.util.Map;

import com.example.webcore.application.core.AppRuntimeException;

/**
 * Хранит все сервисы приложения.
 * 
 * @author btarelkin
 *
 */
public class AC {

  private static final AC INSTANCE = new AC();

  public static AC get() {
    return INSTANCE;
  }

  private final Map<String, IService> services = new HashMap<String, IService>();

  /**
   * Добавляет сервис приложения.
   * 
   * @param <T>
   *          Тип класса-сервиса.
   * @param clazz
   *          тип сервиса
   * @param service
   *          объект, реализующий указанный сервис
   * @return текущий объект
   */
  public <T extends IService> AC registerService(Class<T> clazz, T service) {
    services.put(clazz.getCanonicalName(), service);
    return this;
  }
  
  public <T extends IService> T getService(Class<T> clazz) {
    IService service = services.get(clazz.getName());
    if (service == null) {
      // TODO: move to localized resources
      throw new AppRuntimeException("No requested service found.");
    }
    if (!clazz.isInstance(service)) {
      // TODO: move to localized resources
      throw new AppRuntimeException("Invalid service");
    }
    return clazz.cast(service);
  }

}
