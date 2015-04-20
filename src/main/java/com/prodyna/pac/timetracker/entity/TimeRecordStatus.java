/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

/**
 * The {@code enumeration} of states a {@link TimeRecord} may have.
 *
 * @author apatrikis
 */
public enum TimeRecordStatus {

    /**
     * The record is in booking, values may be changed.
     */
    EDITING,
    /**
     * The record is submitted for approval and may not be edited any more.
     */
    READY_FOR_APPROVAL,
    /**
     * The record was not accepted by the responsible authotity and is rejected
     * for rework.
     */
    REWORK,
    /**
     * The record is booked and may not be changed anymore. This record is
     * archived and therefore cannot be deleted.
     */
    BOOKED;

    /**
     * Matrix of allowed state transitions.
     * <ul>
     * <li>{@code current status}: first array index</li>
     * <li>{@code new status}: second array index</li>
     * </ul>
     */
    public static final boolean[][] WORKFLOW_TRANSITIONS = new boolean[][]{
        {true, true, false, false},
        {true, false, true, true},
        {true, false, false, false},
        {false, false, false, false}
    };
}
