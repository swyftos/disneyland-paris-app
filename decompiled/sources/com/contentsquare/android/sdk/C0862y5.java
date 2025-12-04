package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.y5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0862y5 implements T3 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final DeviceInfo b;

    public C0862y5(@NotNull PreferencesStore preferencesStore, @NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.a = preferencesStore;
        this.b = deviceInfo;
    }

    @Override // com.contentsquare.android.sdk.T3
    @NotNull
    public final int a() {
        return c().getType();
    }

    @Override // com.contentsquare.android.sdk.T3
    public final boolean b() {
        return !Intrinsics.areEqual(c(), V3.a);
    }

    public final U3 c() {
        PreferencesStore preferencesStore = this.a;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        U3 w3 = new W3(preferencesStore);
        PreferencesStore preferencesStore2 = this.a;
        DeviceInfo deviceInfo = this.b;
        Intrinsics.checkNotNullParameter(preferencesStore2, "preferencesStore");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        X3 other = new X3(preferencesStore2, deviceInfo);
        Intrinsics.checkNotNullParameter(w3, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!w3.a()) {
            w3 = other.a() ? other : V3.a;
        }
        PreferencesStore preferencesStore3 = this.a;
        Intrinsics.checkNotNullParameter(preferencesStore3, "preferencesStore");
        Z3 other2 = new Z3(preferencesStore3);
        Intrinsics.checkNotNullParameter(w3, "<this>");
        Intrinsics.checkNotNullParameter(other2, "other");
        if (!w3.a()) {
            w3 = other2.a() ? other2 : V3.a;
        }
        PreferencesStore preferencesStore4 = this.a;
        Intrinsics.checkNotNullParameter(preferencesStore4, "preferencesStore");
        Y3 other3 = new Y3(preferencesStore4);
        Intrinsics.checkNotNullParameter(w3, "<this>");
        Intrinsics.checkNotNullParameter(other3, "other");
        return (w3.a() && other3.a()) ? w3 : V3.a;
    }
}
