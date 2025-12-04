package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class U6 implements K3 {
    @Override // com.contentsquare.android.sdk.K3
    public final boolean a(@NotNull View thisView, @NotNull ViewGroup withThisParent) {
        Intrinsics.checkNotNullParameter(thisView, "thisView");
        Intrinsics.checkNotNullParameter(withThisParent, "withThisParent");
        return (thisView instanceof ImageView) && (ExtensionsKt.isDerivedInstanceOf(withThisParent, "SwipeRefreshLayout") || ExtensionsKt.isDerivedInstanceOf(withThisParent, "SwipeToRefreshLayout"));
    }
}
