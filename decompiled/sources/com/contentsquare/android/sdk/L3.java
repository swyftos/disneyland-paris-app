package com.contentsquare.android.sdk;

import android.app.Application;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class L3 {

    @NotNull
    public final Application a;

    @NotNull
    public final v8 b;

    @NotNull
    public final Logger c;

    public L3(@NotNull Application application, @NotNull v8 viewUtil) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(viewUtil, "viewUtil");
        this.a = application;
        this.b = viewUtil;
        this.c = new Logger("PathGenerator");
    }
}
