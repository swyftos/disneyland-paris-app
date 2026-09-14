package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.t */
/* JADX INFO: loaded from: classes2.dex */
public final class C2880t implements InterfaceC2540K3 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final ComposeInterface f3106a;

    public C2880t(@Nullable ComposeInterface composeInterface) {
        this.f3106a = composeInterface;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2540K3
    /* JADX INFO: renamed from: a */
    public final boolean mo955a(@NotNull View thisView, @NotNull ViewGroup withThisParent) {
        Intrinsics.checkNotNullParameter(thisView, "thisView");
        Intrinsics.checkNotNullParameter(withThisParent, "withThisParent");
        ComposeInterface composeInterface = this.f3106a;
        if (composeInterface != null) {
            return composeInterface.isComposeRootView(withThisParent);
        }
        return false;
    }
}
