package org.example;

import java.time.LocalDateTime;

public final class PackageData {

    private final int success;
    private final int failed;
    private final LocalDateTime sentAt;

    public PackageData(int success, int failed, LocalDateTime sentAt) {
        this.success = success;
        this.failed = failed;
        this.sentAt = sentAt;
    }

    public int getFailed() {
        return failed;
    }

    public int getSuccess() {
        return success;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }
}
