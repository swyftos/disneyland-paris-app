package androidx.test.espresso.core.internal.deps.guava.cache;

/* loaded from: classes2.dex */
public interface AbstractCache$StatsCounter {
    void recordEviction();

    void recordHits(int i);

    void recordLoadException(long j);

    void recordLoadSuccess(long j);

    void recordMisses(int i);
}
