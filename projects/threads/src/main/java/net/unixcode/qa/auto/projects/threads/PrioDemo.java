package net.unixcode.qa.auto.projects.threads;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class PrioDemo implements Consumer<ApplicationContext> {

  @Override
  public void accept(@NotNull ApplicationContext ctxt) {
    var t1 = ctxt.getBean(IfaceThreadPrio.class);

    var ifaceRunnable = ctxt.getBean(IfaceThread.class);
    var t2 = new Thread(ifaceRunnable);

    t1.setPriority(Thread.MAX_PRIORITY);
    t2.setPriority(Thread.MIN_PRIORITY);

    t1.start();
    t2.start();


  }
}
