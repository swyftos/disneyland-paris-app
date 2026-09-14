package com.amazonaws.mobileconnectors.p016s3.transfermanager;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class PauseResult<T> {
    private final Object infoToResume;
    private final PauseStatus pauseStatus;

    public PauseResult(PauseStatus pauseStatus, T t) {
        if (pauseStatus == null) {
            throw new IllegalArgumentException();
        }
        this.pauseStatus = pauseStatus;
        this.infoToResume = t;
    }

    public PauseResult(PauseStatus pauseStatus) {
        this(pauseStatus, null);
    }

    public PauseStatus getPauseStatus() {
        return this.pauseStatus;
    }

    public T getInfoToResume() {
        return (T) this.infoToResume;
    }
}
