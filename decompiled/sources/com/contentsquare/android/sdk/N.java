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

/* loaded from: classes2.dex */
public final class N implements LifecycleOwner {
    public boolean a;
    public final LifecycleRegistry b;

    public static final class a extends C0712j1 {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            N n = N.this;
            if (n.a) {
                return;
            }
            LifecycleRegistry lifecycleRegistry = n.b;
            if (lifecycleRegistry == null) {
                Intrinsics.throwUninitializedPropertyAccessException("registry");
                lifecycleRegistry = null;
            }
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            N.this.a = true;
        }
    }

    public N(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = new a();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(aVar);
        }
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        Intrinsics.checkNotNullParameter(lifecycleRegistry, "<set-?>");
        this.b = lifecycleRegistry;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public final Lifecycle getLifecycle() {
        LifecycleRegistry lifecycleRegistry = this.b;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        Intrinsics.throwUninitializedPropertyAccessException("registry");
        return null;
    }
}
