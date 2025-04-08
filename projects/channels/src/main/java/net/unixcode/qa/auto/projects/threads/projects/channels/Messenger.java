package net.unixcode.qa.auto.projects.threads.projects.channels;

import net.unixcode.qa.auto.projects.threads.projects.channels.api.IMessenger;

public class Messenger implements IMessenger {

  @Override
  public String get() {
    return "Hello!";
  }
}
