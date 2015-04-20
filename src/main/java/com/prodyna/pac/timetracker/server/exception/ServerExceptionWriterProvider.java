/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.exception;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * A {@link Provider} for writing a {@link ServerRESTException} with it's
 * content into a {@code Response Message Body}. This may be displayed in
 * clients.
 *
 * @author apatrikis
 */
@Provider
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class ServerExceptionWriterProvider implements MessageBodyWriter<ServerRESTException> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return (MediaType.APPLICATION_JSON_TYPE.equals(mediaType) || MediaType.TEXT_PLAIN_TYPE.equals(mediaType));
    }

    @Override
    public long getSize(ServerRESTException t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(ServerRESTException t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        if (isWriteable(type, genericType, annotations, mediaType)) {
            StringBuffer buffer = new StringBuffer();

            buffer = buffer.append("{");
            buffer = buffer.append("\"statusCode\":\"").append(t.getStatusCode().getStatusCode()).append("\",");
            buffer = buffer.append("\"reasonPhrase\":\"").append(t.getStatusCode().getReasonPhrase()).append("\",");
            buffer = buffer.append("\"family\":\"").append(t.getStatusCode().getFamily()).append("\",");
            buffer = buffer.append("\"message\":\"").append(t.getMessage()).append("\",");
            buffer = buffer.append("}");

            httpHeaders.add("X-ServerException", buffer.toString());
            httpHeaders.add("X-ServerException-Type", t.getClass().getName());

            try (PrintStream printStream = new PrintStream(entityStream)) {
                printStream.print(buffer.toString());
            }
        } else {
            throw new UnsupportedOperationException("Not supported MediaType: " + mediaType);
        }
    }
}
