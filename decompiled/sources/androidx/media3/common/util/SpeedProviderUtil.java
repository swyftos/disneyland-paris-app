package androidx.media3.common.util;

import androidx.camera.video.AudioStats;
import androidx.media3.common.C;
import androidx.media3.common.audio.SpeedProvider;

@UnstableApi
/* loaded from: classes.dex */
public class SpeedProviderUtil {
    public static long getDurationAfterSpeedProviderApplied(SpeedProvider speedProvider, long j) {
        long j2 = 0;
        double dMin = AudioStats.AUDIO_AMPLITUDE_NONE;
        while (j2 < j) {
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(j2);
            if (nextSpeedChangeTimeUs == C.TIME_UNSET) {
                nextSpeedChangeTimeUs = Long.MAX_VALUE;
            }
            dMin += (Math.min(nextSpeedChangeTimeUs, j) - j2) / speedProvider.getSpeed(j2);
            j2 = nextSpeedChangeTimeUs;
        }
        return Math.round(dMin);
    }
}
