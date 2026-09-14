package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2758g7 extends AbstractC2878s7 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2758g7(@NotNull DeviceInfo deviceInfo, @NotNull Configuration configuration) {
        super(deviceInfo, configuration);
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        new Logger("TelemetryLocalSubscriber");
    }

    @Override // com.contentsquare.android.sdk.AbstractC2878s7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final JSONObject mo1099b(@NotNull C2828n7 telemetryReport) {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        return new JSONObject();
    }
}
