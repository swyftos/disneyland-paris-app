package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.contentsquare.android.core.utils.ExtensionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.U6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2642U6 implements InterfaceC2540K3 {
    @Override // com.contentsquare.android.sdk.InterfaceC2540K3
    /* JADX INFO: renamed from: a */
    public final boolean mo955a(@NotNull View thisView, @NotNull ViewGroup withThisParent) {
        Intrinsics.checkNotNullParameter(thisView, "thisView");
        Intrinsics.checkNotNullParameter(withThisParent, "withThisParent");
        return (thisView instanceof ImageView) && (ExtensionsKt.isDerivedInstanceOf(withThisParent, "SwipeRefreshLayout") || ExtensionsKt.isDerivedInstanceOf(withThisParent, "SwipeToRefreshLayout"));
    }
}
