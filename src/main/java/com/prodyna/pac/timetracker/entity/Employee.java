/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

import com.prodyna.pac.timetracker.Security;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A {@link Entity} representing a employee. He is uniquely identified by his
 * email.
 *
 * @author apatrikis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "from Employee e")
})
@Cacheable(true)
public class Employee implements Serializable {

    @Size(min = 1, max = 50)
    @Column(nullable = false)
    @NotNull
    private String firstName;

    @Size(min = 1, max = 50)
    @Column(nullable = false)
    @NotNull
    private String lastName;

    @Id
    @Size(min = 5, max = 140)
    private String email;

    @Size(min = 4, max = 70)
    @Column(nullable = false)
    @NotNull
    private String password;

    /**
     * Get the first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the email, which is the {@code primary key}.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email, which is the {@code primary key}.
     *
     * @param email The email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the password. May be {@code null} as there may be an external
     * authentication provider.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     * <b>IMPORTANT</B>: hash the password before storing it in the database.
     *
     * @param password The password.
     *
     * @see Security#passwordHashSHA256(java.lang.String)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.email);
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
        final Employee other = (Employee) obj;
        return this.email.equals(other.email);
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + "*****" + '}';
    }
}
