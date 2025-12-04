package com.urbanairship.android.layout.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes5.dex */
public abstract class Timer {
    private long duration;
    private long elapsedTimeMs;
    private boolean isStarted;
    private long remainingTimeMs;
    private long startTimeMs;
    private final Handler handler = new Handler(Looper.myLooper());
    private final Runnable trigger = new Runnable() { // from class: com.urbanairship.android.layout.util.Timer.1
        @Override // java.lang.Runnable
        public void run() {
            if (Timer.this.isStarted) {
                Timer.this.stop();
                Timer.this.onFinish();
            }
        }
    };

    protected abstract void onFinish();

    public Timer(long j) {
        this.duration = j;
        this.remainingTimeMs = j;
    }

    public void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        this.startTimeMs = SystemClock.elapsedRealtime();
        long j = this.remainingTimeMs;
        if (j > 0) {
            this.handler.postDelayed(this.trigger, j);
        } else {
            this.handler.post(this.trigger);
        }
    }

    public void stop() {
        if (this.isStarted) {
            this.elapsedTimeMs += SystemClock.elapsedRealtime() - this.startTimeMs;
            this.isStarted = false;
            this.handler.removeCallbacks(this.trigger);
            this.remainingTimeMs = Math.max(0L, this.remainingTimeMs - (SystemClock.elapsedRealtime() - this.startTimeMs));
        }
    }

    public long getRunTime() {
        if (this.isStarted) {
            return (this.elapsedTimeMs + SystemClock.elapsedRealtime()) - this.startTimeMs;
        }
        return this.elapsedTimeMs;
    }

    public int getProgress() {
        if (this.duration == 0) {
            return 0;
        }
        return (int) ((getRunTime() * 100) / this.duration);
    }

    public boolean isStarted() {
        return this.isStarted;
    }
}
