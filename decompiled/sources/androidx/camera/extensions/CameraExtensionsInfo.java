package androidx.camera.extensions;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

/* loaded from: classes.dex */
public interface CameraExtensionsInfo {
    @Nullable
    default LiveData<Integer> getCurrentExtensionMode() {
        return null;
    }

    @Nullable
    default LiveData<Integer> getExtensionStrength() {
        return null;
    }

    default boolean isCurrentExtensionModeAvailable() {
        return false;
    }

    default boolean isExtensionStrengthAvailable() {
        return false;
    }
}
