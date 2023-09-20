package org.example;

import java.time.LocalDateTime;

public final class InspectionResult {

    private final int rate;

    private final LocalDateTime from;

    private final LocalDateTime to;

    public InspectionResult(int rate, LocalDateTime from, LocalDateTime localDateTime) {
        this.rate = rate;
        this.from = from;
        to = localDateTime;
    }

    public int getRate() {
        return rate;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
