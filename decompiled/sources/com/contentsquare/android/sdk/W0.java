package com.contentsquare.android.sdk;

import android.app.Application;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class W0 {

    @NotNull
    public final PreferencesStore a;

    public W0(@NotNull Application applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.a = CoreModule.INSTANCE.safeInstance(applicationContext).getPreferencesStore();
    }
}
