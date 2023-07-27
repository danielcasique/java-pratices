package org.casique.dependecyInyection.withWeld;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * based on https://www.baeldung.com/java-ee-cdi
 */
public class MyApplication {

  public static void main(String[] args) {
    Weld weld = new Weld();
    WeldContainer container = weld.initialize();
    MyDIApplication test = container.instance().select(MyDIApplication.class).get();
    test.processMessages("daniel","daniel@test.com");
    container.shutdown();
  }
}
