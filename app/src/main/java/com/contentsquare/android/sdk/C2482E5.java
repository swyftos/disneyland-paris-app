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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2482E5 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Application f1553a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final ViewTreeObserverOnPreDrawListenerC2904v3 f1554b;

    public C2482E5(@NotNull Application application, @NotNull ViewTreeObserverOnPreDrawListenerC2904v3 onDrawObserver) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(onDrawObserver, "onDrawObserver");
        this.f1553a = application;
        this.f1554b = onDrawObserver;
    }

    /* JADX INFO: renamed from: a */
    public final void m911a() {
        this.f1553a.registerActivityLifecycleCallbacks(this);
    }

    /* JADX INFO: renamed from: b */
    public final void m912b() {
        this.f1553a.unregisterActivityLifecycleCallbacks(this);
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
        ViewTreeObserverOnPreDrawListenerC2904v3 viewTreeObserverOnPreDrawListenerC2904v3 = this.f1554b;
        ViewTreeObserver viewTreeObserverM1215a = viewTreeObserverOnPreDrawListenerC2904v3.m1215a();
        if (viewTreeObserverM1215a != null) {
            viewTreeObserverM1215a.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC2904v3);
            viewTreeObserverOnPreDrawListenerC2904v3.f3168a.m827d("Listener to onDraw removed.");
        }
        FlutterInterface.setOnFlutterEventListener(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewTreeObserverOnPreDrawListenerC2904v3 viewTreeObserverOnPreDrawListenerC2904v3 = this.f1554b;
        viewTreeObserverOnPreDrawListenerC2904v3.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewTreeObserver viewTreeObserverM1215a = viewTreeObserverOnPreDrawListenerC2904v3.m1215a();
        if (viewTreeObserverM1215a != null) {
            viewTreeObserverM1215a.removeOnPreDrawListener(viewTreeObserverOnPreDrawListenerC2904v3);
            viewTreeObserverOnPreDrawListenerC2904v3.f3168a.m827d("Listener to onDraw removed.");
        }
        FlutterInterface.setOnFlutterEventListener(null);
        viewTreeObserverOnPreDrawListenerC2904v3.f3172e = new WeakReference<>(activity.getWindow());
        ViewTreeObserver viewTreeObserverM1215a2 = viewTreeObserverOnPreDrawListenerC2904v3.m1215a();
        if (viewTreeObserverM1215a2 != null) {
            viewTreeObserverM1215a2.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC2904v3);
            viewTreeObserverOnPreDrawListenerC2904v3.f3168a.m827d("Listen to draws.");
        }
        FlutterInterface.setOnFlutterEventListener(viewTreeObserverOnPreDrawListenerC2904v3);
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
