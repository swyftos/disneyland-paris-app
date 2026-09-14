package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nConfigureFromDeepLink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigureFromDeepLink.kt\ncom/contentsquare/android/analytics/internal/features/deeplink/ConfigureFromDeepLink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
public final class C2931y0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f3257a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f3258b;

    public C2931y0(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f3257a = preferencesStore;
        this.f3258b = new Logger("ConfigureFromDeepLink");
    }
}
