package androidx.media3.common.util;

import androidx.camera.video.AudioStats;
import androidx.media3.common.C0740C;
import androidx.media3.common.audio.SpeedProvider;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class SpeedProviderUtil {
    public static long getDurationAfterSpeedProviderApplied(SpeedProvider speedProvider, long j) {
        long j2 = 0;
        double dMin = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (j2 < j) {
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(j2);
            if (nextSpeedChangeTimeUs == C0740C.TIME_UNSET) {
                nextSpeedChangeTimeUs = Long.MAX_VALUE;
            }
            dMin += (Math.min(nextSpeedChangeTimeUs, j) - j2) / ((double) speedProvider.getSpeed(j2));
            j2 = nextSpeedChangeTimeUs;
        }
        return Math.round(dMin);
    }
}
