package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class F6 {

    @NotNull
    public final String a;
    public final int b;

    @NotNull
    public final Logger c;

    public F6(String appVersion) {
        Logger logger = new Logger("SrmPayloadSplitter");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = appVersion;
        this.b = 8388608;
        this.c = logger;
    }
}
