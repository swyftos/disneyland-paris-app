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

/* renamed from: com.contentsquare.android.sdk.a2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0623a2 implements R6, InterfaceC0842w3, Application.ActivityLifecycleCallbacks, InterfaceC0860y3 {

    @NotNull
    public final Application a;

    @NotNull
    public final C0771p0 b;

    @NotNull
    public final H1 c;

    @NotNull
    public final C0653d2 d;

    public C0623a2(Application application, C0771p0 captureTouchEvent, H1 eventsProvidersManager) {
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        C0653d2 gestureProcessor = new C0653d2(application, systemInstantiable);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(captureTouchEvent, "captureTouchEvent");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(gestureProcessor, "gestureProcessor");
        this.a = application;
        this.b = captureTouchEvent;
        this.c = eventsProvidersManager;
        this.d = gestureProcessor;
        application.registerActivityLifecycleCallbacks(this);
        captureTouchEvent.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        captureTouchEvent.c.add(new WeakReference<>(this));
        gestureProcessor.d = this;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0842w3
    public final void a(@NotNull Z1 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        H1 h1 = this.c;
        synchronized (h1) {
            Intrinsics.checkNotNullParameter(event, "event");
            h1.a.add(event);
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
        this.b.a(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        C0771p0 c0771p0 = this.b;
        c0771p0.getClass();
        Intrinsics.checkNotNullParameter(this, "onTouchListener");
        c0771p0.c.add(new WeakReference<>(this));
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

    @Override // com.contentsquare.android.sdk.InterfaceC0860y3
    public final synchronized void a(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.d.a(event);
    }

    @Override // com.contentsquare.android.sdk.R6
    public final synchronized void a() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        this.b.a(this);
        this.d.d = null;
    }
}
