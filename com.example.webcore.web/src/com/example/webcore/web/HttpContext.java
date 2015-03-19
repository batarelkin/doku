package com.example.webcore.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author btarelkin
 *
 */
public class HttpContext {
  private final static ThreadLocal<HttpContext> contextThreadLocal = new ThreadLocal<HttpContext>();

  private static final String SESSION_ATTRIBUTE_SESSION_DATA = "session-data";

  static void build(HttpServletRequest request, HttpServletResponse response) {
    contextThreadLocal.set(new HttpContext(request, response));
  }

  static void destroy() {
    contextThreadLocal.remove();
  }

  /**
   * @return ��������, � ������� �������������� ���������������� ������.
   */
  public static HttpContext get() {
    return contextThreadLocal.get();
  }

  private HttpServletRequest request;
  private HttpServletResponse response;

  private HttpContext(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
  }

  /**
   * @return HTTP-������, ������� �������������� � ��������� ������.
   */
  public HttpServletRequest getRequest() {
    return request;
  }

  /**
   * @return HTTP-����� �� ������, ������� �������������� � ��������� ������.
   */
  public HttpServletResponse getResponse() {
    return response;
  }

  /**
   * @return ������, � ������� �������� ������ ������ ������������, �������
   *         ����� ���� ������������.
   */
  public SessionData getSessionData() {
    HttpSession session = request.getSession();
    Object object = session.getAttribute(SESSION_ATTRIBUTE_SESSION_DATA);
    if (object instanceof SessionData) {
      return (SessionData) object;
    } else {
      SessionData data = new SessionData();
      session.setAttribute(SESSION_ATTRIBUTE_SESSION_DATA, data);
      return data;
    }
  }

  /**
   * ���������� ������, ������������ ��������. � ������, ���� ������������
   * ���������, ������ ������������ �� ������� �������.
   * 
   * @return ������ ������������.
   */
  public Locale getLocale() {
    return request.getLocale();
  }
}
