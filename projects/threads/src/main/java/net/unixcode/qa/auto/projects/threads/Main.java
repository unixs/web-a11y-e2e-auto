package net.unixcode.qa.auto.projects.threads;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
  final static protected Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String @NotNull [] argv) {
    try {
      ApplicationContext ctxt = new AnnotationConfigApplicationContext(DIConfig.class);

      log.info("Threads example.");

      var firstThread = ctxt.getBean(KlassThread.class);
      firstThread.start();

      var ifaceRunnable = ctxt.getBean(IfaceThread.class);
      var secondThread = new Thread(ifaceRunnable);
      secondThread.start();

      var callableThread = ctxt.getBean(CallableThread.class);
      String result;
      try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
        Future<String> future = executorService.submit(callableThread);
        result = future.get();
        executorService.shutdown();
      }

      log.info(result);

      var prioDemo = ctxt.getBean(PrioDemo.class);
      prioDemo.accept(ctxt);
    }
    catch (Exception e) {
      log.error(e.getMessage());
      System.exit(1);
    }
  }

  @Configuration
  @Lazy
  @ImportResource(locations = {"classpath:spring/context.xml"})
  @ComponentScan(basePackages = { "net.unixcode.qa.auto.projects.threads" })
  @PropertySource("classpath:application.properties")
  static class DIConfig {
  }
}

