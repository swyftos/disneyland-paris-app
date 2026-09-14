package androidx.camera.extensions.internal.sessionprocessor;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface Camera2OutputConfig {
    int getId();

    String getPhysicalCameraId();

    int getSurfaceGroupId();

    List getSurfaceSharingOutputConfigs();
}
