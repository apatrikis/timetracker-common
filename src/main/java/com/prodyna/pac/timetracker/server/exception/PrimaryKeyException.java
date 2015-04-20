/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.exception;

import javax.ws.rs.core.Response;

/**
 * Specialized {@link ServerRESTException} for indicating that there is a
 * problem with the use of the {@code Promary Key}. As a default, the
 * {@link Response.Status} is set to {@link Response.Status#CONFLICT}.
 *
 * @author apatrikis
 */
public class PrimaryKeyException extends ServerRESTException {

    /**
     * Default constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     */
    public PrimaryKeyException() {
        setStatusCode(Response.Status.CONFLICT);
    }

    /**
     * Constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     *
     * @param message The
     * {@link ServerRESTException#ServerRESTException(java.lang.String)} to set.
     */
    public PrimaryKeyException(String message) {
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
    public PrimaryKeyException(String message, Throwable cause) {
        super(message, cause);
        setStatusCode(Response.Status.CONFLICT);
    }
}
