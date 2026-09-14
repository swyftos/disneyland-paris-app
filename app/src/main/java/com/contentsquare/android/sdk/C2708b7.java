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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2708b7 extends AbstractC2878s7 {

    /* JADX INFO: renamed from: c */
    @NotNull
    public final HttpConnection f2417c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Logger f2418d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2708b7(@NotNull HttpConnection httpConnection, @NotNull DeviceInfo deviceInfo, @NotNull Configuration configuration) {
        super(deviceInfo, configuration);
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f2417c = httpConnection;
        this.f2418d = new Logger("TelemetryDCMonitorSubscriber");
    }

    /* JADX INFO: renamed from: a */
    public final void m1098a(JSONObject jSONObject) {
        String str;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "subscriberData.toString()");
        HttpResponse httpResponsePerformPostWithJson$default = HttpConnection.performPostWithJson$default(this.f2417c, UriBuilder.buildLogSdkMetricUrl$default(UriBuilder.INSTANCE, null, false, 3, null), string, null, 4, null);
        boolean zSuccess = httpResponsePerformPostWithJson$default.success();
        Logger logger = this.f2418d;
        if (zSuccess) {
            str = "Telemetry report successfully sent to DC monitor: " + jSONObject;
        } else {
            str = "Could not send the telemetry report to DC monitor: " + httpResponsePerformPostWithJson$default.getStatus() + '|' + httpResponsePerformPostWithJson$default.getStringResponse();
        }
        logger.m827d(str);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2878s7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final JSONObject mo1099b(@NotNull C2828n7 telemetryReport) {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = mo1179a(telemetryReport);
            m1098a(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f2418d, "cannot add header to telemetry report", e);
            return jSONObject;
        }
    }
}
