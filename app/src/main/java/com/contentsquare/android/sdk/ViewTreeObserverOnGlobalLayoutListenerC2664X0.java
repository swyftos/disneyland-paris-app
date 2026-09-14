package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.contentsquare.android.core.features.logging.Logger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.X0 */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC2664X0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final WindowCallbackC2634T8.b f2232a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f2233b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public WeakReference<Window> f2234c;

    public ViewTreeObserverOnGlobalLayoutListenerC2664X0(WindowCallbackC2634T8.b windowCallbackWrapper) {
        Logger logger = new Logger("DecorViewTreeObserver");
        Intrinsics.checkNotNullParameter(windowCallbackWrapper, "windowCallbackWrapper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f2232a = windowCallbackWrapper;
        this.f2233b = logger;
        this.f2234c = new WeakReference<>(null);
    }

    /* JADX INFO: renamed from: a */
    public final void m1065a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        View view = null;
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView instanceof ViewGroup) {
            view = decorView;
        } else {
            this.f2233b.m827d("Cannot get decor view from activity.");
        }
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
                this.f2233b.m827d("Listener to DecorView global layout removed.");
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Window window = this.f2234c.get();
        if (window != null) {
            WindowCallbackC2634T8.b bVar = this.f2232a;
            WindowCallbackC2634T8.c cVar = WindowCallbackC2634T8.f2159d;
            bVar.getClass();
            WindowCallbackC2634T8.b.m1038a(window);
        }
    }
}
