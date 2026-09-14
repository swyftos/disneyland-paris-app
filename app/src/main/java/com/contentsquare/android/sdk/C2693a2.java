package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.MotionEvent;
import com.contentsquare.android.core.utils.SystemInstantiable;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.a2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2693a2 implements InterfaceC2612R6, InterfaceC2914w3, Application.ActivityLifecycleCallbacks, InterfaceC2934y3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Application f2365a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2841p0 f2366b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2508H1 f2367c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final C2723d2 f2368d;

    public C2693a2(Application application, C2841p0 captureTouchEvent, C2508H1 eventsProvidersManager) {
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        C2723d2 gestureProcessor = new C2723d2(application, systemInstantiable);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(captureTouchEvent, "captureTouchEvent");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(gestureProcessor, "gestureProcessor");
        this.f2365a = application;
        this.f2366b = captureTouchEvent;
        this.f2367c = eventsProvidersManager;
        this.f2368d = gestureProcessor;
        application.registerActivityLifecycleCallbacks(this);
        captureTouchEvent.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        captureTouchEvent.f2995c.add(new WeakReference<>(this));
        gestureProcessor.f2494d = this;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2914w3
    /* JADX INFO: renamed from: a */
    public final void mo1084a(@NotNull C2683Z1 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        C2508H1 c2508h1 = this.f2367c;
        synchronized (c2508h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2508h1.f1661a.add(event);
        }
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
        this.f2366b.m1191a(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        C2841p0 c2841p0 = this.f2366b;
        c2841p0.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        c2841p0.f2995c.add(new WeakReference<>(this));
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

    @Override // com.contentsquare.android.sdk.InterfaceC2934y3
    /* JADX INFO: renamed from: a */
    public final synchronized void mo889a(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f2368d.m1114a(event);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2612R6
    /* JADX INFO: renamed from: a */
    public final synchronized void mo888a() {
        this.f2365a.unregisterActivityLifecycleCallbacks(this);
        this.f2366b.m1191a(this);
        this.f2368d.f2494d = null;
    }
}
