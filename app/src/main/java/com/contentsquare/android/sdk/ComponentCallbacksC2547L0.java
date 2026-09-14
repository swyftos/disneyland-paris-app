package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.L0 */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentCallbacksC2547L0 implements ComponentCallbacks {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2926x5 f1802a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Application f1803b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final DisplayMetrics f1804c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final ArrayList f1805d;

    /* JADX INFO: renamed from: e */
    public int f1806e;

    /* JADX INFO: renamed from: f */
    public int f1807f;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.L0$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo976a(int i, int i2);
    }

    public ComponentCallbacksC2547L0(@NotNull C2926x5 mSdkManager, @NotNull Application application, @NotNull DisplayMetrics metrics) {
        Intrinsics.checkNotNullParameter(mSdkManager, "mSdkManager");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.f1802a = mSdkManager;
        this.f1803b = application;
        this.f1804c = metrics;
        this.f1805d = new ArrayList();
        Object systemService = application.getSystemService("window");
        Pair pairM1842to = null;
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
            pairM1842to = TuplesKt.m1842to(Integer.valueOf(metrics.widthPixels), Integer.valueOf(metrics.heightPixels));
        }
        if (pairM1842to != null) {
            this.f1806e = ((Number) pairM1842to.getFirst()).intValue();
            this.f1807f = ((Number) pairM1842to.getSecond()).intValue();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.EXPOSURE_METRICS)) {
            Object systemService = this.f1803b.getSystemService("window");
            Pair pairM1842to = null;
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(this.f1804c);
                DisplayMetrics displayMetrics = this.f1804c;
                pairM1842to = TuplesKt.m1842to(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
            }
            if (pairM1842to != null) {
                int iIntValue = ((Number) pairM1842to.getFirst()).intValue();
                int iIntValue2 = ((Number) pairM1842to.getSecond()).intValue();
                if (this.f1806e == iIntValue && this.f1807f == iIntValue2) {
                    return;
                }
                this.f1806e = iIntValue;
                this.f1807f = iIntValue2;
                for (a aVar : this.f1805d) {
                    int i = newConfig.orientation;
                    aVar.mo976a(iIntValue, iIntValue2);
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f1802a.m1233a(false);
    }
}
