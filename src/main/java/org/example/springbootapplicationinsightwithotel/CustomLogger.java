package org.example.springbootapplicationinsightwithotel;

import org.apache.logging.log4j.LogManager;
;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.StringMapMessage;

public class CustomLogger {
    private static final Logger logger = LogManager.getLogger(CustomLogger.class);

    public static StringMapMessage MessageFactory(String message) {
        return new StringMapMessage().with("message", message);
    }

    public static void trace(StringMapMessage message) {
        logger.trace(message);
    }

    public static void trace(String message) {
        StringMapMessage msg = new StringMapMessage().with("message", message);
        trace(msg);
    }

    public static void debug(StringMapMessage message) {
        logger.debug(message);
    }

    public static void debug(String message) {
        StringMapMessage msg = new StringMapMessage().with("message", message);
        debug(msg);
    }

    public static void info(String message) {
        StringMapMessage msg = new StringMapMessage().with("message", message);
        logger.info(msg);
    }

    public static  void info(StringMapMessage message) {
        logger.info(message);
    }

    public static void warn(StringMapMessage message) {
        logger.warn(message);
    }

    public static void warn(String message) {
        StringMapMessage msg = new StringMapMessage().with("message", message);
        warn(msg);
    }

    public static void error(StringMapMessage message) {
        logger.error(message);
    }

    public static void error(String message) {
        StringMapMessage msg = new StringMapMessage().with("message", message);
        error(msg);
    }
}
