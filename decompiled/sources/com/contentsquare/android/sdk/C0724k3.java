package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.Intent;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayService;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.k3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0724k3 {

    @NotNull
    public final Application a;

    @NotNull
    public final com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a b;

    @NotNull
    public final PreferencesStore c;

    @NotNull
    public final C0682g1 d;

    @NotNull
    public final Logger e;
    public int f;

    public C0724k3(@NotNull Application applicationContext, @NotNull com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.a overlayLayoutManager, @NotNull PreferencesStore preferencesStore, @NotNull C0682g1 drawOverlaysChecker) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(overlayLayoutManager, "overlayLayoutManager");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(drawOverlaysChecker, "drawOverlaysChecker");
        this.a = applicationContext;
        this.b = overlayLayoutManager;
        this.c = preferencesStore;
        this.d = drawOverlaysChecker;
        this.e = new Logger("ClientModeNavigator");
    }

    public final boolean a() {
        if (!this.d.a(this.a)) {
            this.e.d("Cannot enable cs-in-app, permission not granted.");
            return false;
        }
        this.e.i("Client mode enabled");
        CsApplicationModule.getInstance(this.a).getSdkManager().a();
        ExtensionsKt.startServiceSafely(this.a, new Intent(this.a, (Class<?>) OverlayService.class));
        this.f = 1;
        return true;
    }
}
