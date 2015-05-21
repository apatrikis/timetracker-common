/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.pojo;

import com.prodyna.pac.timetracker.entity.Employee;
import com.prodyna.pac.timetracker.entity.Project;
import com.prodyna.pac.timetracker.entity.TimeRecord;
import com.prodyna.pac.timetracker.server.exception.SearchParametersException;
import java.util.Date;

/**
 * A simple class for grouping data required for searching {@link TimeRecord}s.
 *
 * @author apatrikis
 */
public class TimeRecordSearch {

    private Employee employee;

    private Project project;

    private Date from;

    private Date through;

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
     * Get the lower date boundary.
     *
     * @return The lower date boundary.
     */
    public Date getFrom() {
        return from;
    }

    /**
     * Set the lower date boundary.
     *
     * @param from The uper date boundary.
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * Get the upper date boundary.
     *
     * @return The upper date boundary.
     */
    public Date getThrough() {
        return through;
    }

    /**
     * Set the upper date boundary.
     *
     * @param through The upper date boundary.
     */
    public void setThrough(Date through) {
        this.through = through;
    }

    /**
     * Check if a employee is set.
     *
     * @return {@code true} when not {@code null}.
     */
    public boolean hasEmployee() {
        return (employee != null);
    }

    /**
     * Check if a project is set.
     *
     * @return {@code true} when not {@code null}.
     */
    public boolean hasProject() {
        return (project != null);
    }

    /**
     * Check if the lower date boundary is set.
     *
     * @return {@code true} when not {@code null}.
     */
    public boolean hasFrom() {
        return (from != null);
    }

    /**
     * Check if the upper date boundary is set.
     *
     * @return {@code true} when not {@code null}.
     */
    public boolean hasThrough() {
        return (through != null);
    }

    /**
     * Check if all values are set.
     *
     * @return {@code true} when the values are not {@code null}.
     */
    public boolean hasValueSet() {
        return hasEmployee() || hasProject() || hasFrom() || hasThrough();
    }

    /**
     * Validate the defined values:
     * <ul>
     * <li>a employee or projet must be set, or both</li>
     * <li>the upper date boundary must be chronologicaly after the lower date
     * bound</li>
     * </ul>
     *
     * @throws SearchParametersException if one of the checks fails, e. g. the
     * {@link Project} and {@link Employee} are undefined.
     */
    public void validate() throws SearchParametersException {
        if (!hasEmployee() && !hasProject()) {
            throw new SearchParametersException("Employee or Project must be specified");
        }

        if (hasFrom() && hasThrough()) {
            if (from.after(through)) {
                throw new SearchParametersException(String.format("Dates mismatch : from [%s] must be before through [%s]", getFrom().toString(), getThrough().toString()));
            }
        }
    }

    @Override
    public String toString() {
        return "TimeRecordSearch{" + "Employee=" + employee + ", project=" + project + ", from=" + from + ", through=" + through + '}';
    }
}
