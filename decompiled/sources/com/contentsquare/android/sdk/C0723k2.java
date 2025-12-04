package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.util.Predicate;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.T8;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGesturesInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GesturesInterceptor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/gestures/GesturesInterceptor\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,75:1\n26#2:76\n*S KotlinDebug\n*F\n+ 1 GesturesInterceptor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/gestures/GesturesInterceptor\n*L\n30#1:76\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.k2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0723k2 implements InterfaceC0832v2 {

    @NotNull
    public final Predicate<Activity> a;

    @NotNull
    public final C0663e2 b;

    @NotNull
    public final C0771p0 c;

    @Nullable
    public String d;

    @Nullable
    public String e;

    @NotNull
    public CustomVar[] f;

    @NotNull
    public final Logger g;

    @NotNull
    public WeakReference<ViewGroup> h;
    public boolean i;

    public C0723k2(@NotNull C0663e2 gestureProcessor, @NotNull C0771p0 captureTouchEvent) {
        Predicate<Activity> activitiesFilter = Q1.d;
        Intrinsics.checkNotNullParameter(activitiesFilter, "activitiesFilter");
        Intrinsics.checkNotNullParameter(gestureProcessor, "gestureProcessor");
        Intrinsics.checkNotNullParameter(captureTouchEvent, "captureTouchEvent");
        this.a = activitiesFilter;
        this.b = gestureProcessor;
        this.c = captureTouchEvent;
        this.f = new CustomVar[0];
        this.g = new Logger("GesturesInterceptor");
        this.h = new WeakReference<>(null);
    }

    public final void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "liveActivity");
        this.g.w("attaching Glass");
        Window window = activity.getWindow();
        View view = null;
        if ((window != null ? window.getDecorView() : null) instanceof ViewGroup) {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.h = new WeakReference<>((ViewGroup) decorView);
            if (this.a.test(activity)) {
                return;
            }
            C0771p0 c0771p0 = this.c;
            c0771p0.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            X0 x0 = c0771p0.b;
            List<WeakReference<InterfaceC0860y3>> listeners = c0771p0.c;
            x0.getClass();
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            x0.a.getClass();
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            T8.g = listeners;
            X0 x02 = c0771p0.b;
            x02.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            Window window2 = activity.getWindow();
            View decorView2 = window2 != null ? window2.getDecorView() : null;
            if (decorView2 instanceof ViewGroup) {
                view = decorView2;
            } else {
                x02.b.d("Cannot get decor view from activity.");
            }
            if (view != null && view.getViewTreeObserver().isAlive()) {
                x02.c = new WeakReference<>(activity.getWindow());
                view.getViewTreeObserver().addOnGlobalLayoutListener(x02);
                x02.b.d("Listen to DecorView global layout.");
            }
            Window window3 = activity.getWindow();
            if (window3 != null) {
                c0771p0.a.getClass();
                T8.b.a(window3);
            }
        }
    }

    public final void b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "liveActivity");
        this.g.w("detaching Glass");
        C0771p0 c0771p0 = this.c;
        c0771p0.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        X0 x0 = c0771p0.b;
        List<? extends WeakReference<InterfaceC0860y3>> listeners = CollectionsKt.emptyList();
        x0.getClass();
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        x0.a.getClass();
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        T8.g = listeners;
        c0771p0.b.a(activity);
        Window window = activity.getWindow();
        if (window != null) {
            c0771p0.a.getClass();
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(window, "window");
            Window.Callback callback = window.getCallback();
            if (callback instanceof T8) {
                window.setCallback(((T8) callback).b);
            }
        }
        this.h = new WeakReference<>(null);
    }
}
