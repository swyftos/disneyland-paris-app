package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.core.impl.Quirks;

/* loaded from: classes.dex */
public class CloseCameraBeforeCreateNewSession {
    public static boolean shouldCloseCamera(@NonNull Quirks quirks) {
        return quirks.contains(LegacyCameraOutputConfigNullPointerQuirk.class) || quirks.contains(CaptureSessionStuckWhenCreatingBeforeClosingCameraQuirk.class);
    }
}
