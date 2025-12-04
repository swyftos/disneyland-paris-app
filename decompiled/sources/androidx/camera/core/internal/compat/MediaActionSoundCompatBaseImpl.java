package androidx.camera.core.internal.compat;

import android.hardware.Camera;

/* loaded from: classes.dex */
abstract class MediaActionSoundCompatBaseImpl {
    static boolean mustPlayShutterSound() {
        if (Camera.getNumberOfCameras() < 1) {
            return false;
        }
        try {
            Camera.getCameraInfo(0, new Camera.CameraInfo());
            return !r0.canDisableShutterSound;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
