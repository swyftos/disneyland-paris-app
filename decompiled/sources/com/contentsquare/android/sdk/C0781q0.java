package com.contentsquare.android.sdk;

import android.app.Application;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.q0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0781q0 {

    @NotNull
    public final PreferencesStore a;

    public C0781q0(@NotNull Application applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.a = CoreModule.INSTANCE.safeInstance(applicationContext).getPreferencesStore();
    }
}
