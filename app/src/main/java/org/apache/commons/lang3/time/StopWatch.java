package org.apache.commons.lang3.time;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;
import org.apache.commons.lang3.tuple.ImmutablePair;

/* JADX INFO: loaded from: classes6.dex */
public class StopWatch {
    private final String message;
    private State runningState;
    private SplitState splitState;
    private final List splits;
    private Instant startInstant;
    private long startTimeNanos;
    private Instant stopInstant;
    private long stopTimeNanos;

    private enum SplitState {
        SPLIT,
        UNSPLIT
    }

    private enum State {
        RUNNING { // from class: org.apache.commons.lang3.time.StopWatch.State.1
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return false;
            }
        },
        STOPPED { // from class: org.apache.commons.lang3.time.StopWatch.State.2
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED { // from class: org.apache.commons.lang3.time.StopWatch.State.3
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return true;
            }
        },
        UNSTARTED { // from class: org.apache.commons.lang3.time.StopWatch.State.4
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return false;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return true;
            }

            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return false;
            }
        };

        abstract boolean isStarted();

        abstract boolean isStopped();

        abstract boolean isSuspended();
    }

    public static StopWatch create() {
        return new StopWatch();
    }

    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    public StopWatch() {
        this(null);
    }

    public StopWatch(String str) {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
        this.splits = new ArrayList();
        this.message = str;
    }

    public String formatSplitTime() {
        return DurationFormatUtils.formatDurationHMS(getSplitDuration().toMillis());
    }

    public String formatTime() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public <T> T get(Supplier<T> supplier) {
        startResume();
        try {
            return supplier.get();
        } finally {
            suspend();
        }
    }

    public Duration getDuration() {
        return Duration.ofNanos(getNanoTime());
    }

    public String getMessage() {
        return this.message;
    }

    public List<Split> getSplits() {
        return Collections.unmodifiableList(this.splits);
    }

    public long getNanoTime() {
        long jNanoTime;
        long j;
        int iOrdinal = this.runningState.ordinal();
        if (iOrdinal == 0) {
            jNanoTime = System.nanoTime();
            j = this.startTimeNanos;
        } else {
            if (iOrdinal != 1 && iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return 0L;
                }
                throw new IllegalStateException("Illegal running state has occurred.");
            }
            jNanoTime = this.stopTimeNanos;
            j = this.startTimeNanos;
        }
        return jNanoTime - j;
    }

    public Duration getSplitDuration() {
        return Duration.ofNanos(getSplitNanoTime());
    }

    public long getSplitNanoTime() {
        if (this.splitState != SplitState.SPLIT) {
            throw new IllegalStateException("Stopwatch must be split to get the split time.");
        }
        List list = this.splits;
        return ((Split) list.get(list.size() - 1)).getRight().toNanos();
    }

    @Deprecated
    public long getSplitTime() {
        return nanosToMillis(getSplitNanoTime());
    }

    public Instant getStartInstant() {
        if (this.runningState == State.UNSTARTED) {
            throw new IllegalStateException("Stopwatch has not been started");
        }
        return this.startInstant;
    }

    @Deprecated
    public long getStartTime() {
        return getStartInstant().toEpochMilli();
    }

    public Instant getStopInstant() {
        if (this.runningState == State.UNSTARTED) {
            throw new IllegalStateException("Stopwatch has not been started");
        }
        return this.stopInstant;
    }

    @Deprecated
    public long getStopTime() {
        return getStopInstant().toEpochMilli();
    }

    public <T, E extends Throwable> T getT(FailableSupplier<T, E> failableSupplier) throws Throwable {
        startResume();
        try {
            return failableSupplier.get();
        } finally {
            suspend();
        }
    }

    public long getTime() {
        return nanosToMillis(getNanoTime());
    }

    public long getTime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
    }

    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    public boolean isStopped() {
        return this.runningState.isStopped();
    }

    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    private long nanosToMillis(long j) {
        return j / 1000000;
    }

    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
        this.splits.clear();
    }

    public void resume() {
        if (this.runningState != State.SUSPENDED) {
            throw new IllegalStateException("Stopwatch must be suspended to resume.");
        }
        this.startTimeNanos += System.nanoTime() - this.stopTimeNanos;
        this.runningState = State.RUNNING;
    }

    public void run(Runnable runnable) {
        startResume();
        try {
            runnable.run();
        } finally {
            suspend();
        }
    }

    public <E extends Throwable> void runT(FailableRunnable<E> failableRunnable) throws Throwable {
        startResume();
        try {
            failableRunnable.run();
        } finally {
            suspend();
        }
    }

    public void split() {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException("Stopwatch is not running.");
        }
        this.stopTimeNanos = System.nanoTime();
        this.splitState = SplitState.SPLIT;
        this.splits.add(new Split(String.valueOf(this.splits.size()), Duration.ofNanos(this.stopTimeNanos - this.startTimeNanos)));
    }

    public void split(String str) {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException("Stopwatch is not running.");
        }
        this.stopTimeNanos = System.nanoTime();
        this.splitState = SplitState.SPLIT;
        this.splits.add(new Split(str, Duration.ofNanos(this.stopTimeNanos - this.startTimeNanos)));
    }

    public void start() {
        State state = this.runningState;
        if (state == State.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted.");
        }
        if (state != State.UNSTARTED) {
            throw new IllegalStateException("Stopwatch already started.");
        }
        this.startTimeNanos = System.nanoTime();
        this.startInstant = Instant.now();
        this.runningState = State.RUNNING;
        this.splits.clear();
    }

    private void startResume() {
        if (isStopped()) {
            start();
        } else if (isSuspended()) {
            resume();
        }
    }

    public void stop() {
        State state = this.runningState;
        State state2 = State.RUNNING;
        if (state != state2 && state != State.SUSPENDED) {
            throw new IllegalStateException("Stopwatch is not running.");
        }
        if (state == state2) {
            this.stopTimeNanos = System.nanoTime();
            this.stopInstant = Instant.now();
        }
        this.runningState = State.STOPPED;
    }

    public void suspend() {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException("Stopwatch must be running to suspend.");
        }
        this.stopTimeNanos = System.nanoTime();
        this.stopInstant = Instant.now();
        this.runningState = State.SUSPENDED;
    }

    public String toSplitString() {
        String string = Objects.toString(this.message, "");
        String splitTime = formatSplitTime();
        if (string.isEmpty()) {
            return splitTime;
        }
        return string + " " + splitTime;
    }

    public String toString() {
        String string = Objects.toString(this.message, "");
        String time = formatTime();
        if (string.isEmpty()) {
            return time;
        }
        return string + " " + time;
    }

    public void unsplit() {
        if (this.splitState != SplitState.SPLIT) {
            throw new IllegalStateException("Stopwatch has not been split.");
        }
        this.splitState = SplitState.UNSPLIT;
        List list = this.splits;
        list.remove(list.size() - 1);
    }

    public static final class Split extends ImmutablePair<String, Duration> {
        public Split(String str, Duration duration) {
            super(str, duration);
        }

        public String getLabel() {
            return getLeft();
        }

        public Duration getDuration() {
            return getRight();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public String toString() {
            return String.format("Split [%s, %s])", getLabel(), getDuration());
        }
    }
}
