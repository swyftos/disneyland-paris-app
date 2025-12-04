package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.UriBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.m7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0748m7 extends AbstractC0807s7 {

    @NotNull
    public final HttpConnection c;

    @NotNull
    public final Logger d;

    public C0748m7(DeviceInfo deviceInfo, Configuration configuration) {
        HttpConnection httpConnection = new HttpConnection();
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        super(deviceInfo, configuration);
        this.c = httpConnection;
        this.d = new Logger("TelemetryQASubscriber");
    }

    @Override // com.contentsquare.android.sdk.AbstractC0807s7
    @NotNull
    public final JSONObject a(@NotNull C0758n7 telemetryReport) {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        return telemetryReport.a;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0807s7
    @NotNull
    public final JSONObject b(@NotNull C0758n7 telemetryReport) {
        String str;
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        JSONObject jSONObject = telemetryReport.a;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "subscriberData.toString()");
        HttpResponse httpResponsePerformPostWithJson$default = HttpConnection.performPostWithJson$default(this.c, UriBuilder.buildLogSdkMetricUrl$default(UriBuilder.INSTANCE, null, true, 1, null), string, null, 4, null);
        boolean zSuccess = httpResponsePerformPostWithJson$default.success();
        Logger logger = this.d;
        if (zSuccess) {
            str = "Telemetry report successfully sent to Qa server: " + jSONObject;
        } else {
            str = "Could not send the telemetry report to Qa server: " + httpResponsePerformPostWithJson$default.getStatus() + '|' + httpResponsePerformPostWithJson$default.getStringResponse();
        }
        logger.p(str);
        return jSONObject;
    }
}
