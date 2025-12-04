package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.z2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0868z2 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Logger b;

    @NotNull
    public final C0745m4 c;

    public C0868z2(@NotNull PreferencesStore preferences, @NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = preferences;
        this.b = logger;
        this.c = new C0745m4();
    }
}
