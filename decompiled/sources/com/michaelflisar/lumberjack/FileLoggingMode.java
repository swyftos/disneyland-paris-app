package com.michaelflisar.lumberjack;

/* loaded from: classes4.dex */
public enum FileLoggingMode {
    DAILY_ROLLOVER("%d"),
    MONTHLY_ROLLOVER("%d{yyyy/MM}/"),
    WEEKLY_ROLLOVER("%d{yyyy-ww}"),
    FILE_SIZE_ROLLOVER("%i");

    private String fileNamePattern;

    FileLoggingMode(String str) {
        this.fileNamePattern = str;
    }

    public String getFileNamePattern() {
        return this.fileNamePattern;
    }
}
