package androidx.camera.extensions.internal.compat.quirk;

import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeviceQuirksLoader {
    static List loadQuirks(QuirkSettings quirkSettings) {
        ArrayList arrayList = new ArrayList();
        if (quirkSettings.shouldEnableQuirk(ExtensionDisabledQuirk.class, ExtensionDisabledQuirk.load())) {
            arrayList.add(new ExtensionDisabledQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(CrashWhenOnDisableTooSoon.class, CrashWhenOnDisableTooSoon.load())) {
            arrayList.add(new CrashWhenOnDisableTooSoon());
        }
        if (quirkSettings.shouldEnableQuirk(GetAvailableKeysNeedsOnInit.class, GetAvailableKeysNeedsOnInit.load())) {
            arrayList.add(new GetAvailableKeysNeedsOnInit());
        }
        if (quirkSettings.shouldEnableQuirk(CaptureOutputSurfaceOccupiedQuirk.class, CaptureOutputSurfaceOccupiedQuirk.load())) {
            arrayList.add(new CaptureOutputSurfaceOccupiedQuirk());
        }
        return arrayList;
    }
}
