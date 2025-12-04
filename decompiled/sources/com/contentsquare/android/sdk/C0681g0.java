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
import com.contentsquare.android.sdk.K2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.contentsquare.android.sdk.g0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0681g0 {

    @Nullable
    public static C0681g0 e;

    @NonNull
    public final C0663e2 a;

    @Nullable
    @VisibleForTesting
    public String b;

    @Nullable
    @VisibleForTesting
    public C0714j3 c;

    @NonNull
    public final Logger d;

    public C0681g0() {
        F7 touchTargetDetector = new F7(Q1.f);
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        C0663e2 c0663e2 = new C0663e2(touchTargetDetector, 62);
        this.d = new Logger("BridgeEventProcessor");
        this.a = c0663e2;
    }

    public final void a(@NonNull Activity activity, @NonNull final String str) {
        this.d.d("findView: " + str);
        this.c = null;
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        Predicate<View> viewFilter = Q1.f;
        K2.a processor = new K2.a() { // from class: com.contentsquare.android.sdk.g0$$ExternalSyntheticLambda0
            @Override // com.contentsquare.android.sdk.K2.a
            public final void a(View view) {
                this.f$0.a(str, view);
            }
        };
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(viewFilter, "viewFilter");
        new K2(processor, viewFilter).a(viewGroup);
    }

    public final /* synthetic */ void a(String str, View view) {
        if (view.getClass().getName().contains(str)) {
            this.c = new C0714j3(view);
        }
    }
}
