package com.contentsquare.android.sdk;

import android.view.Window;
import androidx.annotation.MainThread;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.u3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableC0823u3 implements Runnable {

    @NotNull
    private WeakReference<Window> window = new WeakReference<>(null);

    @NotNull
    public final WeakReference<Window> getWindow() {
        return this.window;
    }

    public abstract void onDraw(@NotNull Window window);

    @Override // java.lang.Runnable
    @MainThread
    public void run() {
        Window window = this.window.get();
        if (window != null) {
            onDraw(window);
        }
    }

    public final void setWindow(@NotNull WeakReference<Window> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.window = weakReference;
    }
}
