package com.amazonaws.mobileconnectors.p016s3.transfermanager;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public enum PauseStatus {
    SUCCESS,
    NOT_STARTED,
    CANCELLED_BEFORE_START,
    NO_EFFECT,
    CANCELLED;

    public boolean isPaused() {
        return this == SUCCESS;
    }

    public boolean isCancelled() {
        return this == CANCELLED || this == CANCELLED_BEFORE_START;
    }

    public boolean unchanged() {
        return this == NOT_STARTED || this == NO_EFFECT;
    }
}
