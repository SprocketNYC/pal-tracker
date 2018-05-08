package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry find(Long id);

    TimeEntry update(Long id, TimeEntry timeEntry);

    TimeEntry create(TimeEntry timeEntry);

    void delete(Long id);


    List<TimeEntry> list();
}