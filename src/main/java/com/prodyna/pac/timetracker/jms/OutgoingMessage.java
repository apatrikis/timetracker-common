/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.jms;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * Annotatin for {@code JMS Messages} for identifyong messages that are send.
 * This is an distinction to {@link IncommingMessage} where a message are
 * received from a sender.
 *
 * @author apatrikis
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface OutgoingMessage {
}
