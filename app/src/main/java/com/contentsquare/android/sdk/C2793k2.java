package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.util.Predicate;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.k2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nGesturesInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GesturesInterceptor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/gestures/GesturesInterceptor\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,75:1\n26#2:76\n*S KotlinDebug\n*F\n+ 1 GesturesInterceptor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/gestures/GesturesInterceptor\n*L\n30#1:76\n*E\n"})
public final class C2793k2 implements InterfaceC2903v2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Predicate<Activity> f2806a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2733e2 f2807b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2841p0 f2808c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public String f2809d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public String f2810e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public CustomVar[] f2811f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final Logger f2812g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public WeakReference<ViewGroup> f2813h;

    /* JADX INFO: renamed from: i */
    public boolean f2814i;

    public C2793k2(@NotNull C2733e2 gestureProcessor, @NotNull C2841p0 captureTouchEvent) {
        Predicate<Activity> activitiesFilter = C2598Q1.f1991d;
        Intrinsics.checkNotNullParameter(activitiesFilter, "activitiesFilter");
        Intrinsics.checkNotNullParameter(gestureProcessor, "gestureProcessor");
        Intrinsics.checkNotNullParameter(captureTouchEvent, "captureTouchEvent");
        this.f2806a = activitiesFilter;
        this.f2807b = gestureProcessor;
        this.f2808c = captureTouchEvent;
        this.f2811f = new CustomVar[0];
        this.f2812g = new Logger("GesturesInterceptor");
        this.f2813h = new WeakReference<>(null);
    }

    /* JADX INFO: renamed from: a */
    public final void m1168a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "liveActivity");
        this.f2812g.m834w("attaching Glass");
        Window window = activity.getWindow();
        View view = null;
        if ((window != null ? window.getDecorView() : null) instanceof ViewGroup) {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            this.f2813h = new WeakReference<>((ViewGroup) decorView);
            if (this.f2806a.test(activity)) {
                return;
            }
            C2841p0 c2841p0 = this.f2808c;
            c2841p0.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            ViewTreeObserverOnGlobalLayoutListenerC2664X0 viewTreeObserverOnGlobalLayoutListenerC2664X0 = c2841p0.f2994b;
            List<WeakReference<InterfaceC2934y3>> listeners = c2841p0.f2995c;
            viewTreeObserverOnGlobalLayoutListenerC2664X0.getClass();
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            viewTreeObserverOnGlobalLayoutListenerC2664X0.f2232a.getClass();
            Intrinsics.checkNotNullParameter(listeners, "listeners");
            WindowCallbackC2634T8.f2162g = listeners;
            ViewTreeObserverOnGlobalLayoutListenerC2664X0 viewTreeObserverOnGlobalLayoutListenerC2664X1 = c2841p0.f2994b;
            viewTreeObserverOnGlobalLayoutListenerC2664X1.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            Window window2 = activity.getWindow();
            View decorView2 = window2 != null ? window2.getDecorView() : null;
            if (decorView2 instanceof ViewGroup) {
                view = decorView2;
            } else {
                viewTreeObserverOnGlobalLayoutListenerC2664X1.f2233b.m827d("Cannot get decor view from activity.");
            }
            if (view != null && view.getViewTreeObserver().isAlive()) {
                viewTreeObserverOnGlobalLayoutListenerC2664X1.f2234c = new WeakReference<>(activity.getWindow());
                view.getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC2664X1);
                viewTreeObserverOnGlobalLayoutListenerC2664X1.f2233b.m827d("Listen to DecorView global layout.");
            }
            Window window3 = activity.getWindow();
            if (window3 != null) {
                c2841p0.f2993a.getClass();
                WindowCallbackC2634T8.b.m1038a(window3);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1169b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "liveActivity");
        this.f2812g.m834w("detaching Glass");
        C2841p0 c2841p0 = this.f2808c;
        c2841p0.getClass();
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewTreeObserverOnGlobalLayoutListenerC2664X0 viewTreeObserverOnGlobalLayoutListenerC2664X0 = c2841p0.f2994b;
        List<? extends WeakReference<InterfaceC2934y3>> listeners = CollectionsKt.emptyList();
        viewTreeObserverOnGlobalLayoutListenerC2664X0.getClass();
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        viewTreeObserverOnGlobalLayoutListenerC2664X0.f2232a.getClass();
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        WindowCallbackC2634T8.f2162g = listeners;
        c2841p0.f2994b.m1065a(activity);
        Window window = activity.getWindow();
        if (window != null) {
            c2841p0.f2993a.getClass();
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(window, "window");
            Window.Callback callback = window.getCallback();
            if (callback instanceof WindowCallbackC2634T8) {
                window.setCallback(((WindowCallbackC2634T8) callback).f2164b);
            }
        }
        this.f2813h = new WeakReference<>(null);
    }
}
