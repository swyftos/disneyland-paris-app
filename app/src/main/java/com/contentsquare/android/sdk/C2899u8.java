package com.contentsquare.android.sdk;

import android.graphics.Point;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.u8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2899u8 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.u8$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final WeakReference<View> f3160a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final Point f3161b;

        public a(@NotNull WeakReference<View> scrollViewRef, @NotNull Point scrollState) {
            Intrinsics.checkNotNullParameter(scrollViewRef, "scrollViewRef");
            Intrinsics.checkNotNullParameter(scrollState, "scrollState");
            this.f3160a = scrollViewRef;
            this.f3161b = scrollState;
        }
    }
}
