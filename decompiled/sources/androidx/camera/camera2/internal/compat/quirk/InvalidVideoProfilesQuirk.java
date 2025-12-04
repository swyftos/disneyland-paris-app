package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class InvalidVideoProfilesQuirk implements Quirk {
    private static final List AFFECTED_PIXEL_MODELS = Arrays.asList("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");
    private static final List AFFECTED_ONE_PLUS_MODELS = Arrays.asList("cph2417", "cph2451");
    private static final List AFFECTED_OPPO_MODELS = Arrays.asList("cph2437", "cph2525", "pht110");

    static boolean load() {
        return isAffectedSamsungDevices() || isAffectedPixelDevices() || isAffectedXiaomiDevices() || isAffectedOnePlusDevices() || isAffectedOppoDevices();
    }

    private static boolean isAffectedSamsungDevices() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && isTp1aBuild();
    }

    private static boolean isAffectedPixelDevices() {
        return isAffectedPixelModel() && isAffectedPixelBuild();
    }

    private static boolean isAffectedOnePlusDevices() {
        return isAffectedOnePlusModel() && isAPI33();
    }

    private static boolean isAffectedOppoDevices() {
        return isAffectedOppoModel() && isAPI33();
    }

    private static boolean isAffectedXiaomiDevices() {
        String str = Build.BRAND;
        return ("redmi".equalsIgnoreCase(str) || "xiaomi".equalsIgnoreCase(str)) && (isTkq1Build() || isTp1aBuild());
    }

    private static boolean isAffectedPixelModel() {
        return AFFECTED_PIXEL_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedOnePlusModel() {
        return AFFECTED_ONE_PLUS_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedOppoModel() {
        return AFFECTED_OPPO_MODELS.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean isAffectedPixelBuild() {
        return isTp1aBuild() || isTd1aBuild();
    }

    private static boolean isTp1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    private static boolean isTd1aBuild() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean isTkq1Build() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tkq1");
    }

    private static boolean isAPI33() {
        return Build.VERSION.SDK_INT == 33;
    }
}
