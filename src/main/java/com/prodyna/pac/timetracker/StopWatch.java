/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker;

/**
 * Implementation of a stop watch for measuring elapsed time, in milliseconds.
 *
 * @author apatrikis
 */
public class StopWatch {

    private long startTime;
    private long elapsedTime;
    private boolean isRunning;

    /**
     * Default constructor.
     */
    public StopWatch() {
        reset();
    }

    /**
     * Reset all internal time fields.
     */
    private void reset() {
        startTime = 0;
        elapsedTime = 0;
        isRunning = false;
    }

    /**
     * Resume (continue) measuring the time. If already resumed, nothing
     * happens.
     *
     * @return The current instance.
     */
    public StopWatch resume() {
        if (!isRunning()) {
            isRunning = true;
            startTime = System.currentTimeMillis();
        }

        return this;
    }

    /**
     * Start measuring the time. If already started, nothing happens.
     *
     * @return The current instance.
     */
    public StopWatch start() {
        if (!isRunning()) {
            reset();
            resume();
        }

        return this;
    }

    /**
     * Stop measuring the time. If already stopped, nothing happens.
     *
     * @return The current instance.
     */
    public StopWatch stop() {
        if (isRunning()) {
            elapsedTime += (System.currentTimeMillis() - startTime);
            isRunning = false;
        }

        return this;
    }

    /**
     * Return the running status.
     *
     * @return <code>true</code> if {@link #start()} or {@link #resume()} was
     * called.
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Returns the currently elapsed time, depending on the {@link #isRunning()}
     * state.
     *
     * @return The number of elapsed milliseconds.
     */
    public long getElapsedTime() {
        return (isRunning())
                ? (System.currentTimeMillis() - startTime + elapsedTime)
                : elapsedTime;
    }

    @Override
    public String toString() {
        return new StringBuilder("Elapsed stop watch time: ").append(getElapsedTime()).append("[ms]").toString();
    }
}
