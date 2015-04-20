/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.pojo;

/**
 * A simple class for grouping data required during a password change request.
 *
 * @author apatrikis
 */
public class ChangePassword {

    private String email;

    private String currentPassword;

    private String newPassword;

    /**
     * Get the email.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email.
     *
     * @param email The email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the current password.
     *
     * @return The current password.
     */
    public String getCurrentPassword() {
        return currentPassword;
    }

    /**
     * Set the current password.
     *
     * @param currentPassword The current password.
     */
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    /**
     * Get the new password.
     *
     * @return The new password.
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Set the new password.
     *
     * @param newPassword The new password.
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ChangePassword{" + "email=" + email + ", currentPassword=" + "[hidden]" + ", newPassword=" + "[hidden]" + '}';
    }
}
