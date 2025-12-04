package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public interface CameraMotionListener {
    void onCameraMotion(long j, float[] fArr);

    void onCameraMotionReset();
}
