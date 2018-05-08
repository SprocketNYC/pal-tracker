package io.pivotal.pal.tracker;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntries = new HashMap<>();
    private Long idCounter = 1L;

    public TimeEntry find(Long id) {
        return timeEntries.get(id);
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry found = timeEntries.get(id);

        if (found == null) {
            return null;
        }

        TimeEntry entry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.put(id, entry);
        return entry;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry entry = new TimeEntry(idCounter, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        timeEntries.put(entry.getId(), entry);
        idCounter++;
        return  entry;
    }

    public void delete(Long id) {
        timeEntries.remove(id);
        return;
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }
}
