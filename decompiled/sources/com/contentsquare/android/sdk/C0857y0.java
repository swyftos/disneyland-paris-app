package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nConfigureFromDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigureFromDeepLink.kt\ncom/contentsquare/android/analytics/internal/features/deeplink/ConfigureFromDeepLink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.y0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0857y0 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Logger b;

    public C0857y0(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = preferencesStore;
        this.b = new Logger("ConfigureFromDeepLink");
    }
}
