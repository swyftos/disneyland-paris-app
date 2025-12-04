package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.UriBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.b7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0638b7 extends AbstractC0807s7 {

    @NotNull
    public final HttpConnection c;

    @NotNull
    public final Logger d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0638b7(@NotNull HttpConnection httpConnection, @NotNull DeviceInfo deviceInfo, @NotNull Configuration configuration) {
        super(deviceInfo, configuration);
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.c = httpConnection;
        this.d = new Logger("TelemetryDCMonitorSubscriber");
    }

    public final void a(JSONObject jSONObject) {
        String str;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "subscriberData.toString()");
        HttpResponse httpResponsePerformPostWithJson$default = HttpConnection.performPostWithJson$default(this.c, UriBuilder.buildLogSdkMetricUrl$default(UriBuilder.INSTANCE, null, false, 3, null), string, null, 4, null);
        boolean zSuccess = httpResponsePerformPostWithJson$default.success();
        Logger logger = this.d;
        if (zSuccess) {
            str = "Telemetry report successfully sent to DC monitor: " + jSONObject;
        } else {
            str = "Could not send the telemetry report to DC monitor: " + httpResponsePerformPostWithJson$default.getStatus() + '|' + httpResponsePerformPostWithJson$default.getStringResponse();
        }
        logger.d(str);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0807s7
    @NotNull
    public final JSONObject b(@NotNull C0758n7 telemetryReport) {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = a(telemetryReport);
            a(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            Q2.a(this.d, "cannot add header to telemetry report", e);
            return jSONObject;
        }
    }
}
