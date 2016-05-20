package com.nelis.jinqexample.eclipselink;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;

public class Log4jSessionLog extends AbstractSessionLog {

  private Log log = LogFactory.getLog(Log4jSessionLog.class);

  @Override
  public void log(SessionLogEntry sessionLogEntry) {
    Throwable exception = sessionLogEntry.getException();
    Object[] parameters = sessionLogEntry.getParameters();
    String message = String.format("message=%s, paramaters=%s", sessionLogEntry.getMessage(),
        parameters != null ? Arrays.toString(parameters) : null);
    if (exception == null) {
      log.info(message);
    } else {
      log.warn(message, exception);
    }
  }

}
