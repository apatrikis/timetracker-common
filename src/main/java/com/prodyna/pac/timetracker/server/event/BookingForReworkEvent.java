/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.server.event;

import java.util.Objects;

/**
 * {@code POJO} for holding data to send within an {@code Event} to notify
 * clients about the status change of a booking.
 *
 * @author apatrikis
 */
public class BookingForReworkEvent {

    private final String receiver;

    private final String message;

    /**
     * Constructor.
     *
     * @param receiver The message receiver identification.
     * @param message The message for the receiver.
     */
    public BookingForReworkEvent(String receiver, String message) {
        this.receiver = receiver;
        this.message = message;
    }

    /**
     * Get the receiver.
     *
     * @return The receiver.
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Get the message.
     *
     * @return The message.
     */
    public String getMessage() {
        return message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.receiver);
        hash = 53 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookingForReworkEvent other = (BookingForReworkEvent) obj;
        if (!Objects.equals(this.receiver, other.receiver)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookingForReworkEvent{" + "receiver=" + receiver + ", message=" + message + '}';
    }
}
