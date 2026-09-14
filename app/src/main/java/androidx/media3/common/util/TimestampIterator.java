package androidx.media3.common.util;

import androidx.media3.common.C0740C;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface TimestampIterator {
    TimestampIterator copyOf();

    default long getLastTimestampUs() {
        return C0740C.TIME_UNSET;
    }

    boolean hasNext();

    long next();
}
