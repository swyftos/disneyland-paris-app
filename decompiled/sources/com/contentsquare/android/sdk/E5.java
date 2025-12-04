package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import com.contentsquare.android.api.bridge.flutter.FlutterInterface;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class E5 implements Application.ActivityLifecycleCallbacks {

    @NotNull
    public final Application a;

    @NotNull
    public final ViewTreeObserverOnPreDrawListenerC0833v3 b;

    public E5(@NotNull Application application, @NotNull ViewTreeObserverOnPreDrawListenerC0833v3 onDrawObserver) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(onDrawObserver, "onDrawObserver");
        this.a = application;
        this.b = onDrawObserver;
    }

    public final void a() {
        this.a.registerActivityLifecycleCallbacks(this);
    }

    public final void b() {
        this.a.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3 = this.b;
        ViewTreeObserver viewTreeObserverA = viewTreeObserverOnPreDrawListenerC0833v3.a();
        if (viewTreeObserverA != null) {
            viewTreeObserverA.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0833v3);
            viewTreeObserverOnPreDrawListenerC0833v3.a.d("Listener to onDraw removed.");
        }
        FlutterInterface.setOnFlutterEventListener(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewTreeObserverOnPreDrawListenerC0833v3 viewTreeObserverOnPreDrawListenerC0833v3 = this.b;
        viewTreeObserverOnPreDrawListenerC0833v3.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewTreeObserver viewTreeObserverA = viewTreeObserverOnPreDrawListenerC0833v3.a();
        if (viewTreeObserverA != null) {
            viewTreeObserverA.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0833v3);
            viewTreeObserverOnPreDrawListenerC0833v3.a.d("Listener to onDraw removed.");
        }
        FlutterInterface.setOnFlutterEventListener(null);
        viewTreeObserverOnPreDrawListenerC0833v3.e = new WeakReference<>(activity.getWindow());
        ViewTreeObserver viewTreeObserverA2 = viewTreeObserverOnPreDrawListenerC0833v3.a();
        if (viewTreeObserverA2 != null) {
            viewTreeObserverA2.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0833v3);
            viewTreeObserverOnPreDrawListenerC0833v3.a.d("Listen to draws.");
        }
        FlutterInterface.setOnFlutterEventListener(viewTreeObserverOnPreDrawListenerC0833v3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
