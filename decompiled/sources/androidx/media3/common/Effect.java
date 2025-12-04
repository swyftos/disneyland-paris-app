package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public interface Effect {
    default long getDurationAfterEffectApplied(long j) {
        return j;
    }
}
