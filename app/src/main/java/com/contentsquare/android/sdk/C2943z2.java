package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2943z2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f3306a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f3307b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2815m4 f3308c;

    public C2943z2(@NotNull PreferencesStore preferences, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f3306a = preferences;
        this.f3307b = logger;
        this.f3308c = new C2815m4();
    }
}
