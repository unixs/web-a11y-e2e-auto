package net.unixcode.qa.auto.projects.channels;

import net.unixcode.qa.auto.projects.channels.api.IMessenger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:spring/context.xml"})
class MessengerTest {
  @Autowired
  private IMessenger messenger;

  @Test
  void produceMessage() {
    assertEquals(messenger.get(), "Hello!");
  }
}
