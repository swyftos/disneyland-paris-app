package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class H6 implements T3 {

    @NotNull
    public final PreferencesStore a;

    public H6(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.T3
    @NotNull
    public final int a() {
        PreferencesStore preferencesStore = this.a;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        U3 y3 = new Y3(preferencesStore);
        U3 other = V3.a;
        Intrinsics.checkNotNullParameter(y3, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!y3.a()) {
            y3 = other;
        }
        return y3.getType();
    }

    @Override // com.contentsquare.android.sdk.T3
    public final boolean b() {
        PreferencesStore preferencesStore = this.a;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        U3 y3 = new Y3(preferencesStore);
        U3 other = V3.a;
        Intrinsics.checkNotNullParameter(y3, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!y3.a()) {
            y3 = other;
        }
        return !Intrinsics.areEqual(y3, other);
    }
}
