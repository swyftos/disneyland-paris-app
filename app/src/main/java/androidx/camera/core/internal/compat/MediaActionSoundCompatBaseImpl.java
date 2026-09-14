package androidx.camera.core.internal.compat;

import android.hardware.Camera;

/* JADX INFO: loaded from: classes.dex */
abstract class MediaActionSoundCompatBaseImpl {
    static boolean mustPlayShutterSound() {
        if (Camera.getNumberOfCameras() < 1) {
            return false;
        }
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
            return !cameraInfo.canDisableShutterSound;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
