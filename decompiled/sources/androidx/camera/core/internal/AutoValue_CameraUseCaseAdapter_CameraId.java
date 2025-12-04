package androidx.camera.core.internal;

import androidx.camera.core.impl.Identifier;
import androidx.camera.core.internal.CameraUseCaseAdapter;

/* loaded from: classes.dex */
final class AutoValue_CameraUseCaseAdapter_CameraId extends CameraUseCaseAdapter.CameraId {
    private final Identifier cameraConfigId;
    private final String cameraIdString;

    AutoValue_CameraUseCaseAdapter_CameraId(String str, Identifier identifier) {
        if (str == null) {
            throw new NullPointerException("Null cameraIdString");
        }
        this.cameraIdString = str;
        if (identifier == null) {
            throw new NullPointerException("Null cameraConfigId");
        }
        this.cameraConfigId = identifier;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.CameraId
    public String getCameraIdString() {
        return this.cameraIdString;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.CameraId
    public Identifier getCameraConfigId() {
        return this.cameraConfigId;
    }

    public String toString() {
        return "CameraId{cameraIdString=" + this.cameraIdString + ", cameraConfigId=" + this.cameraConfigId + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraUseCaseAdapter.CameraId)) {
            return false;
        }
        CameraUseCaseAdapter.CameraId cameraId = (CameraUseCaseAdapter.CameraId) obj;
        return this.cameraIdString.equals(cameraId.getCameraIdString()) && this.cameraConfigId.equals(cameraId.getCameraConfigId());
    }

    public int hashCode() {
        return this.cameraConfigId.hashCode() ^ ((this.cameraIdString.hashCode() ^ 1000003) * 1000003);
    }
}
