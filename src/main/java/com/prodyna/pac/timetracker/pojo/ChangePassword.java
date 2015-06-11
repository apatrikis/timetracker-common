/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.pojo;

import java.util.Objects;

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
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.email);
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
        final ChangePassword other = (ChangePassword) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.currentPassword, other.currentPassword)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChangePassword{" + "email=" + email + ", currentPassword=" + "[hidden]" + ", newPassword=" + "[hidden]" + '}';
    }
}
