package com.shopcart.logs;


import com.google.gson.Gson;
import com.shopcart.model.technicalogs.gateways.ILogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class LoggerAdapter implements ILogger {

    private static final Logger logger = LogManager.getLogger(LoggerAdapter.class);

    @Override
    public void debug(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public void error(String message, Exception ex) {
        if (logger.isErrorEnabled()) {
            logger.error(getLogger(message, ex));
        }
    }

    @Override
    public void error(String message) {
        if (logger.isErrorEnabled()) {
            logger.error(getLogger(message));
        }
    }

    @Override
    public void info(String message) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogger(message));
        }
    }

    @Override
    public void warn(String message, Exception ex) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogger(message, ex));
        }
    }

    @Override
    public void warn(String message) {
        if (logger.isWarnEnabled()) {
            logger.fatal(getLogger(message));
        }
    }

    @Override
    public void fatal(String message) {
        if (logger.isFatalEnabled()) {
            logger.fatal(getLogger(message));
        }
    }

    @Override
    public void fatal(String message, Exception ex) {
        if (logger.isFatalEnabled()) {
            logger.fatal(getLogger(message, ex));
        }
    }

    private String getLogger(String message) {
        Gson gson = new Gson();
        LoggerModel log = new LoggerModel(
                message,
                "application",
                "service",
                "name"
        );
        return gson.toJson(log);
    }

    private String getLogger(String message, Exception ex) {
        Gson gson = new Gson();
        LoggerModel log = new LoggerModel(
                "",
                "",
                "", ex
        );
        return gson.toJson(log);
    }

}
