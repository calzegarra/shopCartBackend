package com.shopcart.model.technicalogs.gateways;

public interface ILogger {

    /// <summary>
    /// Debugs the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    void debug(String message);

    /// <summary>
    /// Errors the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    /// <param name="ex">The ex.</param>
    void error(String message, Exception ex);

    /// <summary>
    /// Errors the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    void error(String message);

    /// <summary>
    /// Info the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    void info(String message);

    /// <summary>
    /// Warns the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    /// <param name="ex">The ex.</param>
    void warn(String message, Exception ex);

    /// <summary>
    /// Warns the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    void warn(String message);

    /// <summary>
    /// Fatal the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    void fatal(String message);

    /// <summary>
    /// Fatal the specified message.
    /// </summary>
    /// <param name="message">The message.</param>
    /// <param name="ex">The ex.</param>
    void fatal(String message, Exception ex);

    /// <summary>
    /// Gets the current method.
    /// </summary>
    /// <returns></returns>
}
