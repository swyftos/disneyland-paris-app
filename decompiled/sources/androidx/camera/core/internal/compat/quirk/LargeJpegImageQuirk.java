package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class LargeJpegImageQuirk implements Quirk {
    private static final Set SAMSUNG_DEVICE_MODELS = new HashSet(Arrays.asList("SM-A520F", "SM-A520L", "SM-A520K", "SM-A520S", "SM-A520X", "SM-A520W", "SM-A525F", "SM-A525M", "SM-A705F", "SM-A705FN", "SM-A705GM", "SM-A705MN", "SM-A7050", "SM-A705W", "SM-A705YN", "SM-A705U", "SM-A715F", "SM-A715F/DS", "SM-A715F/DSM", "SM-A715F/DSN", "SM-A715W", "SM-A715X", "SM-A725F", "SM-A725M", "SM-M515F", "SM-M515F/DSN", "SM-G930T", "SM-G930V", "SM-S901B", "SM-S901B/DS", "SM-S906B"));
    private static final Set VIVO_DEVICE_MODELS = new HashSet(Arrays.asList("V2244A", "V2045", "V2046"));

    static boolean load() {
        return isSamsungDevice() || isVivoProblematicDevice();
    }

    private static boolean isSamsungProblematicDevice() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && SAMSUNG_DEVICE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    private static boolean isSamsungDevice() {
        return "Samsung".equalsIgnoreCase(Build.BRAND);
    }

    private static boolean isVivoProblematicDevice() {
        return "Vivo".equalsIgnoreCase(Build.BRAND) && VIVO_DEVICE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    public boolean shouldCheckInvalidJpegData(@NonNull byte[] bArr) {
        return isSamsungProblematicDevice() || isVivoProblematicDevice() || bArr.length > 10000000;
    }
}
