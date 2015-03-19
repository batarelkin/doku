package com.example.doku.engine.services;

import com.example.doku.model.TestObject;
import com.example.webcore.application.IService;
import com.example.webcore.storage.StorageException;

public interface ITestObjectStorage extends IService {
  
  public TestObject getTestObject(int id) throws StorageException;
  
  public TestObject addTestObject(TestObject obj) throws StorageException;
  
  public TestObject deleteTestObject(TestObject obj) throws StorageException;

}
