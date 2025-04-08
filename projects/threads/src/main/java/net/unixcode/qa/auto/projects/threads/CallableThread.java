package net.unixcode.qa.auto.projects.threads;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
public class CallableThread implements Callable<String> {
  @Override
  public String call() {
    var builder  = new StringBuilder();

    for (int i = 0; i < 7; i++) {
      builder.append("Callable iface" + i + "\n");
      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    return builder.toString();
  }
}
