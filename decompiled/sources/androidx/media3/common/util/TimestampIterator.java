package androidx.media3.common.util;

import androidx.media3.common.C;

@UnstableApi
/* loaded from: classes.dex */
public interface TimestampIterator {
    TimestampIterator copyOf();

    default long getLastTimestampUs() {
        return C.TIME_UNSET;
    }

    boolean hasNext();

    long next();
}
