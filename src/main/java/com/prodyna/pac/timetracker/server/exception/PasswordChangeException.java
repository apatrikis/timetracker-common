/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.exception;

import javax.ws.rs.core.Response;

/**
 * Specialized {@link ServerRESTException} for indicating that there is a
 * problem eith changing the password. As a default, the {@link Response.Status}
 * is set to {@link Response.Status#CONFLICT}.
 *
 * @author apatrikis
 */
public class PasswordChangeException extends ServerRESTException {

    /**
     * Default constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     */
    public PasswordChangeException() {
        setStatusCode(Response.Status.CONFLICT);
    }

    /**
     * Constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     *
     * @param message The
     * {@link ServerRESTException#ServerRESTException(java.lang.String)} to set.
     */
    public PasswordChangeException(String message) {
        super(message);
        setStatusCode(Response.Status.CONFLICT);
    }

    /**
     * Constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     *
     * @param message The
     * {@link ServerRESTException#ServerRESTException(java.lang.String, java.lang.Throwable)}
     * to set.
     * @param cause The
     * {@link ServerRESTException#ServerRESTException(java.lang.String, java.lang.Throwable)}
     * to set.
     */
    public PasswordChangeException(String message, Throwable cause) {
        super(message, cause);
        setStatusCode(Response.Status.CONFLICT);
    }
}
