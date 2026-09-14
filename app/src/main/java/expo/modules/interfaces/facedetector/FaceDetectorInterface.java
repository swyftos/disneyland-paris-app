package expo.modules.interfaces.facedetector;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface FaceDetectorInterface {
    void detectFaces(Uri uri, FacesDetectionCompleted facesDetectionCompleted, FaceDetectionError faceDetectionError) throws IOException;

    void detectFaces(byte[] bArr, int i, int i2, int i3, boolean z, double d, double d2, FacesDetectionCompleted facesDetectionCompleted, FaceDetectionError faceDetectionError, FaceDetectionSkipped faceDetectionSkipped);

    void release();

    void setSettings(Map<String, Object> map);
}
