package com.contentsquare.android.sdk;

import android.app.Application;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.L3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2550L3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Application f1824a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2909v8 f1825b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1826c;

    public C2550L3(@NotNull Application application, @NotNull C2909v8 viewUtil) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(viewUtil, "viewUtil");
        this.f1824a = application;
        this.f1825b = viewUtil;
        this.f1826c = new Logger("PathGenerator");
    }
}
