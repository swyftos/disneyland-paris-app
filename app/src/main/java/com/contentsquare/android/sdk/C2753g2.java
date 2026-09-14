package com.contentsquare.android.sdk;

import android.os.IBinder;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2753g2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f2659a = new Logger("GestureStorage");

    /* JADX INFO: renamed from: b */
    @Nullable
    public a f2660b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.g2$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f2661a;

        /* JADX INFO: renamed from: b */
        public final int f2662b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final WeakReference<IBinder> f2663c;

        public a(@NotNull IBinder windowToken, int i, int i2) {
            Intrinsics.checkNotNullParameter(windowToken, "windowToken");
            this.f2661a = i;
            this.f2662b = i2;
            this.f2663c = new WeakReference<>(windowToken);
        }
    }
}
