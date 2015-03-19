package com.example.doku.engine.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.webcore.storage.StorageException;

public interface ITestResource {

  @GET
  @Path("/test/{tid}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response getTestObjectResource(@PathParam("tid") int testObjectId) throws StorageException;

}
