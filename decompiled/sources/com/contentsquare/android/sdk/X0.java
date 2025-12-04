package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.T8;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class X0 implements ViewTreeObserver.OnGlobalLayoutListener {

    @NotNull
    public final T8.b a;

    @NotNull
    public final Logger b;

    @NotNull
    public WeakReference<Window> c;

    public X0(T8.b windowCallbackWrapper) {
        Logger logger = new Logger("DecorViewTreeObserver");
        Intrinsics.checkNotNullParameter(windowCallbackWrapper, "windowCallbackWrapper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = windowCallbackWrapper;
        this.b = logger;
        this.c = new WeakReference<>(null);
    }

    public final void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        View view = null;
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView instanceof ViewGroup) {
            view = decorView;
        } else {
            this.b.d("Cannot get decor view from activity.");
        }
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
                this.b.d("Listener to DecorView global layout removed.");
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Window window = this.c.get();
        if (window != null) {
            T8.b bVar = this.a;
            T8.c cVar = T8.d;
            bVar.getClass();
            T8.b.a(window);
        }
    }
}
