package androidx.test.espresso.core.internal.deps.guava.base;

/* loaded from: classes2.dex */
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new Ticker() { // from class: androidx.test.espresso.core.internal.deps.guava.base.Ticker.1
        @Override // androidx.test.espresso.core.internal.deps.guava.base.Ticker
        public long read() {
            return Platform.systemNanoTime();
        }
    };

    protected Ticker() {
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    public abstract long read();
}
