package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2936y5 implements InterfaceC2629T3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f3261a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final DeviceInfo f3262b;

    public C2936y5(@NotNull PreferencesStore preferencesStore, @NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f3261a = preferencesStore;
        this.f3262b = deviceInfo;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2629T3
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int mo933a() {
        return m1236c().getType();
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2629T3
    /* JADX INFO: renamed from: b */
    public final boolean mo934b() {
        return !Intrinsics.areEqual(m1236c(), C2649V3.f2192a);
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC2639U3 m1236c() {
        PreferencesStore preferencesStore = this.f3261a;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        InterfaceC2639U3 c2658w3 = new C2658W3(preferencesStore);
        PreferencesStore preferencesStore2 = this.f3261a;
        DeviceInfo deviceInfo = this.f3262b;
        Intrinsics.checkNotNullParameter(preferencesStore2, "preferencesStore");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        C2667X3 other = new C2667X3(preferencesStore2, deviceInfo);
        Intrinsics.checkNotNullParameter(c2658w3, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!c2658w3.mo1043a()) {
            c2658w3 = other.mo1043a() ? other : C2649V3.f2192a;
        }
        PreferencesStore preferencesStore3 = this.f3261a;
        Intrinsics.checkNotNullParameter(preferencesStore3, "preferencesStore");
        C2685Z3 other2 = new C2685Z3(preferencesStore3);
        Intrinsics.checkNotNullParameter(c2658w3, "<this>");
        Intrinsics.checkNotNullParameter(other2, "other");
        if (!c2658w3.mo1043a()) {
            c2658w3 = other2.mo1043a() ? other2 : C2649V3.f2192a;
        }
        PreferencesStore preferencesStore4 = this.f3261a;
        Intrinsics.checkNotNullParameter(preferencesStore4, "preferencesStore");
        C2676Y3 other3 = new C2676Y3(preferencesStore4);
        Intrinsics.checkNotNullParameter(c2658w3, "<this>");
        Intrinsics.checkNotNullParameter(other3, "other");
        return (c2658w3.mo1043a() && other3.mo1043a()) ? c2658w3 : C2649V3.f2192a;
    }
}
