package com.example.webcore.storage.hibernate;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import com.example.webcore.storage.IStorageService;
import com.example.webcore.storage.StorageException;
import com.example.webcore.storage.StorageStatus;

/**
 * Хранилище в базе даных с использованием Hibernate
 */
public abstract class HibernateStorageService implements IStorageService, IHibernateStorageService {

  protected static final Logger LOG = Logger.getLogger(HibernateStorageService.class.getName());

  private final ThreadLocal<HibernateStorageSession> sessionHolder = new ThreadLocal<HibernateStorageSession>();

  private final EntityManagerFactory entityManagerFactory;

  public HibernateStorageService(EntityManagerFactory emf) {
    this.entityManagerFactory = emf;
  }

  @Override
  public void executeWithTransaction(final SessionRunnable transactionRunnable) throws StorageException {
    executeWithSession(new SessionRunnable() {
      @Override
      public void run(IStorageSession session) throws Exception {
        
        EntityTransaction tx = ((HibernateStorageSession) session).getEntityManager().getTransaction();
        
        try {
          tx.begin();
          transactionRunnable.run(session);
          tx.commit();
          
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new StorageException(ERROR_CANNOT_EXECUTE_STATEMENT, e, StorageStatus.STATUS_UNKNOWN_REASON);
        } catch (Exception e) {
          if (tx != null && tx.isActive()) tx.rollback();
          throw e;
        }
      }
    });
  }

  @Override
  public void executeWithSession(SessionRunnable runnable) throws StorageException {
    try {
      HibernateStorageSession session = sessionHolder.get();
      if (session != null) {
        runnable.run(session);
      } else {
        try {
          session = openSession();
          sessionHolder.set(session);
          runnable.run(session);
        } finally {
          if (session != null) {
            sessionHolder.set(null);
            session.close();
          }
        }
      }
    } catch (Exception e) {
      throw new StorageException(ERROR_CANNOT_EXECUTE_STATEMENT, e, StorageStatus.STATUS_UNKNOWN_REASON);
    }
  }

  @Override
  public void executeWithEntityManager(final EntityManagerRunnable runnable) throws StorageException {
    executeWithSession(new SessionRunnable() {
      @Override
      public void run(IStorageSession session) throws Exception {
        EntityManager em = ((HibernateStorageSession) session).getEntityManager();
        em.setFlushMode(FlushModeType.AUTO);
        runnable.run(em);
      }
    });
  }

  private HibernateStorageSession openSession() throws StorageException {
    try {
      return new HibernateStorageSession(entityManagerFactory.createEntityManager());
    } catch (IllegalStateException e) {
      LOG.log(Level.SEVERE, ERROR_CANNOT_CREATE_CONNCETION, e);
      throw new StorageException(ERROR_CANNOT_CREATE_CONNCETION, e, StorageStatus.STATUS_UNKNOWN_REASON);
    }
  }

  /**
   * Сессия Hibernate хранилища
   */
  public class HibernateStorageSession implements IStorageSession {

    private final EntityManager manager;

    private HibernateStorageSession(EntityManager manager) {
      this.manager = manager;
    }

    @Override
    public void close() throws StorageException {
      try {
        this.manager.close();
      } catch (IllegalStateException e) {
        throw new StorageException(e, StorageStatus.STATUS_UNKNOWN_REASON);
      }
    }

    public EntityManager getEntityManager() {
      return manager;
    }

  }

}
