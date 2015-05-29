/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * A {@link Entity} representing a releation between a {@link Project} and a
 * {@link Employee}. The relation in general is {@code m:n}, meaning that in
 * both directions there may be multiple assignments:
 * <ul>
 * <li>a projetc may be assigned to multiple employees</li>
 * <li>a employee may work in multiple projects</li>
 * </ul>
 * For storing such assigment in the database, a technical ID as primary key is
 * required.
 *
 * @see
 * <a href="http://en.wikibooks.org/wiki/Java_Persistence/ManyToOne">ManyToOne</a>
 * @see
 * <a href="http://en.wikibooks.org/wiki/Java_Persistence/OneToMany">OneToMany</a>
 *
 * @author apatrikis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Project2Employee.findProjectByEmployee", query = "select pe.project from Project2Employee pe where pe.employee = :employee"),
    @NamedQuery(name = "Project2Employee.findEmployeeByProject", query = "select pe.employee from Project2Employee pe where pe.project = :project")
})
@Cacheable(true)
public class Project2Employee implements Serializable {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @NotNull
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @NotNull
    private Employee employee;

    /**
     * Default constructor. Assigns a {@link UUID} to the ID member.
     */
    public Project2Employee() {
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
     * Get the project.
     *
     * @return The project.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Set the project.
     *
     * @param project The project.
     */
    public void setProject(Project project) {
        this.project = project;
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
        final Project2Employee other = (Project2Employee) obj;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Project2Employee{" + "id=" + id + ", project=" + project + ", employee=" + employee + '}';
    }
}
