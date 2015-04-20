/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.exception;

import javax.ws.rs.core.Response;

/**
 * Base class for all {@code REST} specific {@link Exception}s wich can be
 * thrown by the application server. As a default, the {@link Response.Status}
 * is set to {@link Response.Status#BAD_REQUEST}.
 *
 * @author apatrikis
 */
public class ServerRESTException extends Exception {

    private Response.StatusType statusCode;

    /**
     * Default constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#BAD_REQUEST}.
     */
    public ServerRESTException() {
        this.statusCode = Response.Status.BAD_REQUEST;
    }

    /**
     * Constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#BAD_REQUEST}.
     *
     * @param message The {@link Exception#Exception(java.lang.String)} to set.
     */
    public ServerRESTException(String message) {
        super(message);
        this.statusCode = Response.Status.BAD_REQUEST;
    }

    /**
     * Constructor. As a default, the {@link Response.Status} is set to
     * {@link Response.Status#BAD_REQUEST}.
     *
     * @param message The
     * {@link Exception#Exception(java.lang.String, java.lang.Throwable)} to
     * set.
     * @param cause The
     * {@link Exception#Exception(java.lang.String, java.lang.Throwable)} to
     * set.
     */
    public ServerRESTException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = Response.Status.BAD_REQUEST;
    }

    /**
     * Get the status code.
     *
     * @return The status code.
     */
    public Response.StatusType getStatusCode() {
        return statusCode;
    }

    /**
     * Set the status code.
     *
     * @param statusCode The status code.
     */
    public void setStatusCode(Response.StatusType statusCode) {
        this.statusCode = statusCode;
    }
}
