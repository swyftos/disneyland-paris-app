package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.N */
/* JADX INFO: loaded from: classes2.dex */
public final class C2566N implements LifecycleOwner {

    /* JADX INFO: renamed from: a */
    public boolean f1876a;

    /* JADX INFO: renamed from: b */
    public final LifecycleRegistry f1877b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.N$a */
    public static final class a extends C2782j1 {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            C2566N c2566n = C2566N.this;
            if (c2566n.f1876a) {
                return;
            }
            LifecycleRegistry lifecycleRegistry = c2566n.f1877b;
            if (lifecycleRegistry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("registry");
                lifecycleRegistry = null;
            }
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            C2566N.this.f1876a = true;
        }
    }

    public C2566N(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(aVar);
        }
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<set-?>");
        this.f1877b = lifecycleRegistry;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public final Lifecycle getLifecycle() {
        LifecycleRegistry lifecycleRegistry = this.f1877b;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        Intrinsics.throwUninitializedPropertyAccessException("registry");
        return null;
    }
}
