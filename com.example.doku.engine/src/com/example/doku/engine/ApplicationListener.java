package com.example.doku.engine;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.doku.engine.services.ITestObjectStorage;
import com.example.webcore.application.AC;

public class ApplicationListener implements ServletContextListener {
  
  private @Resource(name="bean/DOKU_TEST_STORAGE") ITestObjectStorage testObjectStorage;

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    System.out.println(testObjectStorage);
    AC.get().registerService(ITestObjectStorage.class, testObjectStorage);
  }

}
