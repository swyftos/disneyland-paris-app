package com.contentsquare.android.reactnative.workaround;

import androidx.lifecycle.LifecycleOwner;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle;
import com.contentsquare.android.sdk.C0646c5;
import com.contentsquare.android.sdk.C0696h5;
import com.contentsquare.android.sdk.J0;
import com.contentsquare.android.sdk.L2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class a implements ReactNativeProcessLifecycle.c {
    public a(@NotNull ReactNativeProcessLifecycle.a lifecycleProvider, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleProvider, "lifecycleProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        new ReactNativeProcessLifecycle(lifecycleProvider.a, lifecycleOwner, this, new ReactNativeProcessLifecycle.b());
    }

    @Override // com.contentsquare.android.reactnative.workaround.ReactNativeProcessLifecycle.c
    public final void a() {
        C0696h5 c0696h5;
        C0646c5.a aVar;
        L2 legacyComponentsHolder;
        CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
        J0 j0 = (csRuntimeModule == null || (legacyComponentsHolder = csRuntimeModule.getLegacyComponentsHolder()) == null) ? null : legacyComponentsHolder.j;
        if (j0 == null || (aVar = (c0696h5 = j0.h).e) == null) {
            return;
        }
        c0696h5.a.a(aVar);
    }
}
