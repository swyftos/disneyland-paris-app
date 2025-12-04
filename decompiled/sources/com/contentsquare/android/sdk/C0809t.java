package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: com.contentsquare.android.sdk.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0809t implements K3 {

    @Nullable
    public final ComposeInterface a;

    public C0809t(@Nullable ComposeInterface composeInterface) {
        this.a = composeInterface;
    }

    @Override // com.contentsquare.android.sdk.K3
    public final boolean a(@NotNull View thisView, @NotNull ViewGroup withThisParent) {
        Intrinsics.checkNotNullParameter(thisView, "thisView");
        Intrinsics.checkNotNullParameter(withThisParent, "withThisParent");
        ComposeInterface composeInterface = this.a;
        if (composeInterface != null) {
            return composeInterface.isComposeRootView(withThisParent);
        }
        return false;
    }
}
