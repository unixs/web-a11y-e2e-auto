package net.unixcode.qa.auto.projects.threads;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class IfaceThread implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println("Walk iface" + i);
      //try {
      //  TimeUnit.MILLISECONDS.sleep(50);
      //} catch (InterruptedException e) {
      //  throw new RuntimeException(e);
      //}
    }
  }
}
