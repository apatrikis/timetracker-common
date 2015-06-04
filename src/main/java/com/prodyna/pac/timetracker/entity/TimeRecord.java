/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
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
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A {@link Entity} representing a time booking record. It's features are:
 * <ul>
 * <li>it is owned by someone</li>
 * <li>it is assigned to one project</li>
 * <li>it has a start time</li>
 * <li>it has a end time</li>
 * <li>is has a pause time</li>
 * <li>it has a status</li>
 * </ul>
 * For storing this data group in the database, a technical ID as primary key is
 * required.
 *
 * @author apatrikis
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "TimeRecord.findAll", query = "from TimeRecord tr")
})
@Cacheable(true)
public class TimeRecord implements Serializable {

    @Id
    @Size(min = 1, max = 50)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @NotNull
    private Employee owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @NotNull
    private Project project;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @NotNull
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @NotNull
    private Date endTime;

    @Min(0)
    @Column(nullable = false)
    @NotNull
    private int pauseMinutes;

    @Column(nullable = false)
    @NotNull
    private TimeRecordStatus recordStatus;

    /**
     * Default constructor. Assigns a {@link UUID} to the ID member.
     */
    public TimeRecord() {
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
     * Get the project.
     *
     * @return The project.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Set the projet.
     *
     * @param project The project.
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Get the start time.
     *
     * @return The start time.
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Set the start time.
     *
     * @param startTime The start time.
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Get the end tim.
     *
     * @return The end time.
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Set the end time.
     *
     * @param endTime The end time.
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Get the pause minutes.
     *
     * @return The pause minutes.
     */
    public int getPauseMinutes() {
        return pauseMinutes;
    }

    /**
     * Set the pause minutes.
     *
     * @param pauseMinutes The pause minutes.
     */
    public void setPauseMinutes(int pauseMinutes) {
        this.pauseMinutes = pauseMinutes;
    }

    /**
     * Get the record status.
     *
     * @return The record status.
     */
    public TimeRecordStatus getRecordStatus() {
        return recordStatus;
    }

    /**
     * Set the record status.
     *
     * @param recordStatus The record status.
     */
    public void setRecordStatus(TimeRecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final TimeRecord other = (TimeRecord) obj;
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return "TimeRecord{" + "id=" + id + ", owner=" + owner + ", project=" + project + ", startTime=" + startTime + ", endTime=" + endTime + ", pauseMinutes=" + pauseMinutes + ", recordStatus=" + recordStatus + '}';
    }
}
