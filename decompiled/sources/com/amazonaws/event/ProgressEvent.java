package com.amazonaws.event;

/* loaded from: classes2.dex */
public class ProgressEvent {
    public static final int CANCELED_EVENT_CODE = 16;
    public static final int COMPLETED_EVENT_CODE = 4;
    public static final int FAILED_EVENT_CODE = 8;
    public static final int PART_COMPLETED_EVENT_CODE = 2048;
    public static final int PART_FAILED_EVENT_CODE = 4096;
    public static final int PART_STARTED_EVENT_CODE = 1024;
    public static final int PREPARING_EVENT_CODE = 1;
    public static final int RESET_EVENT_CODE = 32;
    public static final int STARTED_EVENT_CODE = 2;
    protected long bytesTransferred;
    protected int eventCode;

    public ProgressEvent(long j) {
        this.bytesTransferred = j;
    }

    public ProgressEvent(int i, long j) {
        this.eventCode = i;
        this.bytesTransferred = j;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public void setEventCode(int i) {
        this.eventCode = i;
    }
}
