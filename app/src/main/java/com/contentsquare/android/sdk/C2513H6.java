package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.H6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2513H6 implements InterfaceC2629T3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1690a;

    public C2513H6(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f1690a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2629T3
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int mo933a() {
        PreferencesStore preferencesStore = this.f1690a;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        InterfaceC2639U3 c2676y3 = new C2676Y3(preferencesStore);
        C2649V3.a other = C2649V3.f2192a;
        Intrinsics.checkNotNullParameter(c2676y3, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!c2676y3.mo1043a()) {
            c2676y3 = other;
        }
        return c2676y3.getType();
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2629T3
    /* JADX INFO: renamed from: b */
    public final boolean mo934b() {
        PreferencesStore preferencesStore = this.f1690a;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        InterfaceC2639U3 c2676y3 = new C2676Y3(preferencesStore);
        InterfaceC2639U3 other = C2649V3.f2192a;
        Intrinsics.checkNotNullParameter(c2676y3, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!c2676y3.mo1043a()) {
            c2676y3 = other;
        }
        return !Intrinsics.areEqual(c2676y3, other);
    }
}
