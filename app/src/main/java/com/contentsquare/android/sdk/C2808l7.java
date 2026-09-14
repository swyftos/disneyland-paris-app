package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2808l7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f2857a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final DeviceInfo f2858b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Lazy f2859c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Lazy f2860d;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.l7$a */
    public static final class a extends Lambda implements Function0<C2936y5> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2936y5 invoke() {
            C2808l7 c2808l7 = C2808l7.this;
            return new C2936y5(c2808l7.f2857a, c2808l7.f2858b);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.l7$b */
    public static final class b extends Lambda implements Function0<C2513H6> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C2513H6 invoke() {
            return new C2513H6(C2808l7.this.f2857a);
        }
    }

    public C2808l7(@NotNull PreferencesStore preferencesStore, @NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f2857a = preferencesStore;
        this.f2858b = deviceInfo;
        this.f2859c = LazyKt.lazy(new a());
        this.f2860d = LazyKt.lazy(new b());
    }
}
