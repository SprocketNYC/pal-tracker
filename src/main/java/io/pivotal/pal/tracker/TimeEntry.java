package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {

    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.userId = userId;
        this.projectId = projectId;
        this.date = date;
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public boolean equals(Object other) {
        if (other instanceof TimeEntry) {
            if (other == this) {
                return true;
            }

            TimeEntry self = (TimeEntry) other;
            if (self.id != this.id)
            {
                return false;
            }
            if (self.userId != this.userId)
            {
                return false;
            }
            if (self.projectId != this.projectId)
            {
                return false;
            }
            if (self.hours != this.hours)
            {
                return false;
            }
            if (!self.date.equals(this.date))
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
}
