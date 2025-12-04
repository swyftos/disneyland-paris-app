package com.contentsquare.android.sdk;

import android.view.View;
import androidx.core.util.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class F7 {

    @NotNull
    public final Predicate<View> a;

    public F7(@NotNull Predicate<View> viewFilter) {
        Intrinsics.checkNotNullParameter(viewFilter, "viewFilter");
        this.a = viewFilter;
    }
}
