package com.contentsquare.android.sdk;

import android.os.IBinder;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.g2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0683g2 {

    @NotNull
    public final Logger a = new Logger("GestureStorage");

    @Nullable
    public a b;

    /* renamed from: com.contentsquare.android.sdk.g2$a */
    public static final class a {
        public final int a;
        public final int b;

        @NotNull
        public final WeakReference<IBinder> c;

        public a(@NotNull IBinder windowToken, int i, int i2) {
            Intrinsics.checkNotNullParameter(windowToken, "windowToken");
            this.a = i;
            this.b = i2;
            this.c = new WeakReference<>(windowToken);
        }
    }
}
