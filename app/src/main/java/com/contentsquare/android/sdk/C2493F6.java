package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2493F6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1618a;

    /* JADX INFO: renamed from: b */
    public final int f1619b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1620c;

    public C2493F6(String appVersion) {
        Logger logger = new Logger("SrmPayloadSplitter");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1618a = appVersion;
        this.f1619b = 8388608;
        this.f1620c = logger;
    }
}
