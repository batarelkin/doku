package com.example.doku.engine.services.hibernate;

import java.util.HashMap;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestObjectStorageFactory implements ObjectFactory {

  @Override
  public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {

    Reference ref = (Reference) obj;

    String dataSourceName = (String) ref.get("dataSource").getContent();

    HashMap<String, String> props = new HashMap<>();
    props.put("hibernate.connection.datasource", dataSourceName);
    props.put("hibernate.hbm2ddl.auto", "update");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "com.example.doku.engine.services.hibernate", props);

    return new TestObjectStorage(emf);
  }

}
