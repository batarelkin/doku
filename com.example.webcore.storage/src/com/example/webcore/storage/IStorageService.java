package com.example.webcore.storage;

import com.example.webcore.application.IService;

/**
 * Базовый класс для сервисов хранилища.
 * 
 * @author btarelkin
 *
 */
public interface IStorageService extends IService {

  /**
   * При невозможности создать подключение к базе данных.
   */
  public static final String ERROR_CANNOT_CREATE_CONNCETION = "Cannot crete connection";

  /**
   * При невозможности выполнить запрос к базе данных.
   */
  public static final String ERROR_CANNOT_EXECUTE_STATEMENT = "Cannot execute statement";

  /**
   * Выполняет код с использованием подключения к хранилищу (чаще всего к базе
   * данных) с использованием механизма транзакций. Все изменения хранилища
   * будут применены только, если код завершится без исключений, в противном
   * случае транзакция будет отменена
   * 
   * @param transactionRunnable
   * @throws StorageException
   */
  public void executeWithTransaction(SessionRunnable transactionRunnable) throws StorageException;

  /**
   * Выполняет код с использованием подключения к хранилищу (чаще всего к базе
   * данных).
   * 
   * @param runnable
   *          код, который должен быть выполнен, используя сессию хранилища.
   * @throws StorageException
   *           при возникновении любой ошибки работы хранилища.
   */
  public void executeWithSession(SessionRunnable runnable) throws StorageException;

  /**
   * Интерфейс для инструкций, которые должны быть выполнены с подключением к
   * хранилищу.
   */
  public static interface SessionRunnable {

    /**
     * Инструкции, выполняемые с подключением к хранилищу приложения.
     * 
     * @param session
     *          сессия хранилища
     * @throws Exception
     *           при возникновении любой ошибки
     */
    public void run(IStorageSession session) throws Exception;
  }

  /**
   * Текущая сессия хранилища
   */
  public static interface IStorageSession {

    /**
     * Закрывает текущую сессию
     * 
     * @throws StorageException
     *           при возникновении любой ошибки работы хранилища.
     */
    public void close() throws StorageException;
  };

}
