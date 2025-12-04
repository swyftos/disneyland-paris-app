package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.l7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0738l7 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final DeviceInfo b;

    @NotNull
    public final Lazy c;

    @NotNull
    public final Lazy d;

    /* renamed from: com.contentsquare.android.sdk.l7$a */
    public static final class a extends Lambda implements Function0<C0862y5> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C0862y5 invoke() {
            C0738l7 c0738l7 = C0738l7.this;
            return new C0862y5(c0738l7.a, c0738l7.b);
        }
    }

    /* renamed from: com.contentsquare.android.sdk.l7$b */
    public static final class b extends Lambda implements Function0<H6> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final H6 invoke() {
            return new H6(C0738l7.this.a);
        }
    }

    public C0738l7(@NotNull PreferencesStore preferencesStore, @NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.a = preferencesStore;
        this.b = deviceInfo;
        this.c = LazyKt.lazy(new a());
        this.d = LazyKt.lazy(new b());
    }
}
