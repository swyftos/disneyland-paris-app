package ch.qos.logback.classic.android;

/* loaded from: classes2.dex */
final class SystemClock implements Clock {
    SystemClock() {
    }

    @Override // ch.qos.logback.classic.android.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
