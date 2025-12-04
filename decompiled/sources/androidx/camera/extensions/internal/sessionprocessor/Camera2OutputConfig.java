package androidx.camera.extensions.internal.sessionprocessor;

import java.util.List;

/* loaded from: classes.dex */
interface Camera2OutputConfig {
    int getId();

    String getPhysicalCameraId();

    int getSurfaceGroupId();

    List getSurfaceSharingOutputConfigs();
}
