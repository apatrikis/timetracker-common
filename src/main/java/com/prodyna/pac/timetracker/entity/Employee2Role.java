/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * A {@link Entity} representing a releation between a {@link Employee} and his assigned {@link EmployeeRole}. The relation in general is {@code m:n}, meaning that in both directions there may be
 * multiple assignments:
 * <ul>
 * <li>a role name may be assigned to multiple employees</li>
 * <li>a employee may have multiple roles</li>
 * </ul>
 * For storing such assigment in the database, a technical ID as primary key is required.
 *
 * @see
 * <a href="http://en.wikibooks.org/wiki/Java_Persistence/ManyToOne">ManyToOne</a>
 * @see
 * <a href="http://en.wikibooks.org/wiki/Java_Persistence/OneToMany">OneToMany</a>
 *
 * @author apatrikis
 */
@Entity
public class Employee2Role implements Serializable {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @NotNull
    private Employee employee;

    @Column(nullable = false)
    @NotNull
    private String roleName;

    /**
     * Default constructor. Assigns a {@link UUID} to the ID member.
     */
    public Employee2Role() {
        id = UUID.randomUUID().toString();
    }

    /**
     * Get the ID, which is the {@code primary key}.
     *
     * @return The ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID, which is the {@code primary key}.
     *
     * @param id The ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the employee.
     *
     * @return The employee.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Set the employee.
     *
     * @param employee The employee.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Get the member role name.
     *
     * @return The member role name.
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set the member role name.
     *
     * @param roleName The member role name.
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Employee2Role other = (Employee2Role) obj;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Employee2Role{" + "id=" + id + ", employee=" + employee + ", roleName=" + roleName + '}';
    }
}
