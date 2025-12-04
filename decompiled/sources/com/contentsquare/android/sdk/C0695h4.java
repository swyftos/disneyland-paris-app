package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.h4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0695h4 {

    @NotNull
    public final H1 a;

    @NotNull
    public QualityLevel b;

    @NotNull
    public ConnectionType c;

    @NotNull
    public final Logger d;

    /* renamed from: com.contentsquare.android.sdk.h4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConnectionType.values().length];
            try {
                iArr[ConnectionType.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConnectionType.CONNECTIVITY_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConnectionType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public C0695h4(@NotNull DeviceInfo deviceInfo, @NotNull H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.a = eventsProvidersManager;
        this.b = QualityLevel.HIGH;
        this.c = deviceInfo.getActiveConnectionType();
        this.d = new Logger("QualityChangeProvider");
    }
}
