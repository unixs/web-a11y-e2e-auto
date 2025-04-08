package net.unixcode.qa.auto.projects.threads.projects.channels;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


public class Main {
  final static protected Logger log = LoggerFactory.getLogger(Main.class);
  public static void main(String @NotNull [] argv) {
    try {
      ApplicationContext ctxt = new AnnotationConfigApplicationContext(DIConfig.class);

      log.info("Ok");
    }
    catch (Exception e) {
      log.error(e.getMessage());
      System.exit(1);
    }
  }

  @Configuration
  @Lazy
  @ImportResource(locations = {"classpath:spring/context.xml"})
  @ComponentScan(basePackages = { "net.unixcode.qa.auto.projects.channels" })
  @PropertySource("classpath:application.properties")
  static class DIConfig {
  }
}
