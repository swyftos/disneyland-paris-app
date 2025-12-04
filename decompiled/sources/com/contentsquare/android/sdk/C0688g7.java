package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.g7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0688g7 extends AbstractC0807s7 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0688g7(@NotNull DeviceInfo deviceInfo, @NotNull Configuration configuration) {
        super(deviceInfo, configuration);
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        new Logger("TelemetryLocalSubscriber");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0807s7
    @NotNull
    public final JSONObject b(@NotNull C0758n7 telemetryReport) {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        return new JSONObject();
    }
}
