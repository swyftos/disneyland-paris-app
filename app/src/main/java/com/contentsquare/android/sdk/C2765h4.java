package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.h4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2765h4 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f2690a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public QualityLevel f2691b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public ConnectionType f2692c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Logger f2693d;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.h4$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f2694a;

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
            f2694a = iArr;
        }
    }

    public C2765h4(@NotNull DeviceInfo deviceInfo, @NotNull C2508H1 eventsProvidersManager) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        this.f2690a = eventsProvidersManager;
        this.f2691b = QualityLevel.HIGH;
        this.f2692c = deviceInfo.getActiveConnectionType();
        this.f2693d = new Logger("QualityChangeProvider");
    }
}
