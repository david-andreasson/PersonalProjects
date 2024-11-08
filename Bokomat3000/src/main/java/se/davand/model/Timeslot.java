package se.davand.model;

import java.time.LocalTime;

public enum Timeslot {
    MORNING(LocalTime.of(7, 0), LocalTime.of(10, 0)),
    LATE_MORNING(LocalTime.of(10, 0), LocalTime.of(13, 0)),
    AFTERNOON(LocalTime.of(13, 0), LocalTime.of(16, 0)),
    LATE_AFTERNOON(LocalTime.of(16, 0), LocalTime.of(19, 0)),
    EVENING(LocalTime.of(19, 0), LocalTime.of(22, 0));

    private final LocalTime startTime;
    private final LocalTime endTime;

    Timeslot(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return name() + " (" + startTime + " - " + endTime + ")";
    }
}
