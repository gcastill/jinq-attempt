package com.nelis.jinqexample.eclipselink;

import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.sessions.Session;

public class JPAEclipseLinkSessionCustomizer implements SessionCustomizer {
  @Override
  public void customize(Session aSession) throws Exception {

    // create a custom logger
    SessionLog aCustomLogger = new Log4jSessionLog();
    aCustomLogger.setLevel(1); // Logging level finest
    aSession.setSessionLog(aCustomLogger);
  }

}