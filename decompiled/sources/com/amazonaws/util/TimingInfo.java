package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class TimingInfo {
    private Long endTimeNano;
    private final Long startEpochTimeMilli;
    private final long startTimeNano;

    public void addSubMeasurement(String str, TimingInfo timingInfo) {
    }

    public List<TimingInfo> getAllSubMeasurements(String str) {
        return null;
    }

    public Number getCounter(String str) {
        return null;
    }

    public TimingInfo getLastSubMeasurement(String str) {
        return null;
    }

    public TimingInfo getSubMeasurement(String str) {
        return null;
    }

    public TimingInfo getSubMeasurement(String str, int i) {
        return null;
    }

    public void incrementCounter(String str) {
    }

    public void setCounter(String str, long j) {
    }

    public static TimingInfo startTiming() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo startTimingFullSupport() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    public static TimingInfo startTimingFullSupport(long j) {
        return new TimingInfoFullSupport(null, j, null);
    }

    public static TimingInfo newTimingInfoFullSupport(long j, long j2) {
        return new TimingInfoFullSupport(null, j, Long.valueOf(j2));
    }

    public static TimingInfo newTimingInfoFullSupport(long j, long j2, long j3) {
        return new TimingInfoFullSupport(Long.valueOf(j), j2, Long.valueOf(j3));
    }

    public static TimingInfo unmodifiableTimingInfo(long j, Long l) {
        return new TimingInfoUnmodifiable(null, j, l);
    }

    public static TimingInfo unmodifiableTimingInfo(long j, long j2, Long l) {
        return new TimingInfoUnmodifiable(Long.valueOf(j), j2, l);
    }

    protected TimingInfo(Long l, long j, Long l2) {
        this.startEpochTimeMilli = l;
        this.startTimeNano = j;
        this.endTimeNano = l2;
    }

    @Deprecated
    public final long getStartTime() {
        if (isStartEpochTimeMilliKnown()) {
            return this.startEpochTimeMilli.longValue();
        }
        return TimeUnit.NANOSECONDS.toMillis(this.startTimeNano);
    }

    @Deprecated
    public final long getStartEpochTimeMilli() {
        Long startEpochTimeMilliIfKnown = getStartEpochTimeMilliIfKnown();
        if (startEpochTimeMilliIfKnown == null) {
            return -1L;
        }
        return startEpochTimeMilliIfKnown.longValue();
    }

    public final Long getStartEpochTimeMilliIfKnown() {
        return this.startEpochTimeMilli;
    }

    public final long getStartTimeNano() {
        return this.startTimeNano;
    }

    @Deprecated
    public final long getEndTime() {
        return getEndEpochTimeMilli();
    }

    @Deprecated
    public final long getEndEpochTimeMilli() {
        Long endEpochTimeMilliIfKnown = getEndEpochTimeMilliIfKnown();
        if (endEpochTimeMilliIfKnown == null) {
            return -1L;
        }
        return endEpochTimeMilliIfKnown.longValue();
    }

    public final Long getEndEpochTimeMilliIfKnown() {
        if (isStartEpochTimeMilliKnown() && isEndTimeKnown()) {
            return Long.valueOf(this.startEpochTimeMilli.longValue() + TimeUnit.NANOSECONDS.toMillis(this.endTimeNano.longValue() - this.startTimeNano));
        }
        return null;
    }

    public final long getEndTimeNano() {
        Long l = this.endTimeNano;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public final Long getEndTimeNanoIfKnown() {
        return this.endTimeNano;
    }

    @Deprecated
    public final double getTimeTakenMillis() {
        Double timeTakenMillisIfKnown = getTimeTakenMillisIfKnown();
        if (timeTakenMillisIfKnown == null) {
            return -1.0d;
        }
        return timeTakenMillisIfKnown.doubleValue();
    }

    public final Double getTimeTakenMillisIfKnown() {
        if (isEndTimeKnown()) {
            return Double.valueOf(durationMilliOf(this.startTimeNano, this.endTimeNano.longValue()));
        }
        return null;
    }

    public static double durationMilliOf(long j, long j2) {
        return TimeUnit.NANOSECONDS.toMicros(j2 - j) / 1000.0d;
    }

    @Deprecated
    public final long getElapsedTimeMillis() {
        Double timeTakenMillisIfKnown = getTimeTakenMillisIfKnown();
        if (timeTakenMillisIfKnown == null) {
            return -1L;
        }
        return timeTakenMillisIfKnown.longValue();
    }

    public final boolean isEndTimeKnown() {
        return this.endTimeNano != null;
    }

    public final boolean isStartEpochTimeMilliKnown() {
        return this.startEpochTimeMilli != null;
    }

    public final String toString() {
        return String.valueOf(getTimeTakenMillis());
    }

    @Deprecated
    public void setEndTime(long j) {
        this.endTimeNano = Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j));
    }

    public void setEndTimeNano(long j) {
        this.endTimeNano = Long.valueOf(j);
    }

    public TimingInfo endTiming() {
        this.endTimeNano = Long.valueOf(System.nanoTime());
        return this;
    }

    public Map<String, List<TimingInfo>> getSubMeasurementsByName() {
        return Collections.emptyMap();
    }

    public Map<String, Number> getAllCounters() {
        return Collections.emptyMap();
    }
}
