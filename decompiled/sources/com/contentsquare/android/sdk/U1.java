package com.contentsquare.android.sdk;

import com.contentsquare.android.api.bridge.xpf.XpfMasker;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class U1 {

    @NotNull
    public final D5 a;

    @Nullable
    public final C0847x b;

    @NotNull
    public final XpfMasker c;

    @NotNull
    public final Logger d;

    public U1(D5 sessionReplayConfiguration, C0847x c0847x) {
        XpfMasker xpfMasker = XpfMasker.INSTANCE;
        Intrinsics.checkNotNullParameter(sessionReplayConfiguration, "sessionReplayConfiguration");
        Intrinsics.checkNotNullParameter(xpfMasker, "xpfMasker");
        this.a = sessionReplayConfiguration;
        this.b = c0847x;
        this.c = xpfMasker;
        this.d = new Logger("ForceMaskingResolver");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(@org.jetbrains.annotations.NotNull android.view.View r11) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.U1.a(android.view.View):int");
    }
}
