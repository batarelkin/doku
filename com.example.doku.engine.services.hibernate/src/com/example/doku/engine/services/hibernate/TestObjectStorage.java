package com.example.doku.engine.services.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.example.doku.engine.services.ITestObjectStorage;
import com.example.doku.engine.services.hibernate.beans.TestObjectBean;
import com.example.doku.model.TestObject;
import com.example.webcore.application.ObjectContainer;
import com.example.webcore.storage.StorageException;
import com.example.webcore.storage.hibernate.HibernateStorageService;

public class TestObjectStorage extends HibernateStorageService implements ITestObjectStorage {

  public TestObjectStorage(EntityManagerFactory emf) {
    super(emf);
  }

  @Override
  public TestObject getTestObject(final int id) throws StorageException {
    final ObjectContainer<TestObject> to = new ObjectContainer<TestObject>();
    
    executeWithEntityManager(new EntityManagerRunnable() {
      
      @Override
      public void run(EntityManager em) throws Exception {
        TestObjectBean obj = em.getReference(TestObjectBean.class, Integer.valueOf(id));
        to.set(new TestObject(obj.getId(), obj.getValue()));
      }
    });
    return to.get();
  }

  @Override
  public TestObject addTestObject(TestObject obj) throws StorageException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TestObject deleteTestObject(TestObject obj) throws StorageException {
    // TODO Auto-generated method stub
    return null;
  }

}
