package com.example.webcore.storage.hibernate;

import javax.persistence.EntityManager;

import com.example.webcore.storage.StorageException;

public interface IHibernateStorageService {

  public void executeWithEntityManager(final EntityManagerRunnable runnable) throws StorageException;

  public static interface EntityManagerRunnable {
    void run(EntityManager em) throws Exception;
  }

}
