/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

import com.prodyna.pac.timetracker.server.exception.EntityDataException;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A {@link Entity} representing a Project. A project has an ID which is used as
 * primary key, and is owned by somebody who is in charge for approving booked
 * {@link TimeRecord} entries. It also has a duration which identifies the valid
 * time range for the project, as well as a lock flag to indicate that the
 * project may not be used for time bookings.
 *
 * @author apatrikis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "from Project p"),
    @NamedQuery(name = "Project.findByOwner", query = "from Project p where p.owner = :employee")
})
@Cacheable(true)
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Size(min = 1, max = 50)
    private String projectId;

    @Size(min = 5, max = 50)
    @Column(nullable = false)
    @NotNull
    private String title;

    @Size(min = 5, max = 255)
    @Column(nullable = false)
    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @NotNull
    private Employee owner;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    @NotNull
    private Date startDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    @NotNull
    private Date endDate;

    @Column(nullable = false)
    @NotNull
    private boolean locked;

    /**
     * Get the project ID, which is the {@code primary key}.
     *
     * @return The projetc ID.
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Set the project ID, which is the {@code primary key}.
     *
     * @param projectId The projet ID.
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * Get the title.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title.
     *
     * @param title The title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the description.
     *
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * @param description The description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the owner.
     *
     * @return The owner.
     */
    public Employee getOwner() {
        return owner;
    }

    /**
     * Set the owner.
     *
     * @param owner The owner.
     */
    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    /**
     * Get the startDate.
     *
     * @return The startDate.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the startDate.
     *
     * @param startDate The startDate.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the endDate.
     *
     * @return The endDate.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set the endDate.
     *
     * @param endDate The endDate.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Get the lock flag.
     *
     * @return The lock flag.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Set the lock flag.
     *
     * @param locked The lock flag.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Check if the provided data is valid.
     *
     * @throws EntityDataException in case there is a data mismatch, e. g. the
     * date ranges are invalid.
     */
    public void checkDateValues() throws EntityDataException {
        if ((startDate == null) || (endDate == null)) {
            throw new EntityDataException("Both start and end date must be set");
        }
        if (startDate.after(endDate)) {
            throw new EntityDataException(String.format("Dates mismatch : start date [%s] must be before end date [%s]", startDate.toString(), endDate.toString()));
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.projectId);
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
        final Project other = (Project) obj;
        return this.projectId.equals(other.projectId);
    }

    @Override
    public String toString() {
        return "Project{" + "projectId=" + projectId + ", title=" + title + ", description=" + description + ", owner=" + owner + ", startDate=" + startDate + ", endDate=" + endDate + ", locked=" + locked + '}';
    }
}
