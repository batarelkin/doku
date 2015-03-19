package com.example.webcore.storage;

public class StorageStatus {

  private final int code;

  public static final int ENTITY_NOT_FOUND = 2;
  public static final int BAD_REQUEST = 3;
  public static final int FORBIDDEN = 4;

  public static final StorageStatus STATUS_SUCCESS = new StorageStatus(0);
  public static final StorageStatus STATUS_UNKNOWN_REASON = new StorageStatus(1);
  public static final StorageStatus STATUS_NOT_FOUND = new StorageStatus(ENTITY_NOT_FOUND);
  public static final StorageStatus STATUS_BAD_REQUEST = new StorageStatus(BAD_REQUEST);
  public static final StorageStatus STATUS_FORBIDDEN = new StorageStatus(FORBIDDEN);

  public StorageStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

}
