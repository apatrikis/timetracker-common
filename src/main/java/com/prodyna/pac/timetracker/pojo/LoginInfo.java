/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.pojo;

import com.prodyna.pac.timetracker.entity.EmployeeRole;
import java.io.Serializable;
import java.util.Objects;

/**
 * A simple {@code POJO} for grouping data required during the login process.
 *
 * @author apatrikis
 */
public class LoginInfo implements Serializable {

    private String email;

    private String password;

    private EmployeeRole employeeRole;

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
     * Get the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     *
     * @param password The password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the role.
     *
     * @return The role.
     */
    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    /**
     * Set the role.
     *
     * @param employeeRole The role.
     */
    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.employeeRole);
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
        final LoginInfo other = (LoginInfo) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.employeeRole != other.employeeRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LoginInfo{" + "email=" + email + ", password=" + "[hidden]" + ", employeeRole=" + employeeRole + '}';
    }
}
