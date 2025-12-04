package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class L0 implements ComponentCallbacks {

    @NotNull
    public final C0853x5 a;

    @NotNull
    public final Application b;

    @NotNull
    public final DisplayMetrics c;

    @NotNull
    public final ArrayList d;
    public int e;
    public int f;

    public interface a {
        void a(int i, int i2);
    }

    public L0(@NotNull C0853x5 mSdkManager, @NotNull Application application, @NotNull DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(mSdkManager, "mSdkManager");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.a = mSdkManager;
        this.b = application;
        this.c = metrics;
        this.d = new ArrayList();
        Object systemService = application.getSystemService("window");
        Pair pair = null;
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
            pair = TuplesKt.to(Integer.valueOf(metrics.widthPixels), Integer.valueOf(metrics.heightPixels));
        }
        if (pair != null) {
            this.e = ((Number) pair.getFirst()).intValue();
            this.f = ((Number) pair.getSecond()).intValue();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.EXPOSURE_METRICS)) {
            Object systemService = this.b.getSystemService("window");
            Pair pair = null;
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(this.c);
                DisplayMetrics displayMetrics = this.c;
                pair = TuplesKt.to(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
            }
            if (pair != null) {
                int iIntValue = ((Number) pair.getFirst()).intValue();
                int iIntValue2 = ((Number) pair.getSecond()).intValue();
                if (this.e == iIntValue && this.f == iIntValue2) {
                    return;
                }
                this.e = iIntValue;
                this.f = iIntValue2;
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    int i = newConfig.orientation;
                    aVar.a(iIntValue, iIntValue2);
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.a.a(false);
    }
}
