package com.contentsquare.android.sdk;

import android.app.Application;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2655W0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f2198a;

    public C2655W0(@NotNull Application applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f2198a = CoreModule.INSTANCE.safeInstance(applicationContext).getPreferencesStore();
    }
}
