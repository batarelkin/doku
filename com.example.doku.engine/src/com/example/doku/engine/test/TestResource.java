package com.example.doku.engine.test;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.example.doku.engine.response.EngineResponse;
import com.example.doku.engine.services.ITestObjectStorage;
import com.example.doku.model.TestObject;
import com.example.webcore.application.AC;
import com.example.webcore.storage.StorageException;

@Path("/v1/test")
public class TestResource implements ITestResource {

  @Override
  public Response getTestObjectResource(int testObjectId) throws StorageException {
    ITestObjectStorage toStorage = AC.get().getService(ITestObjectStorage.class);
    TestObject obj = toStorage.getTestObject(testObjectId);
    System.out.println(obj);
    return Response.ok(EngineResponse.success(obj)).build();
  }

}
