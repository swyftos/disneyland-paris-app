package com.swmansion.rnscreens.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/utils/EdgeToEdgePackageDetector;", "", "<init>", "()V", "ENABLED", "", "getENABLED", "()Z", "react-native-screens_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EdgeToEdgePackageDetector {
    private static final boolean ENABLED;

    @NotNull
    public static final EdgeToEdgePackageDetector INSTANCE = new EdgeToEdgePackageDetector();

    private EdgeToEdgePackageDetector() {
    }

    public final boolean getENABLED() {
        return ENABLED;
    }

    static {
        boolean z;
        try {
            Class.forName("com.zoontek.rnedgetoedge.EdgeToEdgePackage");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        ENABLED = z;
    }
}
