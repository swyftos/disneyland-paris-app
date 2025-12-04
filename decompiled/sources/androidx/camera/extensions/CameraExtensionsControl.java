package androidx.camera.extensions;

import androidx.annotation.IntRange;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;

/* loaded from: classes.dex */
public interface CameraExtensionsControl {
    default void setExtensionStrength(@IntRange(from = 0, to = WebToNativeBridgeBase.CLOSE_WAIT_DURATION_MILLISECONDS) int i) {
    }
}
