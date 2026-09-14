package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

/* JADX INFO: loaded from: classes.dex */
public class NegativeLatLongSavesIncorrectlyQuirk implements Quirk {
    static boolean load() {
        return Build.VERSION.SDK_INT < 34;
    }
}
