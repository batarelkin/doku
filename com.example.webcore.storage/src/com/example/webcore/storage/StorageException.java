package com.example.webcore.storage;

public class StorageException extends Exception {

  private static final long serialVersionUID = 1L;

  private final StorageStatus status;

  public StorageException(StorageStatus status) {
    super();
    this.status = status;
  }

  public StorageException(String message, StorageStatus status) {
    super(message);
    this.status = status;
  }

  public StorageException(Throwable cause, StorageStatus status) {
    super(cause);
    this.status = status;
  }

  public StorageException(String message, Throwable cause, StorageStatus status) {
    super(message, cause);
    this.status = status;
  }

  public StorageStatus getStatus() {
    return status;
  }

}
