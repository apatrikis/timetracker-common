/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

/**
 * The {@code enumeration} of defined roles a {@link Employee} may be assigend.
 *
 * @author apatrikis
 */
public enum EmployeeRole {

    /**
     * Simple user, who is allowed to book times on projets.
     */
    USER,
    /**
     * Manager, who is allowed to assign users to projects and approve or reject
     * time bookings. He may edit the project details.
     */
    MANAGER,
    /**
     * Administrator, who is allowed to create projects and users within the
     * application.
     */
    ADMIN;

    public static final String ROLE_USER = "USER";
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_ADMIN = "ADMIN";
}
