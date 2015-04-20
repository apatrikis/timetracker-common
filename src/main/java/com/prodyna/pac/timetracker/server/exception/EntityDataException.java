/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.exception;

import javax.ws.rs.core.Response;

/**
 * Specialized {@link ServerRESTException} for indicating that there is some
 * kind of data mismatch, and the request cannot be served. As a default, the
 * {@link Response.Status} is set to {@link Response.Status#CONFLICT}.
 *
 * @author apatrikis
 */
public class EntityDataException extends ServerRESTException {

    /**
     * Default constructor.As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     */
    public EntityDataException() {
        setStatusCode(Response.Status.CONFLICT);
    }

    /**
     * Constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#CONFLICT}.
     *
     * @param message The
     * {@link ServerRESTException#ServerRESTException(java.lang.String)} to set.
     */
    public EntityDataException(String message) {
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
    public EntityDataException(String message, Throwable cause) {
        super(message, cause);
        setStatusCode(Response.Status.CONFLICT);
    }
}
