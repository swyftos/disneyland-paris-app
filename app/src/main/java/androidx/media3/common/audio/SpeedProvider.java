package androidx.media3.common.audio;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface SpeedProvider {
    long getNextSpeedChangeTimeUs(long j);

    float getSpeed(long j);
}
