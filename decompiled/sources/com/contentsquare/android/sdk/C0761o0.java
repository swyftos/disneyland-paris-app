package com.contentsquare.android.sdk;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.RequiresApi;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(api = 23)
/* renamed from: com.contentsquare.android.sdk.o0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0761o0 {

    @NotNull
    public final Logger a = new Logger("CanDrawOverlaysWorkAround");

    @NotNull
    public final a b = new a();

    /* renamed from: com.contentsquare.android.sdk.o0$a */
    public static final class a {
        public static boolean a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return Settings.canDrawOverlays(context);
        }
    }

    public final boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.getClass();
        return a.a(context);
    }
}
