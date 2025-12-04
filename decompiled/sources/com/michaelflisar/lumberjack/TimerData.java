package com.michaelflisar.lumberjack;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class TimerData {
    private long mStart = 0;
    private long mEnd = 0;
    private List mLaps = null;

    TimerData start() {
        if (!isRunning()) {
            this.mStart = System.currentTimeMillis();
        }
        return this;
    }

    Long stop() {
        if (!isRunning() || isEnded()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mEnd = jCurrentTimeMillis;
        return Long.valueOf(jCurrentTimeMillis - this.mStart);
    }

    Long lap() {
        long jLongValue;
        if (!isRunning()) {
            return null;
        }
        if (this.mLaps == null) {
            this.mLaps = new ArrayList();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mLaps.add(Long.valueOf(jCurrentTimeMillis));
        if (this.mLaps.size() == 1) {
            jLongValue = this.mStart;
        } else {
            jLongValue = ((Long) this.mLaps.get(r4.size() - 2)).longValue();
        }
        return Long.valueOf(jCurrentTimeMillis - jLongValue);
    }

    Long getStart() {
        if (isRunning()) {
            return Long.valueOf(this.mStart);
        }
        return null;
    }

    Long getEnd() {
        if (isRunning() && isEnded()) {
            return Long.valueOf(this.mEnd);
        }
        return null;
    }

    List getLaps() {
        return this.mLaps;
    }

    Long getLastLapTotal() {
        List list;
        if (!isRunning() || (list = this.mLaps) == null) {
            return null;
        }
        return Long.valueOf(((Long) list.get(list.size() - 1)).longValue() - this.mStart);
    }

    private boolean isRunning() {
        return this.mStart != 0;
    }

    private boolean isEnded() {
        return this.mEnd != 0;
    }
}
