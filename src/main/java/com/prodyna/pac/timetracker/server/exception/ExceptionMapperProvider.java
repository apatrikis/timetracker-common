/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * A {@link Provider} for catching any {@link Throwable} and putting it into the
 * {@link Response}. Three major types are distinguished:
 * <ul>
 * <li>{@link ServerRESTException}</li>
 * <li>{@link WebApplicationException}</li>
 * <li>other {@link Throwable}</li>
 * </ul>
 *
 * @author apatrikis
 */
@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(getStatusType(exception))
                .entity(getEntity(exception))
                .build();

    }

    /**
     * Extract the {@link Response.StatusType} from the passed
     * {@link Throwable}.
     *
     * @param exception The {@link Throwable}, which may be identified to
     * extract some usefull status.
     * @return The determined status, or
     * {@link Response.Status#INTERNAL_SERVER_ERROR}.
     */
    private Response.StatusType getStatusType(Throwable exception) {
        Response.StatusType status;

        if (exception instanceof ServerRESTException) {
            status = ((ServerRESTException) exception).getStatusCode();
        } else if (exception instanceof WebApplicationException) {
            status = ((WebApplicationException) exception).getResponse().getStatusInfo();
        } else {
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }

        return status;
    }

    /**
     * Return the appropriate {@link GenericEntity} to the passed
     * {@link Throwable}.
     *
     * @param exception The {@link Throwable} to check.
     * @return The matching {@link GenericEntity}.
     */
    private GenericEntity<Object> getEntity(Throwable exception) {
        GenericEntity<Object> entity;

        if (exception instanceof ServerRESTException) {
            entity = new GenericEntity<>((ServerRESTException) exception, ServerRESTException.class);
        } else if (exception instanceof WebApplicationException) {
            entity = new GenericEntity<>((WebApplicationException) exception, WebApplicationException.class);
        } else {
            entity = new GenericEntity<>(exception, exception.getClass());
        }

        return entity;
    }
}
