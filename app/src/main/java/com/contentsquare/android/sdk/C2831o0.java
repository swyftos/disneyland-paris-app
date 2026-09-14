package com.contentsquare.android.sdk;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o0 */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 23)
public final class C2831o0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f2933a = new Logger("CanDrawOverlaysWorkAround");

    /* JADX INFO: renamed from: b */
    @NotNull
    public final a f2934b = new a();

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.o0$a */
    public static final class a {
        /* JADX INFO: renamed from: a */
        public static boolean m1184a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Settings.canDrawOverlays(context);
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1183a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2934b.getClass();
        return a.m1184a(context);
    }
}
