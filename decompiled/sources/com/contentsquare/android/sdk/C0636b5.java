package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nScreenView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenView.kt\ncom/contentsquare/android/analytics/internal/model/data/ScreenView\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,13:1\n26#2:14\n*S KotlinDebug\n*F\n+ 1 ScreenView.kt\ncom/contentsquare/android/analytics/internal/model/data/ScreenView\n*L\n10#1:14\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.b5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0636b5 {

    @NotNull
    public final String a;

    @NotNull
    public final CustomVar[] b;
    public final boolean c;

    @Nullable
    public final Long d;

    public C0636b5(String screenName, CustomVar[] customVars, boolean z, Long l, int i) {
        customVars = (i & 2) != 0 ? new CustomVar[0] : customVars;
        z = (i & 4) != 0 ? false : z;
        l = (i & 8) != 0 ? null : l;
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(customVars, "customVars");
        this.a = screenName;
        this.b = customVars;
        this.c = z;
        this.d = l;
    }
}
