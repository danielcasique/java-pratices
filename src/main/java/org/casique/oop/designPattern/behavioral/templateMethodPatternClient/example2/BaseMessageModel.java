package org.casique.oop.designPattern.behavioral.templateMethodPatternClient.example2;

public abstract class BaseMessageModel<T> {
  protected String id;
  protected String schemaVersion;
  protected Integer source;
  protected Integer event;
  protected T model;
}
