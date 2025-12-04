package com.contentsquare.android.sdk;

import android.graphics.Point;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.u8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0828u8 {

    /* renamed from: com.contentsquare.android.sdk.u8$a */
    public static final class a {

        @NotNull
        public final WeakReference<View> a;

        @NotNull
        public final Point b;

        public a(@NotNull WeakReference<View> scrollViewRef, @NotNull Point scrollState) {
            Intrinsics.checkNotNullParameter(scrollViewRef, "scrollViewRef");
            Intrinsics.checkNotNullParameter(scrollState, "scrollState");
            this.a = scrollViewRef;
            this.b = scrollState;
        }
    }
}
