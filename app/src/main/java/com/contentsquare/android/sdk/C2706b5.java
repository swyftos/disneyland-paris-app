package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b5 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nScreenView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenView.kt\ncom/contentsquare/android/analytics/internal/model/data/ScreenView\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,13:1\n26#2:14\n*S KotlinDebug\n*F\n+ 1 ScreenView.kt\ncom/contentsquare/android/analytics/internal/model/data/ScreenView\n*L\n10#1:14\n*E\n"})
public final class C2706b5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f2411a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final CustomVar[] f2412b;

    /* JADX INFO: renamed from: c */
    public final boolean f2413c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final Long f2414d;

    public C2706b5(String screenName, CustomVar[] customVars, boolean z, Long l, int i) {
        customVars = (i & 2) != 0 ? new CustomVar[0] : customVars;
        z = (i & 4) != 0 ? false : z;
        l = (i & 8) != 0 ? null : l;
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(customVars, "customVars");
        this.f2411a = screenName;
        this.f2412b = customVars;
        this.f2413c = z;
        this.f2414d = l;
    }
}
