package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.util.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2494F7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Predicate<View> f1621a;

    public C2494F7(@NotNull Predicate<View> viewFilter) {
        Intrinsics.checkNotNullParameter(viewFilter, "viewFilter");
        this.f1621a = viewFilter;
    }
}
