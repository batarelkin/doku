package com.example.doku.engine.response;

public class EngineResponse<T> {

  public final static String SUCCESS_STATUS = "success";
  public final static String FAIL_STATUS = "fail";
  public final static String ACCEPT_STATUS = "accept";

  private String status;
  private String message;
  private T data;

  private final static EngineResponse<Object> SUCCESS_EMPTY = new EngineResponse<Object>();

  private EngineResponse() {
    this(SUCCESS_STATUS, null, null);
  }

  private EngineResponse(T data) {
    this(SUCCESS_STATUS, null, data);
  }

  private EngineResponse(String message) {
    this(FAIL_STATUS, message, null);
  }

  private EngineResponse(String status, String message, T data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public static EngineResponse<Object> successEmpty() {
    return SUCCESS_EMPTY;
  }

  public static <T> EngineResponse<T> success(T data) {
    return new EngineResponse<T>(data);
  }

  public static EngineResponse<Object> fail(String message) {
    return new EngineResponse<Object>(message);
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  protected void setStatus(String status) {
    this.status = status;
  }

  protected void setMessage(String message) {
    this.message = message;
  }

  protected void setData(T data) {
    this.data = data;
  }

}
