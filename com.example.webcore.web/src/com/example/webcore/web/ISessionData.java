package com.example.webcore.web;

import com.example.webcore.application.core.AppException;

/**
 * ������� ��������� ��� ��������� ��������, ����������� � ������.
 * 
 * @param <P>
 *          ������� ��� ��������, ����������� � ������.
 * @author Igor Pavlenko
 */
public interface ISessionData<P> {
  /**
   * ����� ������� � �������� ������.
   * 
   * @param name
   *          ��� ��������.
   * @param value
   *          �������� ��������.
   * @throws AppException
   */
  void setAttribute(String name, P value) throws AppException;

  /**
   * ������� ������� � �������� ������.
   * 
   * @param name
   *          ��� ��������.
   * @throws AppException
   */
  void removeAttribute(String name) throws AppException;

  /**
   * ���������� ������� � ��������� ������. � ������, ���� �������� ����, ���
   * ������� �� ���� ����, ���������� <code>null</code>.
   * 
   * @param <T>
   *          ���, � �������� ��������� �������� �������.
   * @param clazz
   *          ����� ����, � �������� ��������� �������� �������.
   * @param name
   *          ��� ��������.
   * @return ������� � ��������� ������. ����� ���� <code>null</code>.
   * @throws AppException
   */
  <T extends P> T getAttribute(Class<T> clazz, String name) throws AppException;
}
