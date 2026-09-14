package com.contentsquare.android.sdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Predicate;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2751g0 {

    /* JADX INFO: renamed from: e */
    @Nullable
    public static C2751g0 f2653e;

    /* JADX INFO: renamed from: a */
    @NonNull
    public final C2733e2 f2654a;

    /* JADX INFO: renamed from: b */
    @Nullable
    @VisibleForTesting
    public String f2655b;

    /* JADX INFO: renamed from: c */
    @Nullable
    @VisibleForTesting
    public C2784j3 f2656c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final Logger f2657d;

    public C2751g0() {
        C2494F7 touchTargetDetector = new C2494F7(C2598Q1.f1993f);
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        C2733e2 c2733e2 = new C2733e2(touchTargetDetector, 62);
        this.f2657d = new Logger("BridgeEventProcessor");
        this.f2654a = c2733e2;
    }

    /* JADX INFO: renamed from: a */
    public final void m1138a(@NonNull Activity activity, @NonNull final String str) {
        this.f2657d.m827d("findView: " + str);
        this.f2656c = null;
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        Predicate<View> viewFilter = C2598Q1.f1993f;
        C2539K2.a processor = new C2539K2.a() { // from class: com.contentsquare.android.sdk.g0$$ExternalSyntheticLambda0
            @Override // com.contentsquare.android.sdk.C2539K2.a
            /* JADX INFO: renamed from: a */
            public final void mo913a(View view) {
                this.f$0.m1139a(str, view);
            }
        };
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(viewFilter, "viewFilter");
        new C2539K2(processor, viewFilter).m964a(viewGroup);
    }

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ void m1139a(String str, View view) {
        if (view.getClass().getName().contains(str)) {
            this.f2656c = new C2784j3(view);
        }
    }
}
